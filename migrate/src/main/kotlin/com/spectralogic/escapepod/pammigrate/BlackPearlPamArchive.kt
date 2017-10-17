package com.spectralogic.escapepod.pammigrate

import com.google.common.collect.ImmutableMap
import com.spectralogic.ds3client.Ds3Client
import com.spectralogic.ds3client.helpers.Ds3ClientHelpers
import com.spectralogic.ds3client.models.bulk.Ds3Object
import com.spectralogic.escapepod.api.AssetType
import com.spectralogic.escapepod.api.BpClientFactory
import com.spectralogic.escapepod.api.FileLocation
import com.spectralogic.escapepod.avidpamwsclient.AvidPamWsClient
import com.spectralogic.escapepod.avidpamwsclient.PamMetadataAccess
import com.spectralogic.escapepod.avidpamwsclient.mobid
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.rxkotlin.zipWith
import org.slf4j.LoggerFactory
import java.nio.channels.FileChannel
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import java.util.concurrent.Executor
import java.util.concurrent.ForkJoinPool

//TODO blackPearlFactory should be injected once ready
class BlackPearlPamArchive(private val blackPearlClientFactory: BpClientFactory,
                           private val executor: Executor = ForkJoinPool.commonPool()) {

    companion object {
        private val LOG = LoggerFactory.getLogger(BlackPearlPamArchive::class.java)
    }

    fun archivePamToBlackPearl(avidPamWsClient: AvidPamWsClient, blackPearl: String, bucket: String, interplayURI: String): Completable {
        return isMasterClip(avidPamWsClient, interplayURI).flatMapCompletable { isMasterClip ->
            if (isMasterClip) {
                archivePamAssetToBlackPearl(avidPamWsClient, interplayURI, blackPearl, bucket)
            } else {
                archivePamSequenceToBlackPearl(avidPamWsClient, interplayURI, blackPearl, bucket)
            }
        }
    }

    private fun isMasterClip(avidPamWsClient: AvidPamWsClient, interplayURI: String): Single<Boolean> {
        return avidPamWsClient.getAssetType(interplayURI).flatMap { type ->
            if (type == AssetType.MASTERCLIP) {
                Single.just(true)
            } else {
                Single.just(false)
            }
        }
    }

    private fun archivePamAssetToBlackPearl(avidPamWsClient: AvidPamWsClient, interplayURI: String, blackPearl: String, bucket: String): Completable {
        return archive(blackPearl, bucket, avidPamWsClient.getFileLocations(interplayURI))
    }

    private fun archivePamSequenceToBlackPearl(avidPamWsClient: AvidPamWsClient, interplayURI: String, blackPearl: String, bucket: String): Completable {
        return archive(blackPearl, bucket,
                avidPamWsClient.getSequenceRelatives(interplayURI)
                        .map { sequenceRelative -> sequenceRelative.interplayURI }
                        .flatMap(avidPamWsClient::getFileLocations))
    }

    private fun archive(blackPearl: String, bucket: String, fileLocationObservable: Observable<FileLocation>): Completable {
        val mapBuilder = ImmutableMap.builder<String, String>()
        val pamMetadataAccess = PamMetadataAccess()

        return fileLocationObservable.map { fileLocation ->
            val mobid = fileLocation.interplayURI.mobid()
            mapBuilder.put(mobid, fileLocation.filePath)

            pamMetadataAccess.addMetadataValue(
                    mobid,
                    ImmutableMap.of(
                            "clipid", fileLocation.clipId,
                            "filename", fileLocation.filePath,
                            "filesize", fileLocation.size.toString(),
                            "fileid", mobid,
                            "fileresolution", fileLocation.format
                    ))


            Ds3Object(mobid, fileLocation.size)
        }.toList()
                .zipWith(blackPearlClientFactory.createBpClient(blackPearl))
                .flatMapCompletable { (objectsToTransfer, ds3Client) ->
                    transfer(ds3Client, bucket, objectsToTransfer, mapBuilder.build(), pamMetadataAccess)
                }
    }

    private fun transfer(ds3Client: Ds3Client, bucket: String, objectsToTransfer: Iterable<Ds3Object>, fileMap: ImmutableMap<String, String>, pamMetadataAccess: PamMetadataAccess): Completable {
        return Completable.create { emitter ->
            executor.execute {
                try {
                    LOG.info("Ensure bucket '$bucket' exists")
                    val blackPearlClientHelpers = Ds3ClientHelpers.wrap(ds3Client)
                    blackPearlClientHelpers.ensureBucketExists(bucket)

                    val job = blackPearlClientHelpers.startWriteJob(bucket, objectsToTransfer)
                    LOG.info("Job ${job.jobId} was created")

                    job.attachObjectCompletedListener { it ->
                        LOG.info("Finished archiving $it")
                    }

                    job.withMetadata(pamMetadataAccess)

                    job.transfer { key ->
                        FileChannel.open(Paths.get(fileMap[key]), StandardOpenOption.READ)
                    }

                    emitter.onComplete()

                } catch (t: Throwable) {
                    emitter.onError(t)
                }
            }
        }
    }
}

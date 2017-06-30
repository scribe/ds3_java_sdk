package com.greyrock.escapepod.migrate

import com.google.common.collect.ImmutableList
import com.google.inject.Guice
import com.spectralogic.ds3client.Ds3ClientBuilder
import com.spectralogic.ds3client.helpers.Ds3ClientHelpers
import com.spectralogic.ds3client.helpers.channelbuilders.ReadOnlySeekableByteChannel
import com.spectralogic.ds3client.models.bulk.Ds3Object
import com.spectralogic.ds3client.models.common.Credentials
import com.spectralogic.escapepod.api.DivaClientFactory
import com.spectralogic.escapepod.avidmamclient.AvidMamDbClientFactory
import com.spectralogic.escapepod.avidmamclient.AvidMamRetrofitClient
import com.spectralogic.escapepod.divaclient.DivaClientGuiceModule
import com.spectralogic.escapepod.restclientutils.RetrofitClientFactoryImpl
import com.spectralogic.escapepod.util.ordinalIndexOf
import com.spectralogic.tpfr.api.ServerServiceFactoryImpl
import com.spectralogic.tpfr.client.ClientImpl
import com.spectralogic.tpfr.client.model.IndexResult
import io.reactivex.Observable
import io.reactivex.Single
import jcifs.smb.NtlmPasswordAuthentication
import jcifs.smb.SmbFile
import org.junit.Test
import org.assertj.core.api.Assertions.*
import java.nio.channels.Channels

internal class MigrateFromDiva_Test {

    @Test
    fun marquisIndex() {
        val serverServiceFactory = ServerServiceFactoryImpl("http://10.129.156.49:60792")

        val clientImpl = ClientImpl(serverServiceFactory.createServerService())

        val indexStatus = Single.fromFuture(clientImpl.indexFile("\\\\10.129.154.30\\vol2\\SM_DV-based_25_576i_25ndf_2s4f_v0_20170524122308.mxf")).blockingGet()

        if (indexStatus.indexResult == IndexResult.Failed) {
            println("Failed to index: " + indexStatus.errorMessage)
        }

        assertThat(indexStatus.indexResult).isEqualTo(IndexResult.Succeeded)
    }

    @Test
    fun marquisFileStatus() {
        val serverServiceFactory = ServerServiceFactoryImpl("http://10.129.156.49:60792")

        val clientImpl = ClientImpl(serverServiceFactory.createServerService())

        val indexStatus = Single.fromFuture(clientImpl.fileStatus("\\\\10.129.154.30\\vol2\\SM_DV-based_25_576i_25ndf_2s4f_v0_20170524122308.mxf")).blockingGet()

        if (indexStatus.indexResult == IndexResult.Failed) {
            println("Failed to index: " + indexStatus.errorMessage)
        }

        assertThat(indexStatus.indexResult).isEqualTo(IndexResult.Succeeded)
    }

    @Test
    fun manualMigrate() {

        // Tell Diva to migrate asset to verde
        // Once asset is on Verde, tell marquis to index the file
        // Once the file has been indexed, copy the index to the MAM system
        // Once the index has been copied, move the object from verde to Black Pearl and store the index location as metadata

        val divaEndpoint = "http://kl-diva7:9763"
        val marquisEndpoint = "http://192.168.56.101:60792"
        val objectToMigrate = "Op1aToOpAtomConverterTest_IMX40_20170628065800.mxf"
        val category = "DEFAULT"
        val divaDestination = "verde2"
        val destinationPath = ""
        val verdePath = "\\\\10.129.154.30\\vol2"
        val filePathOnVerde = "$verdePath\\$objectToMigrate"
        val bpEndpoint = "10.129.154.27"
        val bpAccessId = "ZXJpY2FuZHJl"
        val bpSecretKey = "jeVwTcbN"
        val bpBucket = "migration_test"
        val mamEndpoint = "http://10.129.156.54:9910"
        val divaClientGuiceModule = DivaClientGuiceModule()

        val injector = Guice.createInjector(divaClientGuiceModule)
        val divaClientFactory = injector.getInstance(DivaClientFactory::class.java)

        println("========== Moving file from Diva ==========")
        // 1 copy the file to verde
        val divaClient = divaClientFactory.create(divaEndpoint)

        val restoreId = divaClient.restore(objectToMigrate, category, divaDestination, destinationPath).blockingGet()

        while(true) {
            val restoreStatus = divaClient.restoreStatus(restoreId).blockingGet()

            assertThat(restoreStatus.requestState).isNotEqualTo(4).isNotEqualTo(5)
            if (restoreStatus.requestState == 3) {
                break
            } else {
                Thread.sleep(1000)
            }
        }

        println("========== Indexing File with Marquis ==========")
        // The file has been restored from diva to verde
        // 2 index the file with marquis
        val tpfrServiceFactory = ServerServiceFactoryImpl(marquisEndpoint)
        val tpfrClient = ClientImpl(tpfrServiceFactory.createServerService())
        val indexStatus = Single.fromFuture(tpfrClient.indexFile(filePathOnVerde)).blockingGet()

        assertThat(indexStatus.indexResult).isEqualTo(IndexResult.Succeeded)


        println("========== Copying index files to MAM ==========")
        // 3 copy the index file to the mam
        // there should be 2 files, an xml and mov file

        val retrofitClientFactoryImpl = RetrofitClientFactoryImpl()
        val avidMamRetrofitClient = retrofitClientFactoryImpl.createRestClient(mamEndpoint, AvidMamRetrofitClient::class.java)

        val indexPathPrefixResponse = avidMamRetrofitClient.getKey("SpectraBlackPearlConnector_1", "Config/TpfrResultFolder").blockingGet()

        val value = indexPathPrefixResponse.value
        val ordinalIndexOfSlash = value.ordinalIndexOf("\\", 4)
        val pathPrefix = value.substring(0, ordinalIndexOfSlash)

        val mamPrfIndexPath = pathPrefix + "\\PFR-INDEX"
        val verdePfrIndexPath = verdePath + "\\PFR-INDEX"

        val copyAsyncResponse = avidMamRetrofitClient.directoryCopyAsync(verdePfrIndexPath, mamPrfIndexPath, "false").blockingGet()

        while(true) {
            val getJobStatus = avidMamRetrofitClient.getJobStatus(copyAsyncResponse.value).blockingGet()

            assertThat(getJobStatus.error).isFalse()
            if (getJobStatus.percent == 100F) {
                break
            } else {
                Thread.sleep(1000)
            }
        }

        println("========== Copying file to BP ==========")
        //4 copy the data to black pearl
        val ds3Client = Ds3ClientBuilder.create(bpEndpoint, Credentials(bpAccessId, bpSecretKey)).withHttps(false).build()
        val ds3Helpers = Ds3ClientHelpers.wrap(ds3Client)

        ds3Helpers.ensureBucketExists(bpBucket)

        val fileToCopyToBp = "smb://10.129.154.30/vol2/$objectToMigrate"
        val ntlmPasswordAuthentication = NtlmPasswordAuthentication("", "Administrator", "spectra")
        val smbFile = SmbFile(fileToCopyToBp, ntlmPasswordAuthentication)

        val objectList = ImmutableList.of(Ds3Object(objectToMigrate, smbFile.contentLengthLong))

        val startWriteJob = ds3Helpers.startWriteJob(bpBucket, objectList)

        startWriteJob.transfer { _ ->
            val readableByteChannel = Channels.newChannel(smbFile.inputStream)
            ReadOnlySeekableByteChannel(readableByteChannel)
        }
    }

    @Test
    fun testDivaFileListFromMam() {

        val divaEndpoint = "http://kl-diva7:9763"

        val avidMamDbClientFactory = AvidMamDbClientFactory()
        val injector = Guice.createInjector(DivaClientGuiceModule())
        val divaClientFactory = injector.getInstance(DivaClientFactory::class.java)

        val avidDbClient = avidMamDbClientFactory.createClient("kl-pm-mam59a", "sa", "M8nichts")
        val divaClient = divaClientFactory.create(divaEndpoint)

        val listDivaAssets = avidDbClient.listDivaAssets()

        Observable
                .fromIterable(listDivaAssets.asIterable())
                .doOnNext { (fileName, category) ->
                    println("FileName: $fileName, Category: $category")
                }
                .flatMap { (fileName, category) ->
                    divaClient.objectInfo(fileName, category).toObservable()
                }
                .flatMap { objectInfo ->
                    Observable.fromIterable(objectInfo.files.asIterable())
                }
                .doOnNext { file ->
                    println("File In Diva: $file")
                }
                .subscribe()
    }

    @Test
    fun testPathPrefixLogic() {

        val path = "\\\\10.129.154.30\\vol2\\path\\file.txt"

        val ordinalIndexOfSlash = path.ordinalIndexOf("\\", 4)
        val pathPrefix = path.substring(0, ordinalIndexOfSlash)

        assertThat(pathPrefix).isEqualTo("\\\\10.129.154.30\\vol2")

    }

    @Test
    fun testUncPathResolution() {
        val path = "smb://10.129.154.30/vol2/Op1aToOpAtomConverterTest_IMX40_20170628065742.mxf"

        val ntlmPasswordAuthentication = NtlmPasswordAuthentication("", "Administrator", "spectra")

        val smbFile = SmbFile(path, ntlmPasswordAuthentication)

        assertThat(smbFile.exists()).isTrue()

        val contentLength = smbFile.contentLengthLong
        assertThat(contentLength).isGreaterThan(0)

        println(contentLength)
    }
}

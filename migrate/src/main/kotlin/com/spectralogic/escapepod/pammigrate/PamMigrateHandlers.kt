package com.spectralogic.escapepod.pammigrate

import com.spectralogic.ds3client.Ds3Client
import com.spectralogic.ds3client.Ds3ClientBuilder
import com.spectralogic.ds3client.models.common.Credentials
import com.spectralogic.escapepod.api.AvidPamWsClientBuilder
import com.spectralogic.escapepod.api.BpClientFactory
import io.reactivex.Completable
import io.reactivex.Single
import org.slf4j.LoggerFactory
import javax.inject.Inject

class PamMigrateHandlers
@Inject constructor(private val avidPamWsClientBuilder: AvidPamWsClientBuilder)
{

    private companion object {
        private val LOG = LoggerFactory.getLogger(PamMigrateHandlers::class.java)

        //TODO needs to be configurable
        private val BP_ENDPOINT = "10.1.19.204"
        private val ACCESS_ID = "c2hhcm9u"
        private val SECRET_KEY = "qawsedrf"
    }

    private var blackPearlPamArchive: BlackPearlPamArchive

    init {
        val ds3Client = Ds3ClientBuilder.create(BP_ENDPOINT, Credentials(ACCESS_ID, SECRET_KEY))
                .withHttps(false)
                .build()

        //TODO needs to be injected
        class BlackPearlClientFactoryImpl : BpClientFactory {
            override fun createBpClient(clientName: String): Single<Ds3Client> {
                return when (clientName) {
                    "sm25-2" -> Single.just(ds3Client)
                    else -> Single.error(Throwable("BlackPeal '$clientName' is not configured in the database."))
                }
            }
        }

        val blackPearlClientFactoryImpl = BlackPearlClientFactoryImpl()
        blackPearlPamArchive = BlackPearlPamArchive(blackPearlClientFactoryImpl)
    }

    fun archivePamAssetToBlackPearl(name: String, mobid: String, blackPearl: String, bucket: String): Completable {
        return avidPamWsClientBuilder.buildAvidPamWsClient(name).flatMapCompletable { avidPamWsClient ->
            LOG.info("Archiving '$mobid' to Black Pearl '$blackPearl' using bucket '$bucket' from pam system '$name'")
            blackPearlPamArchive.archivePamToBlackPearl(avidPamWsClient, blackPearl, bucket, mobid)
        }
    }
}
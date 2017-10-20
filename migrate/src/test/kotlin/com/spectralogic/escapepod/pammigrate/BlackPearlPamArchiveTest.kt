package com.spectralogic.escapepod.pammigrate

import com.google.common.collect.ImmutableMap
import com.spectralogic.ds3client.Ds3Client
import com.spectralogic.ds3client.Ds3ClientBuilder
import com.spectralogic.ds3client.commands.HeadObjectRequest
import com.spectralogic.ds3client.helpers.Ds3ClientHelpers
import com.spectralogic.ds3client.models.common.Credentials
import com.spectralogic.escapepod.api.AvidPamWsClient
import com.spectralogic.escapepod.api.BpClientFactory
import com.spectralogic.escapepod.avidpamwsclient.AvidPamWsClientImpl
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.assertj.core.api.Assertions
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.Mockito

internal class BlackPearlPamArchiveTest {

    private companion object {

        //Avid WS info
        private val NAME = "test"
        private val USERNAME = "spectra"
        private val PASSWORD = ""
        private val ENDPOINT = "10.1.2.164:80"
        private val WORKGROUP = "AvidWorkgroup"

        //BP info
        private val BP_ENDPOINT = "10.1.19.204"
        private val ACCESS_ID = "c2hhcm9u"
        private val SECRET_KEY = "qawsedrf"

        private lateinit var avidPamWsClientImpl: AvidPamWsClient
        private lateinit var blackPearlPamArchive: BlackPearlPamArchive

        private lateinit var CLIENT: Ds3Client
        private lateinit var HELPERS: Ds3ClientHelpers

        @BeforeClass
        @JvmStatic
        fun beforeClass() {
            val ds3Client = Ds3ClientBuilder.create(BP_ENDPOINT, Credentials(ACCESS_ID, SECRET_KEY))
                    .withHttps(false)
                    .build()

            val bpClientFactory = Mockito.mock(BpClientFactory::class.java)
            Mockito.`when`(bpClientFactory.createBpClient(BP_ENDPOINT))
                    .thenReturn(Single.just(ds3Client))

            blackPearlPamArchive = BlackPearlPamArchive(bpClientFactory)

            CLIENT = ds3Client
            HELPERS = Ds3ClientHelpers.wrap(CLIENT)

            avidPamWsClientImpl = AvidPamWsClientImpl(NAME, USERNAME, PASSWORD, ENDPOINT, WORKGROUP)
        }

        @AfterClass
        @JvmStatic
        fun afterClass() {

        }
    }

    @Test
    fun archiveMasterClipToBlackPearlTest() {
        val bucket = "archiveMasterClipToBlackPearlTest"

        try {
            val mobid = "060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80"

            val observable = blackPearlPamArchive.archivePamToBlackPearl(avidPamWsClientImpl, BP_ENDPOINT, bucket, mobid)
                    .toObservable<Unit>()
            val testObserver = TestObserver<Unit>()

            observable.subscribe(testObserver)

            testObserver.awaitTerminalEvent()
            testObserver
                    .assertNoErrors()
                    .assertComplete()

            val expected = ImmutableMap.of<String, ImmutableMap<String, String>>(
                    "060a2b340101010101010f0013-000000-59de815c2624026a-060e2b347f7f-2a80",
                    ImmutableMap.of(
                            "filesize", "9858712161",
                            "clipid", "060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80",
                            "filename", "\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-38.1\\wg2_ams3_dv01.59de859de815c.mxf",
                            "fileid", "060a2b340101010101010f0013-000000-59de815c2624026a-060e2b347f7f-2a80",
                            "fileresolution", "DNxHD 1080 115-120-145"
                    ),
                    "060a2b340101010101010f0013-000000-59de815c2632026a-060e2b347f7f-2a80",
                    ImmutableMap.of(
                            "filesize", "83886689",
                            "clipid", "060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80",
                            "filename", "\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-38.1\\wg2_ams3_da01.59de859de815c.mxf",
                            "fileid", "060a2b340101010101010f0013-000000-59de815c2632026a-060e2b347f7f-2a80",
                            "fileresolution", "PCM"
                    ),
                    "060a2b340101010101010f0013-000000-59de815c2633026a-060e2b347f7f-2a80",
                    ImmutableMap.of(
                            "filesize", "83886689",
                            "clipid", "060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80",
                            "filename", "\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-38.1\\wg2_ams3_da02.59de859de815c.mxf",
                            "fileid", "060a2b340101010101010f0013-000000-59de815c2633026a-060e2b347f7f-2a80",
                            "fileresolution", "PCM"
                    ),
                    "060a2b340101010101010f0013-000000-59de815c2634026a-060e2b347f7f-2a80",
                    ImmutableMap.of(
                            "filesize", "965729",
                            "clipid", "060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80",
                            "filename", "\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-38.1\\wg2_ams3_dd01.59de859de815c.mxf",
                            "fileid", "060a2b340101010101010f0013-000000-59de815c2634026a-060e2b347f7f-2a80",
                            "fileresolution", "Data"
                    )
            )

            HELPERS.listObjects(bucket).forEach { obj ->
                val md = CLIENT.headObject(HeadObjectRequest(bucket, obj.key)).metadata
                md.keys().forEach { key ->
                    Assertions.assertThat(md.get(key)[0]).isEqualTo(expected[obj.key].orEmpty()[key])
                }
            }
        } finally {
            HELPERS.deleteBucket(bucket)
        }
    }

    @Test
    fun archiveSequenceToBlackPearlTest() {
        val bucket = "archiveSequenceToBlackPearlTest"
        try {
            val mobid = "060a2b340101010101010f0013-000000-59d6baef37175864-060e2b347f7f-2a80"

            val observable = blackPearlPamArchive.archivePamToBlackPearl(avidPamWsClientImpl, BP_ENDPOINT, bucket, mobid).toObservable<Unit>()
            val testObserver = TestObserver<Unit>()

            observable.subscribe(testObserver)

            testObserver.awaitTerminalEvent()
            testObserver
                    .assertNoErrors()
                    .assertComplete()

            val expectedBuilder = ImmutableMap.builder<String, ImmutableMap<String, String>>()
            expectedBuilder.put(
                    "060a2b340101010101010f0013-000000-59dbb5ab20646bd7-060e2b347f7f-2a80",
                    ImmutableMap.of(
                            "filesize", "92275297",
                            "clipid", "060a2b340101010101010f0013-000000-59dbb5ab20636bd7-060e2b347f7f-2a80",
                            "filename", "\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-35.1\\wg2_ams3_da01.59dbb59dbb5ab.mxf",
                            "fileid", "060a2b340101010101010f0013-000000-59dbb5ab20646bd7-060e2b347f7f-2a80",
                            "fileresolution", "PCM"
                    )
            )
            expectedBuilder.put(
                    "060a2b340101010101010f0013-000000-59dbb5af30996bd7-060e2b347f7f-2a80",
                    ImmutableMap.of(
                            "filesize", "10905191009",
                            "clipid", "060a2b340101010101010f0013-000000-59dbb5af30986bd7-060e2b347f7f-2a80",
                            "filename", "\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-35.1\\wg2_ams3_dv01.59dbb59dbb5af.mxf",
                            "fileid", "060a2b340101010101010f0013-000000-59dbb5af30996bd7-060e2b347f7f-2a80",
                            "fileresolution", "DNxHD 1080 115-120-145"
                    )
            )
            expectedBuilder.put(
                    "060a2b340101010101010f0013-000000-59dbb5af30b76bd7-060e2b347f7f-2a80",
                    ImmutableMap.of(
                            "filesize", "92275297",
                            "clipid", "060a2b340101010101010f0013-000000-59dbb5af30986bd7-060e2b347f7f-2a80",
                            "filename", "\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-35.1\\wg2_ams3_da02.59dbb59dbb5af.mxf",
                            "fileid", "060a2b340101010101010f0013-000000-59dbb5af30b76bd7-060e2b347f7f-2a80",
                            "fileresolution", "PCM"
                    )
            )
            expectedBuilder.put(
                    "060a2b340101010101010f0013-000000-59dbb5af30b86bd7-060e2b347f7f-2a80",
                    ImmutableMap.of(
                            "filesize", "1116001",
                            "clipid", "060a2b340101010101010f0013-000000-59dbb5af30986bd7-060e2b347f7f-2a80",
                            "filename", "\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-35.1\\wg2_ams3_dd01.59dbb59dbb5af.mxf",
                            "fileid", "060a2b340101010101010f0013-000000-59dbb5af30b86bd7-060e2b347f7f-2a80",
                            "fileresolution", "Data"
                    )
            )
            expectedBuilder.put(
                    "060a2b340101010101010f0013-000000-59de815c2624026a-060e2b347f7f-2a80",
                    ImmutableMap.of(
                            "filesize", "9858712161",
                            "clipid", "060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80",
                            "filename", "\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-38.1\\wg2_ams3_dv01.59de859de815c.mxf",
                            "fileid", "060a2b340101010101010f0013-000000-59de815c2624026a-060e2b347f7f-2a80",
                            "fileresolution", "DNxHD 1080 115-120-145"
                    )
            )
            expectedBuilder.put(
                    "060a2b340101010101010f0013-000000-59de815c2632026a-060e2b347f7f-2a80",
                    ImmutableMap.of(
                            "filesize", "83886689",
                            "clipid", "060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80",
                            "filename", "\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-38.1\\wg2_ams3_da01.59de859de815c.mxf",
                            "fileid", "060a2b340101010101010f0013-000000-59de815c2632026a-060e2b347f7f-2a80",
                            "fileresolution", "PCM"
                    )
            )
            expectedBuilder.put(
                    "060a2b340101010101010f0013-000000-59de815c2633026a-060e2b347f7f-2a80",
                    ImmutableMap.of(
                            "filesize", "83886689",
                            "clipid", "060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80",
                            "filename", "\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-38.1\\wg2_ams3_da02.59de859de815c.mxf",
                            "fileid", "060a2b340101010101010f0013-000000-59de815c2633026a-060e2b347f7f-2a80",
                            "fileresolution", "PCM"
                    )
            )
            expectedBuilder.put(
                    "060a2b340101010101010f0013-000000-59de815c2634026a-060e2b347f7f-2a80",
                    ImmutableMap.of(
                            "filesize", "965729",
                            "clipid", "060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80",
                            "filename", "\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-38.1\\wg2_ams3_dd01.59de859de815c.mxf",
                            "fileid", "060a2b340101010101010f0013-000000-59de815c2634026a-060e2b347f7f-2a80",
                            "fileresolution", "Data"
                    )
            )
            val expected = expectedBuilder.build()

            HELPERS.listObjects(bucket).forEach { obj ->
                val md = CLIENT.headObject(HeadObjectRequest(bucket, obj.key)).metadata
                md.keys().forEach { key ->
                    Assertions.assertThat(md.get(key)[0]).isEqualTo(expected[obj.key].orEmpty()[key])
                }
            }
        } finally {
            HELPERS.deleteBucket(bucket)
        }
    }
}
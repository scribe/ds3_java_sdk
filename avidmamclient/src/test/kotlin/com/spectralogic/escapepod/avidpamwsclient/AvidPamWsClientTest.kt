package com.spectralogic.escapepod.avidpamwsclient

import com.google.common.collect.ImmutableMap
import com.spectralogic.ds3client.Ds3Client
import com.spectralogic.ds3client.Ds3ClientBuilder
import com.spectralogic.ds3client.commands.HeadObjectRequest
import com.spectralogic.ds3client.helpers.Ds3ClientHelpers
import com.spectralogic.ds3client.models.common.Credentials
import com.spectralogic.escapepod.api.*
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.fail
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

internal class AvidPamWsClientTest {

    private companion object {

        //Avid WS info
        private val USERNAME = "spectra"
        private val PASSWORD = ""
        private val ENDPOINT = "10.1.2.164:80"

        //BP info
        private val BP_ENDPOINT = "10.1.19.204"
        private val ACCESS_ID = "c2hhcm9u"
        private val SECRET_KEY = "qawsedrf"

        private lateinit var avidPamWsClient: AvidPamWsClient
        private lateinit var bpClientFactory: BpClientFactory

        private lateinit var CLIENT: Ds3Client
        private lateinit var HELPERS: Ds3ClientHelpers

        @BeforeClass
        @JvmStatic
        fun beforeClass() {
            val ds3Client = Ds3ClientBuilder.create(BP_ENDPOINT, Credentials(ACCESS_ID, SECRET_KEY))
                    .withHttps(false)
                    .build()

            bpClientFactory = mock(BpClientFactory::class.java)
            Mockito.`when`(bpClientFactory.createBpClient(BP_ENDPOINT))
                    .thenReturn(Single.just(ds3Client))

            CLIENT = bpClientFactory.createBpClient(BP_ENDPOINT).blockingGet()
            HELPERS = Ds3ClientHelpers.wrap(CLIENT)

            avidPamWsClient = AvidPamWsClient(USERNAME, PASSWORD, ENDPOINT, bpClientFactory, BP_ENDPOINT, Executors.newSingleThreadExecutor())
        }

        @AfterClass
        @JvmStatic
        fun afterClass() {

        }
    }

    @Test
    fun getChildrenTest() {
        val interplayURI = "interplay://AvidWorkgroup/Incoming Media/SpectraLogic1/escape_pod_test"

        val observable = avidPamWsClient.getPamAssets(interplayURI)
        val testObserver = TestObserver<PamAsset>()

        observable.subscribe(testObserver)

        val expected = setOf(
                PamAsset("interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80", "060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80", "/Incoming Media/SpectraLogic1/escape_pod_test/060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80", "WG2_AMS3_DNx145_Vadym.16.new.02", "9792432", "online", "masterclip"),
                PamAsset("interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59d6baef37175864-060e2b347f7f-2a80", "060a2b340101010101010f0013-000000-59d6baef37175864-060e2b347f7f-2a80", "/Incoming Media/SpectraLogic1/escape_pod_test/060a2b340101010101010f0013-000000-59d6baef37175864-060e2b347f7f-2a80", "escape_pod_sequence", "N/A", "online", "sequence"),
                PamAsset("interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59dbb5af30986bd7-060e2b347f7f-2a80", "060a2b340101010101010f0013-000000-59dbb5af30986bd7-060e2b347f7f-2a80", "/Incoming Media/SpectraLogic1/escape_pod_test/060a2b340101010101010f0013-000000-59dbb5af30986bd7-060e2b347f7f-2a80", "WG2_AMS3_DNx145_Vadym.15.new.02", "10823314", "online", "masterclip"),
                PamAsset("interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59dbb5ab20636bd7-060e2b347f7f-2a80", "060a2b340101010101010f0013-000000-59dbb5ab20636bd7-060e2b347f7f-2a80", "/Incoming Media/SpectraLogic1/escape_pod_test/060a2b340101010101010f0013-000000-59dbb5ab20636bd7-060e2b347f7f-2a80", "WG2_AMS3_DNx145_Vadym.14.new.02", "12575270", "online", "masterclip")
        )

        testObserver.awaitTerminalEvent()
        testObserver
                .assertNoErrors()
                .assertComplete()
                .assertValueCount(4)
                .assertValueSet(expected)
    }

    @Test
    fun getProfilesTest() {
        val workgroupURI = "interplay://AvidWorkgroup"
        val services = arrayOf("com.avid.dms.restore", "com.avid.dms.archive")
        val showParameters = true

        val observable = avidPamWsClient.getPamProfiles(workgroupURI, services, showParameters)
        val testObserver = TestObserver<PamProfile>()

        observable.subscribe(testObserver)

        testObserver.awaitTerminalEvent()
        testObserver
                .assertNoErrors()
                .assertComplete()
                .assertValueCount(8)
    }

    @Test
    fun restoreTest() {
        val profile = "BlackPearl"
        val interplayURI = "interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80"

        val observable = avidPamWsClient.restorePamAsset(profile, interplayURI).toObservable()
        val testObserver = TestObserver<PamJob>()

        observable.subscribe(testObserver)

        testObserver.awaitTerminalEvent()
        testObserver
                .assertNoErrors()
                .assertComplete()
                .assertValueCount(1)
                .values().forEach {
            assertThat(it).isNotNull()
            assertThat(it.interplayURI).isEqualTo("interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80")
            assertThat(it.jobURI).isNotEmpty()
        }
    }

    @Test
    fun archiveTest() {
        val profile = "BlackPearl"
        val interplayURI =
                "interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80"

        val observable = avidPamWsClient.archivePamAsset(profile, interplayURI).toObservable()
        val testObserver = TestObserver<PamJob>()

        observable.subscribe(testObserver)

        testObserver.awaitTerminalEvent()
        testObserver
                .assertNoErrors()
                .assertComplete()
                .assertValueCount(1)
                .values().forEach {
            assertThat(it).isNotNull()
            assertThat(it.interplayURI).isEqualTo("interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80")
            assertThat(it.jobURI).isNotEmpty()
        }
    }

    @Test
    fun jobStatusTest() {
        val profile = "BlackPearl"
        val interplayURI =
                "interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80"

        val observable = avidPamWsClient.archivePamAsset(profile, interplayURI).toObservable()
        val testObserver = TestObserver<PamJob>()

        observable.subscribe(testObserver)

        testObserver.awaitTerminalEvent()
        testObserver
                .assertNoErrors()
                .assertComplete()
                .assertValueCount(1)
                .values().forEach { pamJob ->
            assertThat(pamJob).isNotNull()
            assertThat(pamJob.interplayURI).isEqualTo("interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80")
            assertThat(pamJob.jobURI).isNotEmpty()

            val jobURI = pamJob.jobURI

            do {
                TimeUnit.SECONDS.sleep(5)
                val pamJobStatus = avidPamWsClient.getPamJobStatus(jobURI)
                        .doOnSuccess { it ->
                            if (it.jobStatus == "Error") fail("job ${it.jobURI} failed")
                        }
                        .blockingGet()
            } while (pamJobStatus.jobStatus != "Completed")
        }
    }

    @Test
    fun getFileLocationsTest() {
        val interplayURL = "interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80"

        val fileLocationObservable = avidPamWsClient.getFileLocations(interplayURL)
        val testObserver = TestObserver<FileLocation>()

        fileLocationObservable.subscribe(testObserver)

        val expected = setOf(
                FileLocation("\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-38.1\\wg2_ams3_dd01.59de859de815c.mxf", "interplay://AvidWorkgroup?filemobid=060a2b340101010101010f0013-000000-59de815c2634026a-060e2b347f7f-2a80", 965729, "Online", "Data", "060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80"),
                FileLocation("\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-38.1\\wg2_ams3_da01.59de859de815c.mxf", "interplay://AvidWorkgroup?filemobid=060a2b340101010101010f0013-000000-59de815c2632026a-060e2b347f7f-2a80", 83886689, "Online", "PCM", "060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80"),
                FileLocation("\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-38.1\\wg2_ams3_dv01.59de859de815c.mxf", "interplay://AvidWorkgroup?filemobid=060a2b340101010101010f0013-000000-59de815c2624026a-060e2b347f7f-2a80", 9858712161, "Online", "DNxHD 1080 115-120-145", "060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80"),
                FileLocation("\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-38.1\\wg2_ams3_da02.59de859de815c.mxf", "interplay://AvidWorkgroup?filemobid=060a2b340101010101010f0013-000000-59de815c2633026a-060e2b347f7f-2a80", 83886689, "Online", "PCM", "060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80")
        )

        testObserver.awaitTerminalEvent()
        testObserver
                .assertNoErrors()
                .assertComplete()
                .assertValueCount(4)
                .assertValueSet(expected)
    }

    @Test
    fun archiveMasterClipToBlackPearlTest() {
        val bucket = "escape_pod"

        try {
            val interplayURL = "interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80"

            val observable = avidPamWsClient.archivePamAssetToBlackPearl(bucket, interplayURL)
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
                    assertThat(md.get(key)[0]).isEqualTo(expected[obj.key].orEmpty()[key])
                }
            }
        } finally {
            HELPERS.deleteBucket(bucket)
        }
    }

    @Test
    fun getSequenceRelativesTest() {
        val interplayURL = "interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59d6baef37175864-060e2b347f7f-2a80"

        val sequenceRelativesObservable = avidPamWsClient.getSequenceRelatives(interplayURL)
        val testObserver = TestObserver<SequenceRelative>()

        sequenceRelativesObservable.subscribe(testObserver)

        val expected = setOf(
                SequenceRelative("interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80"),
                SequenceRelative("interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59dbb5ab20636bd7-060e2b347f7f-2a80"),
                SequenceRelative("interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59dbb5af30986bd7-060e2b347f7f-2a80")

        )

        testObserver.awaitTerminalEvent()
        testObserver
                .assertNoErrors()
                .assertComplete()
                .assertValueCount(3)
                .assertValueSet(expected)
    }

    @Test
    fun archiveSequenceToBlackPearlTest() {
        val bucket = "escape_pod"
        try {
            val interplayURL = "interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59d6baef37175864-060e2b347f7f-2a80"

            val observable = avidPamWsClient.archivePamSequenceToBlackPearl(bucket, interplayURL).toObservable<Unit>()
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
                    assertThat(md.get(key)[0]).isEqualTo(expected[obj.key].orEmpty()[key])
                }
            }
        } finally {
            HELPERS.deleteBucket(bucket)
        }
    }

    @Test
    fun sharon() {
        val bucket = "avid-bucket"
        val helpers = Ds3ClientHelpers.wrap(bpClientFactory.createBpClient(BP_ENDPOINT).blockingGet())

        helpers.listObjects(bucket).forEach { obj ->
            val md = bpClientFactory.createBpClient(BP_ENDPOINT).blockingGet().headObject(HeadObjectRequest(bucket, obj.key)).metadata
            println(obj.key)
            md.keys().forEach { key -> md.get(key).forEach { value -> println("$key , $value") } }
        }
    }
}
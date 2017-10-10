package com.spectralogic.escapepod.avidpamwsclient

import com.spectralogic.ds3client.Ds3ClientBuilder
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

        @BeforeClass
        @JvmStatic
        fun beforeClass() {
            val ds3Client = Ds3ClientBuilder.create(BP_ENDPOINT, Credentials(ACCESS_ID, SECRET_KEY))
                    .withHttps(false)
                    .build()

            val bpClientFactory = mock(BpClientFactory::class.java)
            Mockito.`when`(bpClientFactory.createBpClient("sm25-2"))
                    .thenReturn(Single.just(ds3Client))

            avidPamWsClient = AvidPamWsClient(USERNAME, PASSWORD, ENDPOINT, bpClientFactory, "sm25-2", Executors.newSingleThreadExecutor())
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
        val interplayURL = "interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80"

        val fileLocationObservable = avidPamWsClient.getFileLocations(interplayURL)
        val testObserver = TestObserver<FileLocation>()

        fileLocationObservable.subscribe(testObserver)

        val expected = setOf(
                FileLocation("\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-35.1\\wg2_ams3_dd01.59cea59cead49.mxf", "interplay://AvidWorkgroup?filemobid=060a2b340101010101010f0013-000000-59cead496d6238ef-060e2b347f7f-2a80", 965729, "Online", "Data"),
                FileLocation("\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-35.1\\wg2_ams3_da01.59cea59cead49.mxf", "interplay://AvidWorkgroup?filemobid=060a2b340101010101010f0013-000000-59cead496d6038ef-060e2b347f7f-2a80", 83886689, "Online", "PCM"),
                FileLocation("\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-35.1\\wg2_ams3_dv01.59cea59cead49.mxf", "interplay://AvidWorkgroup?filemobid=060a2b340101010101010f0013-000000-59cead496d5f38ef-060e2b347f7f-2a80", 9858712161, "Online", "DNxHD 1080 115-120-145"),
                FileLocation("\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-35.1\\wg2_ams3_da02.59cea59cead49.mxf", "interplay://AvidWorkgroup?filemobid=060a2b340101010101010f0013-000000-59cead496d6138ef-060e2b347f7f-2a80", 83886689, "Online", "PCM")
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
        val interplayURL = "interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80"

        val observable = avidPamWsClient.archivePamAssetToBlackPearl(bucket, interplayURL)
                .toObservable<Unit>()
        val testObserver = TestObserver<Unit>()

        observable.subscribe(testObserver)

        testObserver.awaitTerminalEvent()
        testObserver
                .assertNoErrors()
                .assertComplete()
    }

    @Test
    fun getSequenceRelativesTest() {
        val interplayURL = "interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59d6baef37175864-060e2b347f7f-2a80"

        val sequenceRelativesObservable = avidPamWsClient.getSequenceRelatives(interplayURL)
        val testObserver = TestObserver<SequenceRelative>()

        sequenceRelativesObservable.subscribe(testObserver)

        val expected = setOf(
                SequenceRelative("interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80"),
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
        val interplayURL = "interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80"

        avidPamWsClient.archivePamAssetToBlackPearl(bucket, interplayURL)
                .blockingGet()
    }
}
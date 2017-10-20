package com.spectralogic.escapepod.avidpamwsclient

import com.spectralogic.escapepod.api.*
import io.reactivex.observers.TestObserver
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.fail
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import java.util.concurrent.TimeUnit

internal class AvidPamWsClientImplTest {

    private companion object {

        //Avid WS info
        private val NAME = "test"
        private val USERNAME = "spectra"
        private val PASSWORD = ""
        private val ENDPOINT = "10.1.2.164:80"
        private val WORKGROUP = "AvidWorkgroup"

        private lateinit var avidPamWsClientImpl: AvidPamWsClient

        @BeforeClass
        @JvmStatic
        fun beforeClass() {
            avidPamWsClientImpl = AvidPamWsClientImpl(NAME, USERNAME, PASSWORD, ENDPOINT, WORKGROUP)
        }

        @AfterClass
        @JvmStatic
        fun afterClass() {

        }
    }

    @Test
    fun getChildrenTest() {
        val folder = "Incoming Media/SpectraLogic1/escape_pod_test"

        val observable = avidPamWsClientImpl.getPamAssets(folder)
        val testObserver = TestObserver<PamAsset>()

        observable.subscribe(testObserver)

        val expected = setOf(
                PamAsset("interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59d6baef37175864-060e2b347f7f-2a80", "060a2b340101010101010f0013-000000-59d6baef37175864-060e2b347f7f-2a80", "/Incoming Media/SpectraLogic1/escape_pod_test/060a2b340101010101010f0013-000000-59d6baef37175864-060e2b347f7f-2a80", "escape_pod_sequence", "N/A", "online", "sequence"),
                PamAsset("interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59dbb5af30986bd7-060e2b347f7f-2a80", "060a2b340101010101010f0013-000000-59dbb5af30986bd7-060e2b347f7f-2a80", "/Incoming Media/SpectraLogic1/escape_pod_test/060a2b340101010101010f0013-000000-59dbb5af30986bd7-060e2b347f7f-2a80", "WG2_AMS3_DNx145_Vadym.15.new.02", "10740803", "online", "masterclip"),
                PamAsset("interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59dbb5ab20636bd7-060e2b347f7f-2a80", "060a2b340101010101010f0013-000000-59dbb5ab20636bd7-060e2b347f7f-2a80", "/Incoming Media/SpectraLogic1/escape_pod_test/060a2b340101010101010f0013-000000-59dbb5ab20636bd7-060e2b347f7f-2a80", "WG2_AMS3_DNx145_Vadym.14.new.02", "90112", "online", "masterclip"),
                PamAsset("interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80", "060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80", "/Incoming Media/SpectraLogic1/escape_pod_test/060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80", "WG2_AMS3_DNx145_Vadym.16.new.03", "9792432", "online", "masterclip")
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
        val observable = avidPamWsClientImpl.getPamProfiles()
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
        val mobid = "060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80"

        val observable = avidPamWsClientImpl.restorePamAsset(profile, mobid).toObservable()
        val testObserver = TestObserver<PamJob>()

        observable.subscribe(testObserver)

        val expected = "interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80"

        testObserver.awaitTerminalEvent()
        testObserver
                .assertNoErrors()
                .assertComplete()
                .assertValueCount(1)
                .values().forEach {
            assertThat(it).isNotNull()
            assertThat(it.interplayURI).isEqualTo(expected)
            assertThat(it.jobURI).isNotEmpty()
        }
    }

    @Test
    fun archiveTest() {
        val profile = "BlackPearl"
        val mobid = "060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80"

        val observable = avidPamWsClientImpl.archivePamAsset(profile, mobid).toObservable()
        val testObserver = TestObserver<PamJob>()

        observable.subscribe(testObserver)

        val expected =
                "interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80"

        testObserver.awaitTerminalEvent()
        testObserver
                .assertNoErrors()
                .assertComplete()
                .assertValueCount(1)
                .values().forEach {
            assertThat(it).isNotNull()
            assertThat(it.interplayURI).isEqualTo(expected)
            assertThat(it.jobURI).isNotEmpty()
        }
    }

    @Test
    fun jobStatusTest() {
        val profile = "BlackPearl"
        val mobid = "060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80"

        val observable = avidPamWsClientImpl.archivePamAsset(profile, mobid).toObservable()
        val testObserver = TestObserver<PamJob>()

        observable.subscribe(testObserver)

        val expected =
                "interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80"

        testObserver.awaitTerminalEvent()
        testObserver
                .assertNoErrors()
                .assertComplete()
                .assertValueCount(1)
                .values().forEach { pamJob ->
            assertThat(pamJob).isNotNull()
            assertThat(pamJob.interplayURI).isEqualTo(expected)
            assertThat(pamJob.jobURI).isNotEmpty()

            val jobURI = pamJob.jobURI

            do {
                TimeUnit.SECONDS.sleep(5)
                val pamJobStatus = avidPamWsClientImpl.getPamJobStatus(jobURI)
                        .doOnSuccess { it ->
                            if (it.jobStatus == "Error") fail("job ${it.jobURI} failed")
                        }
                        .blockingGet()
            } while (pamJobStatus.jobStatus != "Completed")
        }
    }

    @Test
    fun getFileLocationsTest() {
        val mobid = "060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80"

        val fileLocationObservable = avidPamWsClientImpl.getFileLocations(mobid)
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
    fun getSequenceRelativesTest() {
        val mobid = "060a2b340101010101010f0013-000000-59d6baef37175864-060e2b347f7f-2a80"

        val sequenceRelativesObservable = avidPamWsClientImpl.getSequenceRelatives(mobid)
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
    fun getMasterClipTypeTest() {
        val mobid = "060a2b340101010101010f0013-000000-59de815c2623026a-060e2b347f7f-2a80"

        val observable = avidPamWsClientImpl.getAssetType(mobid)
                .toObservable()
        val testObserver = TestObserver<AssetType>()

        observable.subscribe(testObserver)

        val expected = setOf(AssetType.MASTERCLIP)

        testObserver.awaitTerminalEvent()
        testObserver
                .assertNoErrors()
                .assertComplete()
                .assertValueCount(1)
                .assertValueSet(expected)
    }

    @Test
    fun getSequenceTypeTest() {
        val mobid = "060a2b340101010101010f0013-000000-59d6baef37175864-060e2b347f7f-2a80"

        val observable = avidPamWsClientImpl.getAssetType(mobid)
                .toObservable()
        val testObserver = TestObserver<AssetType>()

        observable.subscribe(testObserver)

        val expected = setOf(AssetType.SEQUENCE)

        testObserver.awaitTerminalEvent()
        testObserver
                .assertNoErrors()
                .assertComplete()
                .assertValueCount(1)
                .assertValueSet(expected)
    }

    @Test
    fun getPamWorkGroupsTest() {
        val observable = avidPamWsClientImpl.getPamWorkGroups()
        val testObserver = TestObserver<PamWorkGroup>()

        observable.subscribe(testObserver)

        val expected = setOf(PamWorkGroup("AvidWorkgroup", "eng-dell-28", "eng-dell-32", "eng-dell-35"))

        testObserver.awaitTerminalEvent()
        testObserver
                .assertNoErrors()
                .assertComplete()
                .assertValueCount(1)
                .assertValueSet(expected)
    }
}
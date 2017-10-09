package com.spectralogic.escapepod.avidpamwsclient

import com.spectralogic.ds3client.Ds3ClientBuilder
import com.spectralogic.ds3client.models.common.Credentials
import com.spectralogic.escapepod.api.FileLocation
import com.spectralogic.escapepod.api.PamProfile
import io.reactivex.observers.TestObserver
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.fail
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
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
            avidPamWsClient = AvidPamWsClient(USERNAME, PASSWORD, ENDPOINT, ds3Client)
        }

        @AfterClass
        @JvmStatic
        fun afterClass() {

        }
    }

    //TODO update test with new test file in the bin

    @Test
    fun getChildrenTest() {
        val interplayURI = "interplay://AvidWorkgroup/Incoming Media/SpectraLogic1/escape_pod_test"

        val observable =
                avidPamWsClient.getPamAssets(interplayURI)
                        .doOnNext { it ->
                            assertThat(it.interplayURI).isEqualTo("interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80")
                            assertThat(it.displayName).isEqualTo("WG2_AMS3_DNx145_Vadym.16.new.02")
                            assertThat(it.mobid).isEqualTo("060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80")
                            assertThat(it.path).isEqualTo("/Incoming Media/SpectraLogic1/escape_pod_test/060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80")
                            assertThat(it.mediaSize).isEqualTo("9787321")
                            assertThat(it.mediaStatus).isEqualTo("online")
                            assertThat(it.type).isEqualTo("masterclip")
                        }

        assertThat(observable.count().blockingGet()).isEqualTo(1)
    }

    @Test
    fun getProfilesTest() {
        val workgroupURI = "interplay://AvidWorkgroup"
        val services = arrayOf("com.avid.dms.restore", "com.avid.dms.archive")
        val showParameters = true

        avidPamWsClient.getPamProfiles(workgroupURI, services, showParameters)
                .doOnSuccess { (results) ->
                    assertThat(results.size).isGreaterThan(2)
                    assertThat(results).contains(PamProfile("BlackPearl", "com.avid.dms.restore"))
                    assertThat(results).contains(PamProfile("BlackPearl", "com.avid.dms.archive"))
                }
                .blockingGet()
    }

    @Test
    fun restoreTest() {
        val profile = "BlackPearl"
        val interplayURI =
                "interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80"

        avidPamWsClient.restorePamAsset(profile, interplayURI)
                .doOnSuccess { res ->
                    assertThat(res).isNotNull()
                    assertThat(res.interplayURI).isEqualTo("interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80")
                    assertThat(res.jobURI).isNotEmpty()
                }
                .blockingGet()
    }

    @Test
    fun archiveTest() {
        val profile = "BlackPearl"
        val interplayURI =
                "interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80"

        avidPamWsClient.archivePamAsset(profile, interplayURI)
                .doOnSuccess { res ->
                    assertThat(res).isNotNull()
                    assertThat(res.interplayURI).isEqualTo("interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80")
                    assertThat(res.jobURI).isNotEmpty()
                }
                .blockingGet()
    }

    @Test
    fun jobStatusTest() {
        val profile = "BlackPearl"
        val interplayURI =
                "interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80"

        val pamJob = avidPamWsClient.archivePamAsset(profile, interplayURI)
                .doOnSuccess { res ->
                    assertThat(res).isNotNull()
                    assertThat(res.interplayURI).isEqualTo("interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80")
                    assertThat(res.jobURI).isNotEmpty()
                }
                .blockingGet()

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

    @Test
    fun getFileLocationsTest() {
        val interplayURL = "interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80"

        val fileLocationObservable = avidPamWsClient.getFileLocations(interplayURL)
        val testObserver = TestObserver<FileLocation>()

        fileLocationObservable.subscribe(testObserver)
        testObserver.assertNoErrors()
        testObserver.assertComplete()
        testObserver.assertValueCount(4)

        val expected = setOf(
                FileLocation("\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-35.1\\wg2_ams3_dd01.59cea59cead49.mxf", "interplay://AvidWorkgroup?filemobid=060a2b340101010101010f0013-000000-59cead496d6238ef-060e2b347f7f-2a80", 965729, "Online", "Data"),
                FileLocation("\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-35.1\\wg2_ams3_da01.59cea59cead49.mxf", "interplay://AvidWorkgroup?filemobid=060a2b340101010101010f0013-000000-59cead496d6038ef-060e2b347f7f-2a80", 83886689, "Online", "PCM"),
                FileLocation("\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-35.1\\wg2_ams3_dv01.59cea59cead49.mxf", "interplay://AvidWorkgroup?filemobid=060a2b340101010101010f0013-000000-59cead496d5f38ef-060e2b347f7f-2a80", 9858712161, "Online", "DNxHD 1080 115-120-145"),
                FileLocation("\\\\sl-isis-55\\media\\avid mediafiles\\mxf\\eng-dell-35.1\\wg2_ams3_da02.59cea59cead49.mxf", "interplay://AvidWorkgroup?filemobid=060a2b340101010101010f0013-000000-59cead496d6138ef-060e2b347f7f-2a80", 83886689, "Online", "PCM")
                )
        testObserver.assertValueSet(expected)
    }

    @Test
    fun archiveMasterClipToBlackPearlTest() {
        val bucket = "escape_pod"
        val interplayURL = "interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59cead496d5e38ef-060e2b347f7f-2a80"

        avidPamWsClient.archivePamAssetToBlackPearl(bucket, interplayURL)
                .blockingGet()
    }

    @Test
    fun archiveSequenceToBlackPearlTest() {
        val bucket = "escape_pod"
        val interplayURL = "interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59d6baef37175864-060e2b347f7f-2a80"

        avidPamWsClient.getSequenceRelatives(interplayURL).blockingSubscribe()
    }
}
package com.spectralogic.escapepod.avidpamwsclient

import com.spectralogic.escapepod.api.PamProfile
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.fail
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import java.util.concurrent.TimeUnit

internal class AvidPamWsClientTest {

    companion object {

        private val USERNAME = "spectra"
        private val PASSWORD = ""
        private val ENDPOINT = "10.1.2.164:80"

        private lateinit var avidPamWsClient: AvidPamWsClient

        @BeforeClass
        @JvmStatic
        fun beforeClass() {
            avidPamWsClient = AvidPamWsClient(USERNAME, PASSWORD, ENDPOINT)
        }

        @AfterClass
        @JvmStatic
        fun afterClass() {

        }
    }

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
}
package com.spectralogic.escapepod.avidpamwsclient

import com.spectralogic.escapepod.util.ifNotNull
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test

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
        val interplayURI = "interplay://AvidWorkgroup/Incoming Media/SpectraLogic1/sharon"
        val res = avidPamWsClient.getChildren(interplayURI).blockingGet()

        if (res.errors.any()) {
            for ((interplayUri, message, details) in res.errors) {
                println("$interplayUri, $message, $details")
            }
        }

        if (res.results.any()) {
            for (r in res.results) {
                println("interplayURI = $r.interplayURI")
                for ((key, value) in r.attributes) {
                    println("Attribute = ($key, $value)")
                }
                println("")
            }
        }

        /**
         * Output:
        interplayURI = interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59a49a01f9915f86-060e2b347f7f-2a80
        Attribute = (MOB ID, 060a2b340101010101010f0013-000000-59a49a01f9915f86-060e2b347f7f-2a80)
        Attribute = (Moniker, 1|2EC83CF0-41D5-409D-BF60-B6FB997FA8AF|*|15317|*)
        Attribute = (_WG_TRANSFER_TYPE, 0)
        Attribute = (CFPS, 29.97)
        Attribute = (Created By, spectra)
        Attribute = (Creation Date, 2017-08-28T16:32:33.000-0600)
        Attribute = (Display Name, WG2_AMS3_DNx145_Vadym.06.new.02)
        Attribute = (Duration, 00;10;00;00)
        Attribute = (End, 13;01;21;00)
        Attribute = (Media File Format, MXF)
        Attribute = (Media Size, 10827150)
        Attribute = (Media Status, online)
        Attribute = (Modified By, spectra)
        Attribute = (Modified Date, 2017-08-28T16:35:51.000-0600)
        Attribute = (NxNServer_WG_AMAStatus, 0)
        Attribute = (Path, /Incoming Media/SpectraLogic1/sharon/060a2b340101010101010f0013-000000-59a49a01f9915f86-060e2b347f7f-2a80)
        Attribute = (Source ID, 060a2b340101010101010f0013-000000-001d3110a29ae469-060e2b347f7f-2a80)
        Attribute = (Start, 12;51;21;00)
        Attribute = (Tape, WG2_AMS3_DNx145_Vadym.06)
        Attribute = (Tape, WG2_AMS3_DNx145_Vadym.06)
        Attribute = (Tracks, V1 A1-2 D1)
        Attribute = (Type, masterclip)
        Attribute = (Video ID, 0_237)

        interplayURI = interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59a49873e5275f80-060e2b347f7f-2a80
        Attribute = (MOB ID, 060a2b340101010101010f0013-000000-59a49873e5275f80-060e2b347f7f-2a80)
        Attribute = (Moniker, 1|2EC83CF0-41D5-409D-BF60-B6FB997FA8AF|*|15318|*)
        Attribute = (_WG_TRANSFER_TYPE, 0)
        Attribute = (CFPS, 29.97)
        Attribute = (Created By, spectra)
        Attribute = (Creation Date, 2017-08-28T16:25:55.000-0600)
        Attribute = (Display Name, WG2_AMS3_DNx145_Vadym.04.new.02)
        Attribute = (Duration, 00;10;00;00)
        Attribute = (End, 12;40;21;00)
        Attribute = (Media File Format, MXF)
        Attribute = (Media Size, 10827150)
        Attribute = (Media Status, online)
        Attribute = (Modified By, spectra)
        Attribute = (Modified Date, 2017-08-28T16:29:11.000-0600)
        Attribute = (NxNServer_WG_AMAStatus, 0)
        Attribute = (Path, /Incoming Media/SpectraLogic1/sharon/060a2b340101010101010f0013-000000-59a49873e5275f80-060e2b347f7f-2a80)
        Attribute = (Source ID, 060a2b340101010101010f0013-000000-001d1c10a296e469-060e2b347f7f-2a80)
        Attribute = (Start, 12;30;21;00)
        Attribute = (Tape, WG2_AMS3_DNx145_Vadym.04)
        Attribute = (Tape, WG2_AMS3_DNx145_Vadym.04)
        Attribute = (Tracks, V1 A1-2 D1)
        Attribute = (Type, masterclip)
        Attribute = (Video ID, 0_235)

        interplayURI = interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59a49938e8335f83-060e2b347f7f-2a80
        Attribute = (MOB ID, 060a2b340101010101010f0013-000000-59a49938e8335f83-060e2b347f7f-2a80)
        Attribute = (Moniker, 1|2EC83CF0-41D5-409D-BF60-B6FB997FA8AF|*|15319|*)
        Attribute = (_WG_TRANSFER_TYPE, 0)
        Attribute = (CFPS, 29.97)
        Attribute = (Created By, spectra)
        Attribute = (Creation Date, 2017-08-28T16:29:12.000-0600)
        Attribute = (Display Name, WG2_AMS3_DNx145_Vadym.05.new.02)
        Attribute = (Duration, 00;10;00;00)
        Attribute = (End, 12;50;51;00)
        Attribute = (Media File Format, MXF)
        Attribute = (Media Size, 10827150)
        Attribute = (Media Status, online)
        Attribute = (Modified By, spectra)
        Attribute = (Modified Date, 2017-08-28T16:32:33.000-0600)
        Attribute = (NxNServer_WG_AMAStatus, 0)
        Attribute = (Path, /Incoming Media/SpectraLogic1/sharon/060a2b340101010101010f0013-000000-59a49938e8335f83-060e2b347f7f-2a80)
        Attribute = (Source ID, 060a2b340101010101010f0013-000000-003b2610a298e469-060e2b347f7f-2a80)
        Attribute = (Start, 12;40;51;00)
        Attribute = (Tape, WG2_AMS3_DNx145_Vadym.05)
        Attribute = (Tape, WG2_AMS3_DNx145_Vadym.05)
        Attribute = (Tracks, V1 A1-2 D1)
        Attribute = (Type, masterclip)
        Attribute = (Video ID, 0_236)

        interplayURI = interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59a49ac802575f8a-060e2b347f7f-2a80
        Attribute = (MOB ID, 060a2b340101010101010f0013-000000-59a49ac802575f8a-060e2b347f7f-2a80)
        Attribute = (Moniker, 1|2EC83CF0-41D5-409D-BF60-B6FB997FA8AF|*|15320|*)
        Attribute = (_WG_TRANSFER_TYPE, 0)
        Attribute = (CFPS, 29.97)
        Attribute = (Created By, spectra)
        Attribute = (Creation Date, 2017-08-28T16:35:52.000-0600)
        Attribute = (Display Name, WG2_AMS3_DNx145_Vadym.07.new.02)
        Attribute = (Duration, 00;10;00;00)
        Attribute = (End, 13;11;51;00)
        Attribute = (Media File Format, MXF)
        Attribute = (Media Size, 10827150)
        Attribute = (Media Status, online)
        Attribute = (Modified By, spectra)
        Attribute = (Modified Date, 2017-08-28T16:39:14.000-0600)
        Attribute = (NxNServer_WG_AMAStatus, 0)
        Attribute = (Path, /Incoming Media/SpectraLogic1/sharon/060a2b340101010101010f0013-000000-59a49ac802575f8a-060e2b347f7f-2a80)
        Attribute = (Source ID, 060a2b340101010101010f0013-000000-003b3b10a29ce469-060e2b347f7f-2a80)
        Attribute = (Start, 13;01;51;00)
        Attribute = (Tape, WG2_AMS3_DNx145_Vadym.07)
        Attribute = (Tape, WG2_AMS3_DNx145_Vadym.07)
        Attribute = (Tracks, V1 A1-2 D1)
        Attribute = (Type, masterclip)
        Attribute = (Video ID, 0_238)
         */
    }

    @Test
    fun getProfilesTest() {
        val workgroupURI = "interplay://AvidWorkgroup"
        val services = arrayOf("com.avid.dms.restore", "com.avid.dms.archive")
        val showParameters = true

        val res = avidPamWsClient.getProfiles(workgroupURI, services, showParameters).blockingGet()

        if (res.errors.any()) {
            for ((interplayURI, message, details) in res.errors) {
                println("$interplayURI, $message, $details")
            }
        }

        if (res.results.any()) {
            for ((name, service, parameters) in res.results) {
                println("Name = $name ; Service = $service")
                parameters.ifNotNull {
                    for ((key, value) in it) {
                        println("Param = ($key, $value)")
                    }
                }
                println("")
            }
        }

        /**
         * Output:

        Name = BlackPearl ; Service = com.avid.dms.restore
        Param = (Destination_Server, eng-dell-28)
        Param = (Partial, )
        Param = (TargetVideoQuality, All)
        Param = (Destination_Workspace, \\SL-ISIS-55\media)
        Param = (Destination_Path, AvidWG/Projects/Spectra/BlackPearl_Restore)
        Param = (Requested Provider, eng-dell-35_Restore_3337)
        Param = (Archive Engine-Tertiary, )
        Param = (Archive Engine-Primary, eng-dell-32)
        Param = (Priority, 50)
        Param = (Archive Engine-Secondary, )

        Name = BlackPearl Partial ; Service = com.avid.dms.restore
        Param = (Destination_Server, eng-dell-28)
        Param = (Partial, true)
        Param = (TargetVideoQuality, All)
        Param = (Destination_Workspace, \\SL-ISIS-55\media)
        Param = (Destination_Path, AvidWG/Projects/Spectra/BlackPearl_Restore_Partial)
        Param = (Requested Provider, eng-dell-35_Restore_3337)
        Param = (Archive Engine-Tertiary, )
        Param = (Archive Engine-Primary, eng-dell-32)
        Param = (Priority, 50)
        Param = (Archive Engine-Secondary, )

        Name = BlackPearl ; Service = com.avid.dms.archive
        Param = (Partition, )
        Param = (TargetVideoQuality, All)
        Param = (Destination_Path, AvidAM/Projects/Spectra/BlackPearl_Archive)
        Param = (Requested Provider, eng-dell-35_Archive_3415)
        Param = (Skip Motion Effect, )
        Param = (Archive Engine Name, eng-dell-32.eng.sldomain.com)
        Param = (Priority, 50)

        Name = BlackPearl_with_partition ; Service = com.avid.dms.archive
        Param = (Partition, avid-partition-bucket)
        Param = (TargetVideoQuality, All)
        Param = (Destination_Path, AvidAM/Projects/Spectra/BlackPearl_Archive/avid-partition-bucket)
        Param = (Requested Provider, eng-dell-35_Archive_3415)
        Param = (Skip Motion Effect, )
        Param = (Archive Engine Name, eng-dell-32)
        Param = (Priority, 50)

        Name = BlackPearl_wrong_partition ; Service = com.avid.dms.archive
        Param = (Partition, avid-wrong-bucket-@)
        Param = (TargetVideoQuality, All)
        Param = (Destination_Path, AvidAM/Projects/Spectra/BlackPearl_Archive)
        Param = (Requested Provider, eng-dell-35_Archive_3415)
        Param = (Skip Motion Effect, )
        Param = (Archive Engine Name, eng-dell-32)
        Param = (Priority, 50)

        Name = BlackPearl-Cliff ; Service = com.avid.dms.archive
        Param = (Partition, )
        Param = (TargetVideoQuality, All)
        Param = (Destination_Path, AvidAM/Projects/Spectra/BlackPearl_Archive)
        Param = (Requested Provider, eng-dell-35_Archive_3415)
        Param = (Skip Motion Effect, )
        Param = (Archive Engine Name, eng-dell-32)
        Param = (Priority, 50)

         */
    }

    @Test
    fun restoreTest() {
        val profile = "BlackPearl"
        val interplayURI =
                "interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59a49938e8335f83-060e2b347f7f-2a80"

        val res = avidPamWsClient.restore(profile, interplayURI).blockingGet()

        if (res.errors.any()) {
            for ((interplayUri, message, details) in res.errors) {
                println("$interplayUri, $message, $details")
            }
        }

        res.jobURI.ifNotNull {
            println("jobURI = $it")
        }

        /**
         * Output example:
         * jobURI = interplay://AvidWorkgroup/DMS?jobid=1504207567867.1
         */
    }

    @Test
    fun archiveTest() {
        val profile = "BlackPearl"
        val interplayURI =
                "interplay://AvidWorkgroup?mobid=060a2b340101010101010f0013-000000-59a49938e8335f83-060e2b347f7f-2a80"

        val res = avidPamWsClient.archive(profile, interplayURI).blockingGet()

        if (res.errors.any()) {
            for ((interplayUri, message, details) in res.errors) {
                println("$interplayUri, $message, $details")
            }
        }

        res.jobURI.ifNotNull {
            println("jobURI = $it")
        }

        /**
         * Output example:
         * jobURI = interplay://AvidWorkgroup/DMS?jobid=1504207567867.1
         */
    }

    @Test
    fun jobStatusTest() {
        val jobURIs = arrayOf(
                "interplay://AvidWorkgroup/DMS?jobid=1505159604061.1")

        val res = avidPamWsClient.getJobsStatus(jobURIs).blockingGet()


        if (res.errors.any()) {
            for ((interplayURI, message, details) in res.errors) {
                println("$interplayURI, $message, $details")
            }
        }

        if (res.results.any()) {
            for ((jobURI, jobStatus, percentComplete) in res.results) {
                println("jobURI = $jobURI ; ($jobStatus , $percentComplete%)")
            }
        }

        /**
         * Output example:
         * jobURI = interplay://AvidWorkgroup/DMS?jobid=1504207567867.1 ; (Completed , null)
         * jobURI = interplay://AvidWorkgroup/DMS?jobid=1505159604061.1 ; (Processing , 52%)
         */
    }

    @Test
    fun cancelJobsTest() {
        val jobURIs = arrayOf(
                "",
                "interplay://AvidWorkgroup/DMS?jobid=1505159604061.1",
                "interplay://AvidWorkgroup/DMS?jobid=1504207567867.1")

        val res = avidPamWsClient.cancelJobs(jobURIs).blockingGet()

        if (res.errors.any()) {
            for ((interplayURI, message, details) in res.errors) {
                println("$interplayURI, $message, $details")
            }
        } else {
            println("All jobs were canceled successfully")
        }
    }
}
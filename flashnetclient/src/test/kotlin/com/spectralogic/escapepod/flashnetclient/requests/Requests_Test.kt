/*
 * ****************************************************************************
 *    Copyright 2014-2017 Spectra Logic Corporation. All Rights Reserved.
 *    Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *    this file except in compliance with the License. A copy of the License is located at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *    or in the "license" file accompanying this file.
 *    This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *    CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *    specific language governing permissions and limitations under the License.
 *  ****************************************************************************
 */

package com.spectralogic.escapepod.flashnetclient.requests

import com.spectralogic.escapepod.flashnetclient.FlashNetConfigImpl
import org.junit.Test
import org.junit.Assert.*
import org.simpleframework.xml.core.Persister
import java.io.Writer

class Requests_Test {
    @Test
    fun testSerializingMigrationDetails() {
        val migrateDetails = Migrate(SourceVolume = "source volume", SourceArchive = 1, DestVolume = "destination volume", MoveAssets = 0)

        val serializer = Persister()
        val memoryWriter = MemoryWriter()
        serializer.write(migrateDetails, memoryWriter)
        val xmlString = memoryWriter.xmlString

        assertEquals("<Migrate SourceVolume=\"source volume\" SourceArchive.DWD=\"1\" DestVolume=\"destination volume\" MoveAssets.DWD=\"0\"/>", xmlString)
    }

    private class MemoryWriter : Writer() {
        var xmlString : String = ""

        override fun write(cbuf: CharArray?, offset: Int, length: Int) {
            xmlString = kotlin.text.String(cbuf!!, offset, length)
        }

        override fun flush() {

        }

        override fun close() {

        }
    }

    @Test
    fun testSerializingBaseRequest() {
        val requestEnvelope = Request(APIVersion = "1.0", SourceServer = "source server", UserName = "Gracie", CallingApplication = "escape pod", Operation = "MigrateAssets", requestSpecificElement = null)

        val serializer = Persister()
        val memoryWriter = MemoryWriter()
        serializer.write(requestEnvelope, memoryWriter)
        val xmlString = memoryWriter.xmlString

        assertEquals("<FlashNetXML APIVersion=\"1.0\" SourceServer=\"source server\" UserName=\"Gracie\" CallingApplication=\"escape pod\" Operation=\"MigrateAssets\"/>", xmlString)
    }

    @Test
    fun testSerializingMigrateRequest() {
        val migrateRequest = Migrate(SourceVolume = "source volume", SourceArchive = 1, DestVolume = "destination volume", MoveAssets = 0)
        val flashNetRequest = FlashNetRequestImpl(FlashNetConfigImpl())
        val migrationRequest = flashNetRequest.toMigrateAssetsRequest(migrateRequest)

        assertEquals("FlashNet XML 343 <?xml version=\"1.0\" encoding=\"UTF-8\"?><FlashNetXML APIVersion=\"1.0\" SourceServer=\"FlashNet-source-server\" UserName=\"FlashNet-user-name\" CallingApplication=\"FlashNet-calling-application\" Operation=\"MigrateAssets\">\n" +
                "   <Migrate SourceVolume=\"source volume\" SourceArchive.DWD=\"1\" DestVolume=\"destination volume\" MoveAssets.DWD=\"0\"/>\n" +
                "</FlashNetXML>", migrationRequest)
    }

    @Test
    fun testSerializingStatusRequest() {
        val statusRequest = Status(RequestId = 85, Guid = "A guid")
        val flashNetRequest = FlashNetRequestImpl(FlashNetConfigImpl())
        val statusRequestPayload = flashNetRequest.toStatusRequest(statusRequest)

        assertEquals("FlashNet XML 266 <?xml version=\"1.0\" encoding=\"UTF-8\"?><FlashNetXML APIVersion=\"1.0\" SourceServer=\"FlashNet-source-server\" UserName=\"FlashNet-user-name\" CallingApplication=\"FlashNet-calling-application\" Operation=\"Status\">\n" +
                "   <Status RequestId.DWD=\"85\" Guid=\"A guid\"/>\n" +
                "</FlashNetXML>", statusRequestPayload)
    }
}
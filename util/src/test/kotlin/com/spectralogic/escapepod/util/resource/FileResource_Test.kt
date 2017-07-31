/*
 * *****************************************************************************
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

package com.spectralogic.escapepod.util.resource

import com.spectralogic.escapepod.util.test.models.Messages
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.nio.file.Files

class FileResource_Test {

    @Test
    fun nullResource() {
        val testDir = Files.createTempDirectory("resourceTests-")
        val fileResource = FileResource(testDir, "test.conf", ProtoBuffMarshaller<Messages.TestMessage>(Messages.TestMessage::newBuilder))

        assertThat(fileResource.getResource()).isNull()
    }

    @Test
    fun saveResource() {
        val testDir = Files.createTempDirectory("resourceTests-")

        val fileResource = FileResource(testDir, "test.conf", ProtoBuffMarshaller<Messages.TestMessage>(Messages.TestMessage::newBuilder))
        try {
            val message = Messages.TestMessage.newBuilder().setMessage("test message").build()

            fileResource.saveResource(message)

            val retrievedMessage = fileResource.getResource()

            assertThat(retrievedMessage).isNotNull()

            if (retrievedMessage != null) {
                assertThat(retrievedMessage.message).isEqualTo("test message")
            }
        } finally {
            fileResource.deleteResource()
        }
    }

    @Test
    fun saveResourceAndReload() {
        val testDir = Files.createTempDirectory("resourceTests-")

        val fileResource = FileResource(testDir, "test.conf", ProtoBuffMarshaller<Messages.TestMessage>(Messages.TestMessage::newBuilder))
        try {
            val message = Messages.TestMessage.newBuilder().setMessage("test message").build()

            fileResource.saveResource(message)

            val fileResourceReload = FileResource(testDir, "test.conf", ProtoBuffMarshaller<Messages.TestMessage>(Messages.TestMessage::newBuilder))
            val retrievedMessage = fileResourceReload.getResource()

            assertThat(retrievedMessage).isNotNull()

            if (retrievedMessage != null) {
                assertThat(retrievedMessage.message).isEqualTo("test message")
            }
        } finally {
            fileResource.deleteResource()
        }
    }

}

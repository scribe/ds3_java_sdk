package com.spectralogic.escapepod.util.resource

import com.spectralogic.escapepod.uti.test.models.Messages
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

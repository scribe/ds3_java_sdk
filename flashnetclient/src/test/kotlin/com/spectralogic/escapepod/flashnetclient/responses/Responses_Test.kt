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

package com.spectralogic.escapepod.flashnetclient.responses

import com.spectralogic.escapepod.flashnetclient.bindToUnusedPort
import com.spectralogic.escapepod.flashnetclient.transport.SocketTransportImpl
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.concurrent.CountDownLatch

class Responses_Test {
    @Test
    fun testRehydratingResponse() {
        val socketPortTuple = bindToUnusedPort()

        if (socketPortTuple.socket == null) {
            fail("Could not bind a server socket.")
        }

        val countDownLatch = CountDownLatch(1)

        val orginalXmlResponseString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Reply Version=\"6.3.00.0\" Status=\"Passed\" Error=\"No error\" RequestId=\"1067\" />"

        val responsePayload = " FlashNet XML " + orginalXmlResponseString.length + " " + orginalXmlResponseString

        kotlin.concurrent.thread(start = true, isDaemon = false, contextClassLoader = null, name = "Server Socket", priority = -1,
                block = {
                    countDownLatch.countDown()
                    val newSocket = socketPortTuple.socket?.accept()
                    BufferedWriter(OutputStreamWriter(newSocket?.getOutputStream())).use {
                        socketWriter -> socketWriter.write(responsePayload)
                    }
                }
        )

        countDownLatch.await()

        val clientSocket = SocketTransportImpl("127.0.0.1", socketPortTuple.boundPort)
        val xmlResponseString = clientSocket.readResponse()

        val reply = FlashNetReplyImpl().fromResponsePayload(xmlResponseString)

        assertEquals(reply.Error, "No error")
        assertEquals(reply.RequestId, 1067)
        assertEquals(reply.Status, "Passed")
        assertEquals(reply.Version, "6.3.00.0")
    }

    @Test
    fun testRehydratingResponseLeavingSomestuffOut() {
        val socketPortTuple = bindToUnusedPort()

        if (socketPortTuple.socket == null) {
            fail("Could not bind a server socket.")
        }

        val countDownLatch = CountDownLatch(1)

        val orginalXmlResponseString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Reply Status=\"Passed\" Error=\"No error\" />"

        val responsePayload = " FlashNet XML " + orginalXmlResponseString.length + " " + orginalXmlResponseString

        kotlin.concurrent.thread(start = true, isDaemon = false, contextClassLoader = null, name = "Server Socket", priority = -1,
                block = {
                    countDownLatch.countDown()
                    val newSocket = socketPortTuple.socket?.accept()
                    BufferedWriter(OutputStreamWriter(newSocket?.getOutputStream())).use {
                        socketWriter -> socketWriter.write(responsePayload)
                    }
                }
        )

        countDownLatch.await()

        val clientSocket = SocketTransportImpl("127.0.0.1", socketPortTuple.boundPort)
        val xmlResponseString = clientSocket.readResponse()

        val reply = FlashNetReplyImpl().fromResponsePayload(xmlResponseString)

        assertEquals(reply.Error, "No error")
        assertEquals(reply.RequestId, null)
        assertEquals(reply.Status, "Passed")
        assertEquals(reply.Version, null)
    }

    @Test
    fun testParsingStatusResponse() {
        val statusReplyText = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <Reply Version=\"6.3.00.0\" Status=\"Passed\" >" +
                "<StatusInfo Priority.DWD=\"4\"></StatusInfo>" +
                "</Reply>"

        val statusReply = FlashNetReplyImpl()
                .fromResponsePayload(statusReplyText)
                .toStatusInfo()

        assertEquals(4, statusReply?.Priority)
    }
}

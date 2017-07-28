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

package com.spectralogic.escapepod.flashnetclient.transport

import com.spectralogic.escapepod.flashnetclient.bindToUnusedPort

import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.fail

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.concurrent.CountDownLatch

class SocketTransport_Test {
    @Test
    fun testConnectingToIPAddress() {
        val socketPortTuple = bindToUnusedPort()

        if (socketPortTuple.socket == null) {
            fail("Could not bind a server socket.")
        }

        val countDownLatch = CountDownLatch(1)

        val originalXmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<FlashNetXML APIVersion=\"1.0\" SourceServer=\"cluster-svr1\" UserName=\"Paul\" CallingApplication=\"test_xml_api\" Operation=\"Restore\">\n" +
                "<Restore Priority.DWD=\"8\">\n" +
                "<FileDetails FileCount.DWD=\"1\">\n" +
                "<File\n" +
                "EntryNumber=\"0\"\n" +
                "FullFileName=\"paul-sgl1:/c/Demo - MV - Ernie1.mxf\" Guid=\"XML-ERNIE-4\"\n" +
                "PartialStart.QWD=\"128000\" PartialEnd.QWD=\"560000\" PartialType=\"BYTE_OFFSET\"/>\n" +
                "</FileDetails> </Restore>\n" +
                "</FlashNetXML>"

        val requestPayload = " FlashNet XML " + originalXmlString.length + " " + originalXmlString

        kotlin.concurrent.thread(start = true, isDaemon = false, contextClassLoader = null, name = "Server Socket", priority = -1,
                block = {
                    countDownLatch.countDown()
                    val newSocket = socketPortTuple.socket?.accept()
                    BufferedWriter(OutputStreamWriter(newSocket?.getOutputStream())).use {
                        socketWriter -> socketWriter.write(requestPayload)
                    }
                }
        )

        countDownLatch.await()

        val clientSocket = SocketTransportImpl("127.0.0.1", socketPortTuple.boundPort)
        val xmlResponseString = clientSocket.readResponse()

        assertEquals(originalXmlString, xmlResponseString)
    }



    @Test
    fun testTransferringALongString() {
        val socketPortTuple = bindToUnusedPort()

        if (socketPortTuple.socket == null) {
            fail("Could not bind a server socket.")
        }
        val countDownLatch = CountDownLatch(1)

        val stringBuilder = StringBuilder()
        stringBuilder.append('<')

        for (i in 0..4096 * 10) {
            stringBuilder.append(i)
        }

        val originalXmlString = stringBuilder.toString()

        val originalXmlStringLength = originalXmlString.length

        val requestPayload = " FlashNet XML $originalXmlStringLength $originalXmlString "

        kotlin.concurrent.thread(start = true, isDaemon = false, contextClassLoader = null, name = "Server Socket", priority = -1,
                block = {
                    countDownLatch.countDown()
                    val newSocket = socketPortTuple.socket?.accept()
                    BufferedWriter(OutputStreamWriter(newSocket?.getOutputStream())).use {
                        socketWriter -> socketWriter.write(requestPayload)
                    }
                }
        )

        countDownLatch.await()

        val clientSocket = SocketTransportImpl("127.0.0.1", socketPortTuple.boundPort)
        val xmlResponseString = clientSocket.readResponse()

        assertEquals(originalXmlString, xmlResponseString)
    }
}
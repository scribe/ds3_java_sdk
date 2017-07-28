package com.spectralogic.escapepod.flashnetclient.transport

import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.fail

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.net.ServerSocket
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

        val responsePayload = " FlashNet XML " + originalXmlString.length + " " + originalXmlString

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

        assertEquals(originalXmlString, xmlResponseString)
    }

    private data class SocketPortTuple(val socket: ServerSocket?, val boundPort: Int)

    private fun bindToUnusedPort() : SocketPortTuple {
        val LOWEST_PORT_TO_BIND = 49152
        val HIGHEST_PORT_TO_BIND = 65535

        for (portNumber in LOWEST_PORT_TO_BIND..HIGHEST_PORT_TO_BIND) {
            try {
                val serverSocket = ServerSocket(portNumber)
                return SocketPortTuple(serverSocket, portNumber)
            } catch (throwable : Throwable) { }
        }

        return SocketPortTuple(null, 0)
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

        val responsePayload = " FlashNet XML $originalXmlStringLength $originalXmlString "

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

        assertEquals(originalXmlString, xmlResponseString)
    }
}
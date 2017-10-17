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

import org.slf4j.Logger
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Socket

import org.slf4j.LoggerFactory
import java.io.BufferedWriter
import java.io.OutputStreamWriter

class SocketTransportImpl(private val hostNameOrIpAddress : String, private val portNumber : Int) : SocketTransport
{
    private companion object {
        val LOG : Logger = LoggerFactory.getLogger(SocketTransportImpl::class.java)
        const val BEGIN_DELIMITER = '<'
    }

    override fun readResponse(): String {
        val socket : Socket?

        try {
            socket = Socket(hostNameOrIpAddress, portNumber)

            BufferedReader(InputStreamReader(socket.getInputStream())).use { bufferedReader ->
                val xmlStringSize = xmlStringSize(readToBeginDelimeter(bufferedReader))

                if (xmlStringSize > 0) {
                    return xmlBody(bufferedReader, xmlStringSize)
                }
            }
        } catch (throwable : Throwable) {
            LOG.error("Error reading response.", throwable)
        }

        return String()
    }

    private fun xmlStringSize(flashNetResponseHeader : String) : Int {
        val headerFields = flashNetResponseHeader.trim().split(" ")
        if (headerFields.count() >= 3) {
            return headerFields[2].toInt()
        }

        return 0
    }

    private fun readToBeginDelimeter(bufferedReader: BufferedReader) : String {
        var c : Char
        val buffer = StringBuilder()

        do {
            c = bufferedReader.read().toChar()
            buffer.append(c)
        } while (c != BEGIN_DELIMITER)

        return buffer.toString()
    }

    private fun xmlBody(bufferedReader: BufferedReader, xmlStringSize : Int) : String {
        val xmlString = CharArray(xmlStringSize - 1)

        read(bufferedReader, xmlString)

        return xmlString.joinToString(separator = "", prefix = BEGIN_DELIMITER.toString())
    }

    private fun read(bufferedReader: BufferedReader, buffer : CharArray) {
        var numBytesRemaining = buffer.size
        var offset = 0

        while (numBytesRemaining > 0) {
            val numBytesRead = bufferedReader.read(buffer, offset, numBytesRemaining)

            if (numBytesRead == -1) {
                break
            }

            numBytesRemaining -= numBytesRead
            offset += numBytesRead
        }
    }

    override fun writeRequest(request: String) {
        val socket : Socket?

        try {
            socket = Socket(hostNameOrIpAddress, portNumber)

            BufferedWriter(OutputStreamWriter(socket.getOutputStream())).use {
                bufferedWriter -> bufferedWriter.write(request)
            }
        } catch (throwable : Throwable) {
            LOG.error("Error writing request.", throwable)
        }
    }
}

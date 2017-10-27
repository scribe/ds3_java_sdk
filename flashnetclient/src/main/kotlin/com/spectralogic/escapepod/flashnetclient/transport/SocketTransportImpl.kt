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

import com.spectralogic.escapepod.flashnetclient.FlashnetEndpoint
import io.reactivex.Completable
import io.reactivex.Single
import org.slf4j.LoggerFactory
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Socket

import java.io.BufferedWriter
import java.io.OutputStreamWriter

class SocketTransportImpl constructor(endpoint: FlashnetEndpoint) : SocketTransport {
    private companion object {
        const val BEGIN_DELIMITER = '<'
        private val LOG = LoggerFactory.getLogger(SocketTransportImpl::class.java)
        private fun createSocket(endpoint: FlashnetEndpoint): Socket {
            try {
                LOG.info("Creating flashnet socket")
                return CloseAnnotatedSocket(endpoint.host, endpoint.port)
            } catch (t: Throwable) {
                LOG.error("Failed to create socket to flashnet node: $endpoint", t)
                throw t
            }
        }
    }

    private val socket: Socket = createSocket(endpoint)
    private val reader: BufferedReader by lazy {
        BufferedReader(InputStreamReader(socket.getInputStream()))
    }

    private val writer: BufferedWriter by lazy {
        BufferedWriter(OutputStreamWriter(socket.getOutputStream()))
    }

    override fun writeRead(request: String): Single<String> {
        return write(request).andThen(read())
    }

    override fun read(): Single<String> {
        return Single.create{ emitter ->
            try {
                val xmlStringSize = xmlStringSize(readToBeginDelimiter(reader))

                if (xmlStringSize > 0) {
                    emitter.onSuccess(xmlBody(reader, xmlStringSize))
                    return@create
                } else {
                    emitter.onError(Exception("Malformed XML Header"))
                }
            } catch (throwable : Throwable) {
                emitter.onError(throwable)
            }

        }
    }

    private fun xmlStringSize(flashNetResponseHeader : String) : Int {
        val headerFields = flashNetResponseHeader.trim().split(" ")
        if (headerFields.count() >= 3) {
            return headerFields[2].toInt()
        }

        return 0
    }

    private fun readToBeginDelimiter(bufferedReader: BufferedReader) : String {
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

    override fun write(request: String): Completable {

        return Completable.create { emitter ->
            try {
                writer.write(request)
                writer.flush()
                emitter.onComplete()
            } catch (t: Throwable) {
                emitter.onError(t)
            }
        }
    }

    override fun close() {
        LOG.info("Flashnet client socket was closed")
        try {
            writer.flush()
            reader.close()
        } finally {
            if (!socket.isClosed) {
                socket.close()
            }
        }
    }
}

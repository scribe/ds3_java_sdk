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

package com.spectralogic.escapepod.flashnetclient

import java.io.BufferedReader
import java.net.ServerSocket

data class SocketPortTuple(val socket: ServerSocket?, val boundPort: Int)

fun bindToUnusedPort() : SocketPortTuple {
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

fun read(bufferedReader: BufferedReader, buffer : CharArray) {
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

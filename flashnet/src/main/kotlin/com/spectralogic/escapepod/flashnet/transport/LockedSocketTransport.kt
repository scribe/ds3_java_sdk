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

package com.spectralogic.escapepod.flashnet.transport

import java.util.concurrent.Semaphore

/**
 * The LockedSocketTransport is used to help manage the lifecycle of the socket so that it can be reused
 * between multiple calls to the Socket Provider, but making sure that only one call for the same socket
 * can succeed at a time.  This is to help prevent conditions where multiple callers call the SocketProvider
 * and get the same socket back at the same time.
 */
class LockedSocketTransport(st: SocketTransport, private val semaphore: Semaphore): SocketTransport by st {
    override fun close() {
        semaphore.release()
    }
}

fun SocketTransport.toLockedSocketTransport(semaphore: Semaphore): SocketTransport {
    semaphore.acquire()
    return LockedSocketTransport(this, semaphore)
}
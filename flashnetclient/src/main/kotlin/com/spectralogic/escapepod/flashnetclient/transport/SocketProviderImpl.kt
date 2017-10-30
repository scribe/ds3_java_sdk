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

package com.spectralogic.escapepod.flashnetclient.transport

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import com.google.common.cache.LoadingCache
import com.spectralogic.escapepod.flashnetclient.FlashnetEndpoint
import io.reactivex.Single
import java.util.concurrent.Semaphore
import java.util.concurrent.TimeUnit

class SocketProviderImpl: SocketProvider {

    private val cache: LoadingCache<FlashnetEndpoint, Pair<SocketTransport, Semaphore>> = CacheBuilder.newBuilder()
            .expireAfterAccess(10, TimeUnit.MINUTES)
            .removalListener<FlashnetEndpoint, Pair<SocketTransport,Semaphore>> { it ->
                if (it.wasEvicted()) {
                    closeSocket(it.value)
                }
            }
            .build(CacheLoader.from ({ key ->
                Pair(createTransport(key!!), Semaphore(1))
            }))

    private fun closeSocket(socketDetails: Pair<SocketTransport, Semaphore>) {
        val (st, lock) = socketDetails
        lock.acquireUninterruptibly()
        try {
            st.close()
        } finally {
            lock.release()
        }
    }

    private fun createTransport(endpoint: FlashnetEndpoint): SocketTransport {
        return SocketTransportImpl(endpoint)
    }

    override fun socket(endpoint: FlashnetEndpoint): Single<SocketTransport> {

        return Single.create { emitter ->
            val (socketTransport, semaphore) = cache[endpoint]

            emitter.onSuccess(socketTransport.toLockedSocketTransport(semaphore))
        }
    }
}
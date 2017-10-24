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

package com.spectralogic.escapepod.bpclient

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import com.google.common.cache.LoadingCache
import com.spectralogic.ds3client.Ds3Client
import com.spectralogic.escapepod.api.BpClientFactory
import io.reactivex.Single
import java.util.concurrent.TimeUnit

internal class BpClientFactoryImpl: BpClientFactory {

    private val cache: LoadingCache<String, Ds3Client> = CacheBuilder.newBuilder()
            .expireAfterAccess(1, TimeUnit.HOURS)
            .build(CacheLoader.from( { key ->  this.cacheLoader(key!!)})) // this makes sure the key passed to cacheLoader, is not null

    override fun createBpClient(clientName: String): Single<Ds3Client> {
        return Single.just(cache[clientName])
    }

    private fun cacheLoader(key: String): Ds3Client {
        throw NotImplementedError()
    }
}

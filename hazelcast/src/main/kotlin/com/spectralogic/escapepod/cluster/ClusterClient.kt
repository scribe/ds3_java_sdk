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

package com.spectralogic.escapepod.cluster

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

interface ClusterClient {
    @GET("api/cluster")
    fun clusterName() : Single<String>
}

interface ClusterClientFactory {
    fun createClusterClient(endpoint: String) : ClusterClient
}

internal class ClusterClientFactoryImpl : ClusterClientFactory {
    override fun createClusterClient(endpoint: String): ClusterClient {
        //TODO think about adding in our common scheduler
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(formatEndpoint(endpoint))
                .build()


        return retrofit.create(ClusterClient::class.java)
    }

    private fun  formatEndpoint(endpoint: String): String {
        if (endpoint.startsWith("http")) {
            return endpoint
        } else {
            return "http://" + endpoint
        }
    }
}

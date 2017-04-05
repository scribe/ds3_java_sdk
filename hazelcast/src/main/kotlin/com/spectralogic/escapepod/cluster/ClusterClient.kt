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

class ClusterClientFactoryImpl : ClusterClientFactory {
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

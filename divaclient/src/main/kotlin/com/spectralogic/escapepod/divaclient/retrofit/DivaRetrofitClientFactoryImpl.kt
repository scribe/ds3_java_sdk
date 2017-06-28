package com.spectralogic.escapepod.divaclient.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

internal class DivaRetrofitClientFactoryImpl : DivaRetrofitClientFactory {
    override fun createDivaClient(endpoint: String): DivaRetrofitClient {

        return Retrofit.Builder()
            .baseUrl(endpoint + "/services/DIVArchiveWS_REST_2.0/")
            .client(createOkioClient())
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(DivaRetrofitClient::class.java)
    }

    private fun createOkioClient() : OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(LoggingInterceptor())

        //val httpLoggingInterceptor = HttpLoggingInterceptor()
        //httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        //builder.addInterceptor(httpLoggingInterceptor)
        builder.addInterceptor { chain ->

            val request = chain.request()
            val newRequest = request.newBuilder().addHeader("Content-Type", "application/xml")
                    .addHeader("Accepts", "application/xml")
                    .method(request.method(), request.body())
                    .build()

            chain.proceed(newRequest)
        }

        return builder.build()
    }
}

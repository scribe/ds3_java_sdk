package com.spectralogic.escapepod.divaclient

import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.POST

// Need to make sure that we use the application/xml content type and accept header

internal interface DivaRetrofitClient {

    @POST
    fun registerClient(client: RegisterClient) : Single<RegisterClientResponse>
}

private fun createOkioClient() : OkHttpClient {
    val builder = OkHttpClient.Builder()
    builder.addInterceptor(LoggingInterceptor())
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

internal fun createDivaClient(httpAddress : String) : DivaRetrofitClient {

    return Retrofit.Builder()
            .baseUrl(httpAddress)
            .client(createOkioClient())
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
            .create(DivaRetrofitClient::class.java)
}


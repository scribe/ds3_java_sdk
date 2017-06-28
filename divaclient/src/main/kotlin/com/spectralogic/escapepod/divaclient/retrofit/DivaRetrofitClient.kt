package com.spectralogic.escapepod.divaclient.retrofit

import io.reactivex.Single
import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

// Need to make sure that we use the application/xml content type and accept header

internal interface DivaRetrofitClient {

    @POST("registerClient")
    fun registerClient(@Body client: RegisterClient) : Single<RegisterClientResponse>

    @POST("getGroupsList")
    fun getTapeGroups(@Body getTapeGroup: GetGroupsList) : Single<GetGroupsListResponse>

    @POST("getSourceDestinationList")
    fun getSourceDestinationList(@Body getSourceDestinationList: GetSourceDestinationList) : Single<GetSourceDestinationListResponse>

    @POST("getObjectInfo")
    fun getObjectInfo(@Body getObjectInfo: GetObjectInfo) : Single<GetObjectInfoResponse>

    @POST("restoreObject")
    fun restoreObject(@Body restoreObject: RestoreObject) : Single<RestoreObjectResponse>
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

internal fun createDivaClient(httpAddress : String) : DivaRetrofitClient {

    return Retrofit.Builder()
            .baseUrl(httpAddress + "/services/DIVArchiveWS_REST_2.0/")
            .client(createOkioClient())
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(DivaRetrofitClient::class.java)
}


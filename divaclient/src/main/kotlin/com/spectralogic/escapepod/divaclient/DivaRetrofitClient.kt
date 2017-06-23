package com.spectralogic.escapepod.divaclient

import io.reactivex.Single
import retrofit2.http.POST

// Need to make sure that we use the application/xml content type and accept header

internal interface DivaRetrofitClient {

    @POST
    fun registerClient(request : RegisterRequest) : Single<RegisterResponse>
}


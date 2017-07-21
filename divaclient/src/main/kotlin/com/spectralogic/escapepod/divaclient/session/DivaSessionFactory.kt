package com.spectralogic.escapepod.divaclient.session

import com.spectralogic.escapepod.divaclient.retrofit.DivaRetrofitClient

internal interface DivaSessionFactory {
    fun createDivaSession(divaClient : DivaRetrofitClient) : DivaSession
}

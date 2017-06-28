package com.spectralogic.escapepod.divaclient.retrofit


internal interface DivaRetrofitClientFactory {
    fun createDivaClient(endpoint : String) : DivaRetrofitClient
}

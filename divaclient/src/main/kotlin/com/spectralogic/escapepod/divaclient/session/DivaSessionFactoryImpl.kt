package com.spectralogic.escapepod.divaclient.session

import com.spectralogic.escapepod.divaclient.retrofit.DivaRetrofitClient
import java.util.*

internal class DivaSessionFactoryImpl : DivaSessionFactory {
    override fun createDivaSession(divaClient: DivaRetrofitClient): DivaSession {
        return DivaSessionImpl(divaClient, "escapePod", "escape", UUID.randomUUID().toString())
    }
}


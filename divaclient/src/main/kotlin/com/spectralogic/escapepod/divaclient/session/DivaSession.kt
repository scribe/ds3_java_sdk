package com.spectralogic.escapepod.divaclient.session

import com.spectralogic.escapepod.divaclient.retrofit.DivaRetrofitClient
import com.spectralogic.escapepod.divaclient.retrofit.RegisterClient
import io.reactivex.Single
import java.time.LocalDateTime

internal interface DivaSession {
    fun getSession() : Single<String>
}

internal class DivaSessionImpl(private val divaClient : DivaRetrofitClient, private val appName : String, private val locName : String, val processId : String) : DivaSession {
    private var lastClientAccess : LocalDateTime? = null
    private var currentSession : String? = null

    override fun getSession(): Single<String> {
        // TODO fix to take into account the current time
        if (currentSession != null && lastClientAccess != null && lastClientAccess!!.isBefore(lastClientAccess!!.plusMinutes(30))) {
            return Single.just(currentSession!!)
        } else {
            val registerClient = RegisterClient()

            registerClient.appName = appName
            registerClient.locName = locName
            registerClient.processId = processId

            return divaClient.registerClient(registerClient).map { registerResponse -> registerResponse.sessionId }
        }
    }
}
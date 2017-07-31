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
        if (currentSession != null && lastClientAccess != null && LocalDateTime.now().isAfter(lastClientAccess!!.plusMinutes(30))) {
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
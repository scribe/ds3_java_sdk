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

package com.spectralogic.escapepod.httpservice

import ratpack.func.Action
import ratpack.handling.Chain
import ratpack.handling.Handler

/**
 * The HttpRouter is used to register RatPack handlers with the Http Module so that
 * any module in the system can expose their own Http handlers.
 */
interface HttpRouter {
    fun register(prefix: String, handler: Handler) : HttpHandlerDeregistration
    fun register(prefix: String, action: Action<Chain>) : HttpHandlerDeregistration
}

/**
 * This interface allows a consumer of the HttpRouter to remove deregister a handler
 * that has been registered with the HttpRouter
 */
interface HttpHandlerDeregistration {
    /**
     * When called, the Handler(s) associated with this Deregistration will be removed, and should no longer be served.
     * This call should be idempotent and calling deregister multiple times should succeed.
     */
    fun deregister()
}

/**
 * This is a convenience class to aggregate multiple HttpRouterRegistrations so that they are all tracked together
 * and can be de-registered together
 */
class HttpDeregistrationAggregator : HttpHandlerDeregistration {

    private val deregistrations: MutableList<HttpHandlerDeregistration> = ArrayList()

    fun addDeregistration(deregistration: HttpHandlerDeregistration) : HttpDeregistrationAggregator {
        synchronized(this) {
            deregistrations.add(deregistration)
        }
        return this
    }

    override fun deregister() {
        synchronized(this) {
            deregistrations.forEach(HttpHandlerDeregistration::deregister)
            deregistrations.clear()
        }
    }
}
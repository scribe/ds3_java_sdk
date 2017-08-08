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

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class HttpDeregister_Test {
    @Test
    fun singleRegister() {
        val deregister = HttpDeregister()
        val registration = HttpRegistrationStub()

        deregister.addRegistration(registration)

        deregister.deregister()

        assertThat(registration.registered).isFalse()
    }

    @Test
    fun multiRegister() {
        val deregister = HttpDeregister()
        val registration1 = HttpRegistrationStub()
        val registration2 = HttpRegistrationStub()

        deregister.addRegistration(registration1)
        deregister.addRegistration(registration2)

        deregister.deregister()

        assertThat(registration1.registered).isFalse()
        assertThat(registration2.registered).isFalse()
    }
}

class HttpRegistrationStub : HttpRouterRegistration {
    var registered = true
    private set

    override fun deregister() {
        registered = false
    }
}
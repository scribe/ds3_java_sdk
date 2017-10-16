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
    fun singleDeregistration() {
        val deregister = HttpDeregistrationAggregator()
        val registration = HttpDeregistrationStub()

        deregister.addDeregistration(registration)

        deregister.deregister()

        assertThat(registration.registered).isFalse()
    }

    @Test
    fun multiDeregistrations() {
        val deregister = HttpDeregistrationAggregator()
        val registration1 = HttpDeregistrationStub()
        val registration2 = HttpDeregistrationStub()

        deregister.addDeregistration(registration1)
        deregister.addDeregistration(registration2)

        deregister.deregister()

        assertThat(registration1.registered).isFalse()
        assertThat(registration2.registered).isFalse()
    }

    @Test
    fun clearAfterDeregister() {
        val aggregator = HttpDeregistrationAggregator()

        val registration = ThrowingAfterDeregistrationStub()

        aggregator.addDeregistration(registration)

        aggregator.deregister()
        aggregator.deregister()

        assertThat(registration.registered).isFalse()
    }
}

class HttpDeregistrationStub : HttpHandlerDeregistration {
    var registered = true
    private set

    override fun deregister() {
        registered = false
    }
}

class ThrowingAfterDeregistrationStub : HttpHandlerDeregistration {
    var registered = true
    private set

    /**
     * Non-conforming implementation to test that the Deregistrations are removed from the Aggregator after deregister is called
     */
    override fun deregister() {
        if (!registered) {
            throw Exception("This should not be called twice")
        }
        registered = false
    }

}
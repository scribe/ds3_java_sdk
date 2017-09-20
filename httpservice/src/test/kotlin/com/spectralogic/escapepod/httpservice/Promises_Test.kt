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

import com.spectralogic.escapepod.util.use
import io.reactivex.Completable
import org.junit.Test
import java.util.concurrent.atomic.AtomicBoolean

import org.assertj.core.api.Assertions.*
import ratpack.test.exec.ExecHarness

class Promises_Test {

    @Test
    fun fromCompletable() {
        ExecHarness.harness().use {
            val resultRan = AtomicBoolean(false)

            it.run {
                Completable.complete().toPromise().then {
                    resultRan.set(true)
                }
            }

            assertThat(resultRan).isTrue
        }
    }
}
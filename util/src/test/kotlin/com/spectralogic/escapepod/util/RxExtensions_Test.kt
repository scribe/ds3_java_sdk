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

package com.spectralogic.escapepod.util

import io.reactivex.Observable
import org.junit.Test

import org.assertj.core.api.Assertions.*

class RxExtensions_Test {

    @Test
    fun maxLong() {
        assertThat(Observable.just(2L, 5L, 1L).maxLong().blockingGet()).isEqualTo(5L)
    }

    @Test
    fun maxInt() {
        assertThat(Observable.just(2, 5, 10).maxInt().blockingGet()).isEqualTo(10)
        assertThat(Observable.just(15, 5, 10).maxInt().blockingGet()).isEqualTo(15)
    }

    @Test
    fun emptyMaxLong() {
        assertThat(Observable.empty<Long>().maxLong().blockingGet()).isEqualTo(0)
    }
}
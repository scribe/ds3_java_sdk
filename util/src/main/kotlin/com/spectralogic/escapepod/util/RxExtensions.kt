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

import io.reactivex.Maybe
import io.reactivex.Single
import java.util.*

fun <T> maybeOfNullable(item: T?, exceptionFactory: () -> Exception) : Maybe<T>  {
    return if (item == null) {
        Maybe.error(exceptionFactory())
    } else {
        Maybe.just(item)
    }
}

fun <T> Optional<T>.toRxMaybe(): Maybe<T> {
    return try {
        Maybe.just(this.get())
    } catch (e: NoSuchElementException) {
        Maybe.empty()
    }
}

fun <T> singleOfNullable(item: T?, exceptionFactory: () -> Exception) : Single<T>  {
    return if (item == null) {
        Single.error(exceptionFactory())
    } else {
        Single.just(item)
    }
}


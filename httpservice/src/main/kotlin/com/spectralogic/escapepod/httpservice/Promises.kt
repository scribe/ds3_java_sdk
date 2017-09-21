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

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import ratpack.exec.Promise

/**
 * Turns a RxJava Single into a RatPack Promise.
 */
fun <T: Any> Single<T>.toPromise(): Promise<T> {
    return Promise.async { emitter ->
        this.subscribe(emitter::success, emitter::error)
    }
}

/**
 * Converts an Observable to a Promise where the values emitted from the Observable have been
 * collected into a List
 */
fun <T: Any> Observable<T>.toPromise(): Promise<List<T>> {
    return Promise.async { emitter ->
        this.toList().subscribe(emitter::success, emitter::error)
    }
}

/**
 * Converts a Completable into a RatPack Promise.  When the Completable completes, null is emitted to the promise
 * since it doesn't have the same semantics as the Completable.
 */
fun Completable.toPromise(): Promise<Unit> {
    return Promise.async { emitter ->
        this.subscribe({emitter.success(null)}, emitter::error)
    }
}
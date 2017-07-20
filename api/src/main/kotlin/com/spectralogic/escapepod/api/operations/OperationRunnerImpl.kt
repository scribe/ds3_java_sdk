/*
 * ****************************************************************************
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

package com.spectralogic.escapepod.api.operations

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class OperationRunnerImpl : OperationRunner {
    override fun <ResultType> addAndRunOperation(operation: Operation<ResultType>,
                                                 vararg operationResultReporterThread: OperationResultReporterThread): Observable<ResultType>
    {
        val observable = Observable.create<ResultType> (
                { emitter ->
                    try {
                        val result = operation.call()

                        if (result != null) {
                            emitter.onNext(result)
                        }

                        operation.onComplete(result)
                        emitter.onComplete()
                    } catch (throwable: Throwable) {
                        operation.onError(throwable)
                        emitter.onError(throwable)
                    }
                }
        )

        if (operationResultReporterThread.isEmpty()) {
            return observableOnIOThread(observable)
        }

        return observableOnCallingThread(observable)
    }

    private fun <ResultType> observableOnIOThread(observable : Observable<ResultType>) : Observable<ResultType> {
        return observable
                .observeOn(Schedulers.io())
                .flatMap {
                    result -> newObservable(result)
                }
    }

    private fun <ResultType> observableOnCallingThread(observable : Observable<ResultType>) : Observable<ResultType> {
        return observable
                .flatMap {
                    result -> newObservable(result)
                }
    }

    private fun <ResultType> newObservable(result : ResultType) : Observable<ResultType> {
        return Observable.create({
            emitter -> emitter.onNext(result!!)
        })
    }
}
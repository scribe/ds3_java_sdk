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
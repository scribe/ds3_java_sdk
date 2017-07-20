package com.spectralogic.escapepod.api.operations

interface Operation<ResultType> {
    fun call() : ResultType
    fun onComplete(result: ResultType) {}
    fun cancel() {}
    fun onError(t: Throwable) {}
}

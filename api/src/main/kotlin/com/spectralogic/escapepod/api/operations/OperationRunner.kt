package com.spectralogic.escapepod.api.operations

import io.reactivex.Observable

enum class OperationResultReporterThread {
    CALLING_THREAD
}

interface OperationRunner {
    fun <ResultType> addAndRunOperation(operation: Operation<ResultType>, vararg operationResultReporterThread: OperationResultReporterThread) : Observable<ResultType>
}
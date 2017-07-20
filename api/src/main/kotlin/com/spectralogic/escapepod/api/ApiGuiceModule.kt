package com.spectralogic.escapepod.api

import com.google.inject.AbstractModule
import com.google.inject.Singleton
import com.spectralogic.escapepod.api.operations.OperationRunner
import com.spectralogic.escapepod.api.operations.OperationRunnerImpl

class ApiGuiceModule : AbstractModule() {
    override fun configure() {
        bind(OperationRunner::class.java).to(OperationRunnerImpl::class.java).`in`(Singleton::class.java)
    }
}
package com.spectralogic.escapepod.api

import com.google.inject.AbstractModule
import io.reactivex.Completable

interface ModuleRegistration<T : Module> {
    fun module() : Class<T>
    fun guiceModule() : AbstractModule
}

interface Module {
    fun loadModule() : Completable
    fun startModule() : Completable
    fun shutdownModule() : Completable
}
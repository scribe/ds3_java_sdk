package com.spectralogic.escapepod.api

import com.google.inject.AbstractModule
import io.reactivex.Completable

interface Module<T : ModuleLoader> {
    fun moduleLoader() : Class<T>
    fun guiceModule() : AbstractModule
}

interface ModuleLoader {
    fun loadModule() : Completable
    fun startModule() : Completable {
        return Completable.complete()
    }
}
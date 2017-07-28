package com.spectralogic.escapepod.server

import com.google.inject.Guice
import com.spectralogic.escapepod.api.ModuleRegistration

import com.spectralogic.escapepod.util.collections.toImmutableList
import io.reactivex.Completable

fun main(arg: Array<String>) {

    val moduleLoader = ModuleLoaderImpl()

    val loadedModules = moduleLoader.loadModules()

    val injector = Guice.createInjector(loadedModules.map(ModuleRegistration<*>::guiceModule).asIterable())

    val moduleInstances = loadedModules.map(ModuleRegistration<*>::module).map { injector.getInstance(it) }.toImmutableList()

    Runtime.getRuntime().addShutdownHook(ShutdownHook(moduleInstances))

    // 2 stage loading of the modules
    Completable.merge(moduleInstances.map { it.loadModule()}).subscribe()
    Completable.merge(moduleInstances.map { it.startModule() }).subscribe()

}



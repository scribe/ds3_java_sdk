package com.spectralogic.escapepod.server

import com.google.common.collect.ImmutableList
import com.google.inject.Guice
import com.spectra.escapepod.http.HttpModuleRegistration
import com.spectralogic.escapepod.cluster.ClusterModuleRegistration
import com.spectralogic.escapepod.persistence.PersistenceModuleRegistration
import com.spectralogic.escapepod.util.collections.GuavaCollectors
import io.reactivex.Completable

fun main(arg: Array<String>) {

    val clusterModule = ClusterModuleRegistration()
    val persistenceModule = PersistenceModuleRegistration()
    val httpModule = HttpModuleRegistration()

    val injector = Guice.createInjector(ServerModule(), clusterModule.guiceModule(), persistenceModule.guiceModule(), httpModule.guiceModule())

    val moduleList = ImmutableList.of(clusterModule, persistenceModule, httpModule)

    val moduleLoaders = moduleList.stream()
            .map { injector.getInstance(it.module()) }
            .collect(GuavaCollectors.immutableList())

    Runtime.getRuntime().addShutdownHook(ShutdownHook(moduleLoaders))

    // 2 stage loading of the modules
    Completable.merge(moduleLoaders.map { it.loadModule()}).subscribe()
    Completable.merge(moduleLoaders.map { it.startModule() }).subscribe()

}



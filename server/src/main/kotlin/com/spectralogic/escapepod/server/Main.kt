package com.spectralogic.escapepod.server

import com.google.common.collect.ImmutableList
import com.google.inject.Guice
import com.spectra.escapepod.http.HttpModule
import com.spectralogic.escapepod.cluster.ClusterModule
import com.spectralogic.escapepod.persistence.PersistenceModule
import com.spectralogic.escapepod.util.collections.GuavaCollectors
import io.reactivex.Completable

fun main(arg: Array<String>) {

    val clusterModule = ClusterModule()
    val persistenceModule = PersistenceModule()
    val httpModule = HttpModule()

    val injector = Guice.createInjector(ServerModule(), clusterModule.guiceModule(), persistenceModule.guiceModule(), httpModule.guiceModule())

    Runtime.getRuntime().addShutdownHook(injector.getInstance(ShutdownHook::class.java))

    val moduleList = ImmutableList.of(clusterModule, persistenceModule, httpModule)

    val moduleInstances = moduleList.stream()
            .map { injector.getInstance(it.moduleLoader()) }
            .collect(GuavaCollectors.immutableList())

    // 2 stage loading of the modules
    Completable.merge(moduleInstances.map { it.loadModule()}).subscribe()
    Completable.merge(moduleInstances.map { it.startModule() }).subscribe()
}

package com.spectralogic.escapepod.persistence

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.ClusterServiceProvider
import com.spectralogic.escapepod.api.Module
import com.spectralogic.escapepod.api.ModuleLoader
import io.reactivex.Completable
import javax.inject.Inject

class PersistenceModule : Module<PersistenceModuleLoader> {
    override fun moduleLoader(): Class<PersistenceModuleLoader> = PersistenceModuleLoader::class.java

    override fun guiceModule(): AbstractModule = XodusPersistenceGuiceModule()
}

class PersistenceModuleLoader @Inject internal constructor(private val clusterServiceProvider: ClusterServiceProvider, private val persistenceServiceProvider: XodusPersistenceProvider) : ModuleLoader {
    override fun loadModule(): Completable {
        return Completable.create { emitter ->

            clusterServiceProvider.clusterLifecycleEvents().subscribe(persistenceServiceProvider::clusterHandler)

            emitter.onComplete()
        }
    }

    override fun startModule(): Completable = persistenceServiceProvider.startService()
}
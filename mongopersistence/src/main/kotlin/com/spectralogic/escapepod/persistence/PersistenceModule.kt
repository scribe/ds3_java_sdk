package com.spectralogic.escapepod.persistence

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.ClusterServiceProvider
import com.spectralogic.escapepod.api.Module
import com.spectralogic.escapepod.api.ModuleLoader
import com.spectralogic.escapepod.api.PersistenceServiceProvider
import io.reactivex.Completable
import javax.inject.Inject

class PersistenceModule : Module<PersistenceModuleLoader> {
    override fun moduleLoader(): Class<PersistenceModuleLoader> {
        return PersistenceModuleLoader::class.java
    }

    override fun guiceModule(): AbstractModule {
        return MongoPersistenceGuiceModule()
    }
}

class PersistenceModuleLoader @Inject internal constructor(private val clusterServiceProvider: ClusterServiceProvider, private val persistenceServiceProvider: MongoPersistenceProvider) : ModuleLoader {
    override fun loadModule(): Completable {
        return Completable.create { emitter ->

            clusterServiceProvider.clusterLifecycleEvents().subscribe(persistenceServiceProvider::clusterHandler)

            emitter.onComplete()
        }
    }
}

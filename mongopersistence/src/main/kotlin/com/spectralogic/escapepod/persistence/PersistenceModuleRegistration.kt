package com.spectralogic.escapepod.persistence

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.ClusterServiceProvider
import com.spectralogic.escapepod.api.ModuleRegistration
import com.spectralogic.escapepod.api.Module
import io.reactivex.Completable
import javax.inject.Inject

class PersistenceModuleRegistration : ModuleRegistration<PersistenceModule> {
    override fun module(): Class<PersistenceModule> {
        return PersistenceModule::class.java
    }

    override fun guiceModule(): AbstractModule {
        return MongoPersistenceGuiceModule()
    }
}

class PersistenceModule @Inject internal constructor(private val clusterServiceProvider: ClusterServiceProvider, private val persistenceServiceProvider: MongoPersistenceProvider) : Module {
    override fun loadModule(): Completable {
        return Completable.create { emitter ->

            clusterServiceProvider.clusterLifecycleEvents().subscribe(persistenceServiceProvider::clusterHandler)

            emitter.onComplete()
        }
    }
}

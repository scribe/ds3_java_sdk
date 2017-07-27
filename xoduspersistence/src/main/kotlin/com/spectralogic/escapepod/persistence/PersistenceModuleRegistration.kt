package com.spectralogic.escapepod.persistence

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.ClusterServiceProvider
import com.spectralogic.escapepod.api.ModuleRegistration
import com.spectralogic.escapepod.api.Module
import io.reactivex.Completable
import javax.inject.Inject

class PersistenceModuleRegistration : ModuleRegistration<PersistenceModule> {
    override fun module(): Class<PersistenceModule> = PersistenceModule::class.java

    override fun guiceModule(): AbstractModule = XodusPersistenceGuiceModule()
}

class PersistenceModule @Inject internal constructor(private val clusterServiceProvider: ClusterServiceProvider, private val persistenceServiceProvider: XodusPersistenceProvider) : Module {

    override val name: String = "Persistence"

    override fun loadModule(): Completable {
        return Completable.create { emitter ->

            clusterServiceProvider.clusterLifecycleEvents().subscribe(persistenceServiceProvider::clusterHandler)

            emitter.onComplete()
        }
    }

    override fun startModule(): Completable = persistenceServiceProvider.startService()

    override fun shutdownModule(): Completable = persistenceServiceProvider.shutdown()

}
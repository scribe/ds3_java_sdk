package com.spectralogic.escapepod.metadatasearch

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.*
import io.reactivex.Completable
import javax.inject.Inject

class MetadataSearchModuleRegistration : ModuleRegistration<MetadataSearchModule> {
    override fun module(): Class<MetadataSearchModule> = MetadataSearchModule::class.java

    override fun guiceModule(): AbstractModule = ElasticSearchGuiceModule()
}

class MetadataSearchModule
@Inject constructor(
        private val clusterServiceProvider: ClusterServiceProvider,
        private val metadataSearchServiceProvider: MetadataSearchServiceProvider) : Module {

    override val name: String = "Metadata Search"

    override fun loadModule(): Completable {
        return Completable.create { emitter ->
            clusterServiceProvider.clusterLifecycleEvents().subscribe(metadataSearchServiceProvider::clusterHandler)
            emitter.onComplete()
        }
    }

    override fun startModule(): Completable = Completable.complete()

    override fun shutdownModule(): Completable = Completable.complete()

}
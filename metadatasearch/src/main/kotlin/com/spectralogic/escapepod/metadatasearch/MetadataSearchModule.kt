package com.spectralogic.escapepod.metadatasearch

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.ClusterServiceProvider
import com.spectralogic.escapepod.api.MetadataSearchServiceProvider
import com.spectralogic.escapepod.api.Module
import com.spectralogic.escapepod.api.ModuleLoader
import io.reactivex.Completable
import javax.inject.Inject

class MetadataSearchModule : Module<MetadataSearchModuleLoader> {
    override fun moduleLoader(): Class<MetadataSearchModuleLoader> {
        return MetadataSearchModuleLoader::class.java
    }

    override fun guiceModule(): AbstractModule {
        return ElasticSearchGuiceModule()
    }
}

class MetadataSearchModuleLoader
@Inject constructor(
        private val clusterServiceProvider: ClusterServiceProvider,
        private val metadataSearchServiceProvider: MetadataSearchServiceProvider) : ModuleLoader {

    override fun loadModule(): Completable {
        return Completable.create { emitter ->
            clusterServiceProvider.clusterLifecycleEvents().subscribe(metadataSearchServiceProvider::clusterHandler)
            emitter.onComplete()
        }
    }
}
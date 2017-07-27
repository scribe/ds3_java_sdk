package com.spectra.escapepod.http

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.ClusterServiceProvider
import com.spectralogic.escapepod.api.Module
import com.spectralogic.escapepod.api.ModuleLoader
import io.reactivex.Completable
import javax.inject.Inject

class HttpModule : Module<HttpModuleLoader> {
    override fun moduleLoader(): Class<HttpModuleLoader> = HttpModuleLoader::class.java

    override fun guiceModule(): AbstractModule = HttpGuiceModule()
}

class HttpModuleLoader @Inject internal constructor(private val clusterServiceProvider: ClusterServiceProvider, private val httpServiceProvider: HttpProvider): ModuleLoader {
    override fun loadModule(): Completable {
        return Completable.create { emitter ->
            clusterServiceProvider.clusterLifecycleEvents().subscribe(httpServiceProvider::clusterHandler)
            emitter.onComplete()
        }
    }

    override fun startModule(): Completable = httpServiceProvider.startService()
}
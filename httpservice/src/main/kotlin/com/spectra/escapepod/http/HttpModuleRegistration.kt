package com.spectra.escapepod.http

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.ClusterServiceProvider
import com.spectralogic.escapepod.api.ModuleRegistration
import com.spectralogic.escapepod.api.Module
import io.reactivex.Completable
import javax.inject.Inject

class HttpModuleRegistration : ModuleRegistration<HttpModule> {
    override fun module(): Class<HttpModule> = HttpModule::class.java

    override fun guiceModule(): AbstractModule = HttpGuiceModule()
}

class HttpModule @Inject internal constructor(private val clusterServiceProvider: ClusterServiceProvider, private val httpServiceProvider: HttpProvider): Module {
    override fun loadModule(): Completable {
        return Completable.create { emitter ->
            clusterServiceProvider.clusterLifecycleEvents().subscribe(httpServiceProvider::clusterHandler)
            emitter.onComplete()
        }
    }

    override fun startModule(): Completable = httpServiceProvider.startService()

    override fun shutdownModule(): Completable = httpServiceProvider.shutdown()
}
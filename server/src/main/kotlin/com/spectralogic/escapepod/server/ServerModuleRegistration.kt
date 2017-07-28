package com.spectralogic.escapepod.server

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.Module
import com.spectralogic.escapepod.api.ModuleRegistration
import io.reactivex.Completable

internal class ServerModule : Module {
    override val name: String = "Server"

    override fun loadModule(): Completable = Completable.complete()


    override fun startModule(): Completable = Completable.complete()

    override fun shutdownModule(): Completable = Completable.complete()

}

internal class ServerModuleRegistration : ModuleRegistration<ServerModule> {
    override fun module(): Class<ServerModule> = ServerModule::class.java

    override fun guiceModule(): AbstractModule = ServerGuiceModule()

}
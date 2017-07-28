package com.spectralogic.escapepod.api

import com.google.inject.AbstractModule
import io.reactivex.Completable

/**
 * ModuleRegistrations are used to retrieve all the Modules.  These Registrations are retrieved at runtime by the
 * ServiceLoader interface, and as such must register the registration in the file:
 * "META-INF/services/com.spectralogic.escapepod.api.ModuleRegistration"
 * interface.
 */
interface ModuleRegistration<T : Module> {
    fun module() : Class<T>
    fun guiceModule() : AbstractModule
}

interface Module {
    val name : String
    fun loadModule() : Completable
    fun startModule() : Completable
    fun shutdownModule() : Completable
}
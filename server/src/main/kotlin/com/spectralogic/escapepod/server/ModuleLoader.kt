package com.spectralogic.escapepod.server

import com.spectralogic.escapepod.api.ModuleRegistration
import java.util.*

internal interface ModuleLoader {
    fun loadModules() : Sequence<ModuleRegistration<*>>
}

internal class ModuleLoaderImpl : ModuleLoader {
    override fun loadModules(): Sequence<ModuleRegistration<*>> {
        val serviceLoader = ServiceLoader.load(ModuleRegistration::class.java)
        return serviceLoader.asSequence()
    }
}
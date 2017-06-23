package com.spectralogic.escapepod.divaclient

import com.google.inject.AbstractModule
import com.google.inject.assistedinject.FactoryModuleBuilder
import com.spectralogic.escapepod.api.DivaClientFactory

class DivaClientGuiceModule : AbstractModule() {
    override fun configure() {
        install(FactoryModuleBuilder().build(DivaClientFactory::class.java))
    }
}

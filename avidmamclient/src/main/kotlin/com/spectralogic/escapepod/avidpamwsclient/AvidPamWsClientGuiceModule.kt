package com.spectralogic.escapepod.avidpamwsclient

import com.google.inject.AbstractModule
import javax.inject.Singleton

class AvidPamWsClientGuiceModule : AbstractModule() {
    override fun configure() {
        bind(AvidPamWsClientModuleRegistration::class.java)
        bind(AvidPamPersistenceHandlers::class.java).`in`(Singleton::class.java)
    }
}
package com.spectralogic.escapepod.avidpamwsclient

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.AvidPamWsClientBuilder
import javax.inject.Singleton

class AvidPamWsClientGuiceModule : AbstractModule() {
    override fun configure() {
        bind(AvidPamWsClientModuleRegistration::class.java)
        bind(AvidPamPersistenceHandlers::class.java).`in`(Singleton::class.java)
        bind(AvidPamWsClientBuilder::class.java).to(AvidPamWsClientBuilderImpl::class.java).`in`(Singleton::class.java)
        bind(AvidPamWsClientHandlers::class.java).`in`(Singleton::class.java)
    }
}
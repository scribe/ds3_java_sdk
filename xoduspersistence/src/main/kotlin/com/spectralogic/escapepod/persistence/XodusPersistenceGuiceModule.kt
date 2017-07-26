package com.spectralogic.escapepod.persistence

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.PersistenceServiceProvider
import javax.inject.Singleton

internal class XodusPersistenceGuiceModule : AbstractModule() {
    override fun configure() {
        bind(PersistenceServiceProvider::class.java).to(XodusPersistenceProvider::class.java)
        bind(PersistenceModuleLoader::class.java)
    }
}
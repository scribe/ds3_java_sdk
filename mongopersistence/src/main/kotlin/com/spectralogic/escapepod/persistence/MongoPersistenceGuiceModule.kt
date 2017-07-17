package com.spectralogic.escapepod.persistence

import com.google.inject.AbstractModule
import com.google.inject.Provides
import com.spectralogic.escapepod.api.PersistenceServiceProvider
import javax.inject.Named
import javax.inject.Singleton

internal class MongoPersistenceGuiceModule : AbstractModule() {
    override fun configure() {
        bind(PersistenceServiceProvider::class.java).to(MongoPersistenceProvider::class.java).`in`(Singleton::class.java)
        bind(PersistenceModuleLoader::class.java)
    }
}
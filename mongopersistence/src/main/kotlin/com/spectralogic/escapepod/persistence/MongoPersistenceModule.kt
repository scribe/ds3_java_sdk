package com.spectralogic.escapepod.persistence

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.PersistenceService
import javax.inject.Singleton

class MongoPersistenceModule : AbstractModule() {
    override fun configure() {
        bind(PersistenceService::class.java).to(MongoPersistence::class.java).`in`(Singleton::class.java)
    }
}

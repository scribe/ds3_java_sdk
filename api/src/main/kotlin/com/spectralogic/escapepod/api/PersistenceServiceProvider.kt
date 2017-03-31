package com.spectralogic.escapepod.api

import io.reactivex.Completable

interface PersistenceServiceProvider : ServiceProvider<PersistenceService> {
    fun joinPersistenceCluster(name : String, nodes : Sequence<String>) : Completable
    fun createNewPersistenceCluster(name : String, port : Int) : Completable
}

interface PersistenceService

class PersistenceException(message : String) : RuntimeException(message)
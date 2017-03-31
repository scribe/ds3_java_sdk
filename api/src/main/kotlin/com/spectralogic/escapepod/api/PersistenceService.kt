package com.spectralogic.escapepod.api

import io.reactivex.Completable

interface PersistenceService {
    fun joinPersistenceCluster(name : String, nodes : Sequence<String>)
    fun createNewPersistenceCluster(name : String, port : Int)
    fun shutdown() : Completable
}

class PersistenceException(message : String) : RuntimeException(message)
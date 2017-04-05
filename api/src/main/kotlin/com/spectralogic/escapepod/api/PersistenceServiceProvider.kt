package com.spectralogic.escapepod.api

import io.reactivex.Completable

interface PersistenceServiceProvider : ServiceProvider<PersistenceService> {
    fun joinPersistenceCluster(name : String, port : Int) : Completable
    fun createNewPersistenceCluster(name : String, port : Int) : Completable
    fun leavePersistenceCluster() : Completable
    fun clusterHandler(event : ClusterEvent)
}

interface PersistenceService

class PersistenceException(message : String) : RuntimeException(message)
package com.spectralogic.escapepod.avidpamwsclient

import com.google.common.collect.ImmutableMap
import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.util.collections.toImmutableList
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import org.slf4j.LoggerFactory
import javax.inject.Inject

internal class AvidPamPersistenceHandlers
@Inject constructor(private val persistenceServiceProvider: PersistenceServiceProvider) {

    companion object {
        private val LOG = LoggerFactory.getLogger(AvidPamPersistenceHandlers::class.java)
        internal val PAM_NODE_TYPE = "pam"
    }

    fun getAllPamSystems(): Observable<PersistenceEntity> {
        return persistenceServiceProvider.getService(RequestContext())
                .flatMapObservable { persistenceService ->
                    Observable.fromIterable(persistenceService.get("pam").toImmutableList())
                }
    }

    fun getPamSystem(name: String): Single<PersistenceEntity> {
        return persistenceServiceProvider.getService(RequestContext())
                .flatMap { persistenceService ->
                    val persistenceEntity = persistenceService.find(PAM_NODE_TYPE, "name", name as Comparable<Any?>).firstOrNull()
                    if (persistenceEntity != null) {
                        Single.just(persistenceEntity)
                    } else {
                        val message = "A Pam system with name '$name' was not found."
                        Single.error(PamNotFoundException(message))
                    }
                }
    }

    fun postPamSystem(name: String, username: String, password: String, endpoint: String, workGroup: String): Single<PersistenceEntity> {
        return persistenceServiceProvider.getService(RequestContext())
                .flatMap { persistenceService ->
                    if (persistenceService.find(PAM_NODE_TYPE, "name", name as Comparable<Any?>).any()) {
                        val message = "A Pam system with name '$name' already exists."
                        Single.error(PamExistsException(message))
                    } else {
                        val pamSystem = ImmutableMap.of(
                                "name", name,
                                "username", username,
                                "password", password,
                                "endpoint", endpoint,
                                "workgroup", workGroup
                        )

                        //TODO map result to different type (ex not including password)
                        Single.just(persistenceService.addNode(PAM_NODE_TYPE, pamSystem as Map<String, Comparable<Any?>>))
                    }
                }
    }

    fun putPamSystem(name: String, username: String, password: String, endpoint: String, workGroup: String): Single<PersistenceEntity> {
        return persistenceServiceProvider.getService(RequestContext())
                .flatMap { persistenceService ->
                    val pamSystem = ImmutableMap.of(
                            "name", name,
                            "username", username,
                            "password", password,
                            "endpoint", endpoint,
                            "workgroup", workGroup
                    ) as Map<String, Comparable<Any?>>

                    val persistenceEntity = persistenceService.find(PAM_NODE_TYPE, "name", name as Comparable<Any?>).firstOrNull()

                    if (persistenceEntity != null) {
                        //if found update
                        Single.just(persistenceService.updateNode(persistenceEntity.id, pamSystem))
                    } else {
                        // if not found create
                        Single.just(persistenceService.addNode(PAM_NODE_TYPE, pamSystem))
                    }
                }
    }

    fun deleteAllPamSystems(): Completable {
        return persistenceServiceProvider.getService(RequestContext())
                .flatMapCompletable { persistenceService ->
                    persistenceService.get(PAM_NODE_TYPE).forEach { pamSystem ->
                        persistenceService.deleteNode(pamSystem.id)
                    }
                    Completable.complete()
                }
    }

    fun deletePamSystem(name: String): Completable {
        return persistenceServiceProvider.getService(RequestContext())
                .flatMapCompletable { persistenceService ->
                    val persistenceEntity = persistenceService.find(PAM_NODE_TYPE, "name", name as Comparable<Any?>).firstOrNull()
                    if (persistenceEntity != null) {
                        persistenceService.deleteNode(persistenceEntity.id)
                        Completable.complete()
                    } else {
                        val message = "A Pam system with name '$name' was not found."
                        Completable.error(PamNotFoundException(message))
                    }
                }
    }
}
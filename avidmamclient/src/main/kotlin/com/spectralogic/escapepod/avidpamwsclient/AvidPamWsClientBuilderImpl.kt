package com.spectralogic.escapepod.avidpamwsclient

import com.spectralogic.escapepod.api.*
import io.reactivex.Single
import javax.inject.Inject

internal class AvidPamWsClientBuilderImpl
@Inject constructor(private val persistenceServiceProvider: PersistenceServiceProvider) : AvidPamWsClientBuilder {
    override fun buildAvidPamWsClient(name: String): Single<AvidPamWsClient> {
        return persistenceServiceProvider.getService(RequestContext())
                .flatMap { persistenceService ->
                    val persistenceEntity = persistenceService.find(AvidPamPersistenceHandlers.PAM_NODE_TYPE, "name", name as Comparable<Any?>).firstOrNull()
                    if (persistenceEntity != null) {
                        Single.just(AvidPamWsClientImpl(
                                persistenceEntity.properties["name"].toString(),
                                persistenceEntity.properties["username"].toString(),
                                persistenceEntity.properties["password"].toString(),
                                persistenceEntity.properties["endpoint"].toString(),
                                persistenceEntity.properties["workgroup"].toString()))
                    } else {
                        val message = "A Pam system with name '$name' was not found."
                        Single.error(PamNotFoundException(message))
                    }
                }
    }

}

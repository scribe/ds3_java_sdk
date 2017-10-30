package com.spectralogic.escapepod.flashnetclient

import com.google.inject.Inject
import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.flashnetclient.requests.FlashNetRequestFactory
import com.spectralogic.escapepod.flashnetclient.requests.Status
import com.spectralogic.escapepod.flashnetclient.responses.FlashNetReplyFactory
import com.spectralogic.escapepod.flashnetclient.transport.SocketProvider
import io.reactivex.Observable
import io.reactivex.Single

class FlashNetVideoMediaClient @Inject constructor(private val endpoint: FlashnetEndpoint, private val requestFactory: FlashNetRequestFactory, private val socketProvider: SocketProvider) : VideoMediaClient {

    override fun listStorageGroups(): Observable<StorageGroup> {

        val listGroupRequest = requestFactory.toListGroupRequest()

        return socketProvider.socket(endpoint).flatMap{
            it.writeRead(listGroupRequest)
        }.map {
            FlashNetReplyFactory.fromResponsePayload(it)
        }.flatMap {
            it.toListGroupReply()
        }.flatMapObservable {
            Observable.fromIterable(it.groups)
        }.map {
            StorageGroup(it.groupName)
        }
    }

    override fun listStorageGroupContents(storageGroup: StorageGroup): Observable<StorageGroupItem> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun restoreAssets(itemsToMigrate: Sequence<StorageGroupItem>, migrationDestination: String, priority: MigrationPriority): Single<Int> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getStatus(requestId: Int): Single<RequestStatus> {
        val statusRequest = requestFactory.toStatusRequest(Status(requestId, null))

        return socketProvider.socket(endpoint).flatMap {
            it.writeRead(statusRequest)
        }.map {
            FlashNetReplyFactory.fromResponsePayload(it)
        }.flatMap {
            it.toStatusReply()
        }.map {
            RequestStatus(it.jobStatus, it.processType)
        }

    }

    override fun cancelRequest(requetId: Int): Single<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // TODO add the list servers command
}
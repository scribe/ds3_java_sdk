package com.spectralogic.escapepod.flashnetclient

import com.google.inject.Inject
import com.spectralogic.escapepod.api.*
import io.reactivex.Observable

class FlashNetVideoMediaClient @Inject constructor(private val flashNetConfig: FlashNetConfig) : VideoMediaClient {
    override fun listStorageGroups(): Observable<StorageGroup> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun listStorageGroupContents(storageGroup: StorageGroup): Observable<StorageGroupItem> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T> beginMigration(itemsToMigrate: Sequence<StorageGroupItem>, migrationDestination: String, priority: MigrationPriority): Observable<MigrationJobId<T>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T> getMigrationStatus(migrationJobId: MigrationJobId<T>): Observable<MigrationStatus> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T> cancelMigration(migrationJobId: MigrationJobId<T>): Observable<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
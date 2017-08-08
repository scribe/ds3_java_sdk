package com.spectralogic.escapepod.api

import io.reactivex.Observable

// Asynchronous: Implement observable to know when operation is complete

interface VideoMediaClient {
    fun listStorageGroups() : Observable<StorageGroup>
    fun listStorageGroupContents(storageGroup: StorageGroup) : Observable<StorageGroupItem>

    // Returns migration job id
    // Category? -- FlashNet doesn't have that concept as a separate entity
    // Asynchronous: Call to start a migration.  Implement observable to know when migration is complete
    fun beginMigration(itemsToMigrate : Sequence<StorageGroupItem>, migrationDestination : String, priority : MigrationPriority) : Observable<Long>

    // TODO: Create abstraction for migrationJobId
    fun getMigrationStatus(migrationJobId : Long) : Observable<MigrationStatus>

    fun cancelMigration(migrationJobId : Long) : Observable<String>
}
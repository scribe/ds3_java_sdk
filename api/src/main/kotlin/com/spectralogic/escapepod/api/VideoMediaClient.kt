/*
 * ****************************************************************************
 *    Copyright 2014-2017 Spectra Logic Corporation. All Rights Reserved.
 *    Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *    this file except in compliance with the License. A copy of the License is located at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *    or in the "license" file accompanying this file.
 *    This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *    CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *    specific language governing permissions and limitations under the License.
 *  ****************************************************************************
 */

package com.spectralogic.escapepod.api

import io.reactivex.Observable

// Asynchronous: Implement observable to know when operation is complete

interface VideoMediaClient {
    fun listStorageGroups() : Observable<StorageGroup>
    fun listStorageGroupContents(storageGroup: StorageGroup) : Observable<StorageGroupItem>

    // Returns migration job id
    // Category? -- FlashNet doesn't have that concept as a separate entity
    // Asynchronous: Call to start a migration.  Implement observable to know when migration is complete
    fun <T> beginMigration(itemsToMigrate : Sequence<StorageGroupItem>, migrationDestination : String, priority : MigrationPriority) : Observable<MigrationJobId<T>>

    // TODO: Create abstraction for migrationJobId
    fun <T> getMigrationStatus(migrationJobId : MigrationJobId<T>) : Observable<MigrationStatus>

    fun <T> cancelMigration(migrationJobId : MigrationJobId<T>) : Observable<String>
}
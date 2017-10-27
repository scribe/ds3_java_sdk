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
import io.reactivex.Single

// Asynchronous: Implement observable to know when operation is complete

interface VideoMediaClient {
    fun listStorageGroups() : Observable<StorageGroup>
    fun listStorageGroupContents(storageGroup: StorageGroup) : Observable<StorageGroupItem>

    // Returns migration job id
    // Category? -- FlashNet doesn't have that concept as a separate entity
    // Asynchronous: Call to start a migration.  Implement observable to know when migration is complete
    fun restoreAssets(itemsToMigrate : Sequence<StorageGroupItem>, migrationDestination : String, priority : MigrationPriority) : Single<Int>

    // TODO: Create abstraction for migrationJobId
    fun getStatus(requestId: Int) : Single<RequestStatus>

    fun cancelRequest(requestId: Int) : Single<String>
}
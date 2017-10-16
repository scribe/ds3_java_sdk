/*
 * *****************************************************************************
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

interface DivaClientFactory {
    fun create(endpoint: String) : DivaClient
}

interface DivaClient {
    fun tapeGroups() : Observable<DivaTapeGroup>

    /**
     * Returns a list of objects for the given tape group
     */
    fun objects(tapeGroupName: String) : Observable<DivaObject>

    /**
     * TODO make destinationPath a Path object instead of a string
     *
     * @return Returns a Single that contains the diva request id if the request completed successfully
     */
    fun restore(objectName: String, objectCategory: String, destination: String, destinationPath: String) : Single<Long>

    fun restoreStatus(requestId : Long) : Single<DivaRestoreStatus>

    fun objectInfo(objectName: String, category: String = "DEFAULT") : Single<DivaObjectInfo>

    fun sourceList() : Observable<DivaSource>
}

data class DivaTapeGroup(val name: String)
data class DivaObject(val name: String)
data class DivaObjectInfo(val name: String, val totalSizeInByte : Long, val files: Sequence<DivaFile>)
data class DivaSource(val address: String, val name: String)
data class DivaRestoreStatus(val requestState : Int)

data class DivaFile(val name : String)
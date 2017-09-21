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

import com.google.common.collect.ImmutableMap
import com.google.common.collect.ImmutableMultimap
import io.reactivex.Completable

interface PersistenceServiceProvider : ServiceProvider<PersistenceService> {
    fun joinPersistenceCluster(name : String, port : Int) : Completable
    fun createNewPersistenceCluster(name : String, port : Int) : Completable
    fun leavePersistenceCluster() : Completable
}

interface PersistenceService {
    fun link(source: PersistenceID, link: String, destination: PersistenceID)
    fun addNode(nodeType: String, properties: Map<String, Comparable<Any?>> = emptyMap()): PersistenceEntity
    fun find(nodeType: String, property: String, value: Comparable<Any?>): Sequence<PersistenceEntity>
    fun get(nodeType: String): Sequence<PersistenceEntity>
    fun get(id: PersistenceID): PersistenceEntity
}

data class PersistenceID(val typeId: Int, val localId: Long)
data class PersistenceEntity(val id: PersistenceID, val properties: ImmutableMap<String, Comparable<Any?>>, val links: ImmutableMultimap<String, PersistenceID>)

class PersistenceException(message : String) : RuntimeException(message)
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

package com.spectralogic.escapepod.persistence

import com.google.common.collect.ImmutableMap
import com.google.common.collect.ImmutableMultimap
import com.spectralogic.escapepod.api.PersistenceEntity
import com.spectralogic.escapepod.api.PersistenceID
import com.spectralogic.escapepod.api.PersistenceService
import com.spectralogic.escapepod.util.collections.immutableListCollector
import jetbrains.exodus.entitystore.Entity
import jetbrains.exodus.entitystore.EntityId
import jetbrains.exodus.entitystore.PersistentEntityId
import jetbrains.exodus.entitystore.PersistentEntityStore

internal class XodusPersistenceService(private val entityStore: PersistentEntityStore) : PersistenceService {

    override fun get(id: PersistenceID): PersistenceEntity {
        return entityStore.computeInReadonlyTransaction {
            val entity = it.getEntity(id.toEntityId())

            entity.toPersistenceEntity()
        }
    }

    override fun get(nodeType: String): Sequence<PersistenceEntity> {
        return entityStore.computeInReadonlyTransaction {
            val entities = it.getAll(nodeType)
            entities.toList()
                    .stream()
                    .map(Entity::toPersistenceEntity)
                    .collect(immutableListCollector())
        }.asSequence()
    }

    override fun find(nodeType: String, property: String, value: Comparable<Any?>): Sequence<PersistenceEntity> {
        return entityStore.computeInReadonlyTransaction {
            val entities = it.find(nodeType, property, value)
            entities.toList()
                    .stream()
                    .map(Entity::toPersistenceEntity)
                    .collect(immutableListCollector())
        }.asSequence()
    }

    override fun addNode(nodeType: String, properties: Map<String, Comparable<Any?>>): PersistenceEntity {
        return entityStore.computeInTransaction {
            val e: Entity = it.newEntity(nodeType)

            for((k,v) in properties) {
                e.setProperty(k, v)
            }

            e.toPersistenceEntity()
        }
    }

    override fun link(source: PersistenceID, link: String, destination: PersistenceID) {

        entityStore.executeInTransaction {
            val entity = it.getEntity(source.toEntityId())

            entity.addLink(link, it.getEntity(destination.toEntityId()))
        }
    }
}

private fun Entity.toPersistenceEntity(): PersistenceEntity {
    return PersistenceEntity(this.id.toPersistenceId(), this.properties(), this.linkIdList())
}

private fun Entity.properties(): ImmutableMap<String, Comparable<Any?>> {
    val propertiesBuilder: ImmutableMap.Builder<String, Comparable<Any?>> = ImmutableMap.builder<String, Comparable<Any?>>()

    this.propertyNames.forEach { propertyName ->
        propertiesBuilder.put(propertyName, this.getProperty(propertyName))
    }

    return propertiesBuilder.build()
}

private fun Entity.linkIdList(): ImmutableMultimap<String, PersistenceID> {
    val linkBuilder: ImmutableMultimap.Builder<String, PersistenceID> = ImmutableMultimap.builder<String, PersistenceID>()

    this.linkNames.forEach {
        val entityIterable = this.getLinks(it)

        linkBuilder.putAll(it, entityIterable.map(Entity::getId).map(EntityId::toPersistenceId))
    }

    return linkBuilder.build()
}

private fun PersistenceID.toEntityId(): EntityId {
    return PersistentEntityId(this.typeId, this.localId)
}

private fun EntityId.toPersistenceId(): PersistenceID {
    return PersistenceID(this.typeId, this.localId)
}
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
import com.spectralogic.escapepod.api.PersistenceEntity
import com.spectralogic.escapepod.api.PersistenceID
import com.spectralogic.escapepod.api.PersistenceService
import jetbrains.exodus.entitystore.Entity
import jetbrains.exodus.entitystore.EntityId
import jetbrains.exodus.entitystore.PersistentEntityId
import jetbrains.exodus.entitystore.PersistentEntityStore

internal class XodusPersistenceService(private val entityStore: PersistentEntityStore) : PersistenceService {

    override fun get(nodeType: String): Sequence<PersistenceEntity> {
        val tx = entityStore.beginReadonlyTransaction()
        val entities = tx.getAll(nodeType)
        tx.commit()
        return entities.asSequence().map(Entity::toPersistenceEntity)
    }

    override fun get(nodeType: String, property: String, value: Comparable<Any?>): Sequence<PersistenceEntity> {
        val tx = entityStore.beginReadonlyTransaction()
        val entities = tx.find(nodeType, property, value)
        tx.commit()
        return entities.asSequence().map(Entity::toPersistenceEntity)
    }

    override fun addNode(nodeType: String, properties: Map<String, Comparable<Any?>>): PersistenceEntity {
        val tx = entityStore.beginTransaction()
        val e: Entity = tx.newEntity(nodeType)
        for((k,v) in properties) {
            e.setProperty(k, v)
        }
        tx.commit()
        return e.toPersistenceEntity()
    }

    override fun link(source: PersistenceID, link: String, destination: PersistenceID) {
        entityStore.executeInTransaction {
            entityStore.getEntity(source.toEntityId())
                    .addLink(link, entityStore.getEntity(destination.toEntityId()))
        }
    }
}

private fun Entity.toPersistenceEntity(): PersistenceEntity {
    return PersistenceEntity(this.id.toPersistenceId(), this.properties())
}

private fun Entity.properties(): ImmutableMap<String, Comparable<Any?>> {
    val propertiesBuilder: ImmutableMap.Builder<String, Comparable<Any?>> = ImmutableMap.builder<String, Comparable<Any?>>()

    this.propertyNames.forEach { propertyName ->
        propertiesBuilder.put(propertyName, this.getProperty(propertyName))
    }

    return propertiesBuilder.build()
}

private fun PersistenceID.toEntityId(): EntityId {
    return PersistentEntityId(this.typeId, this.localId)
}

private fun EntityId.toPersistenceId(): PersistenceID {
    return PersistenceID(this.typeId, this.localId)
}
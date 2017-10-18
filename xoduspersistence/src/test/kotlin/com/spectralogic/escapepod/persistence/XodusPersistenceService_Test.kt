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
import com.spectralogic.escapepod.api.RequestContext
import jetbrains.exodus.entitystore.PersistentEntityStores
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

import org.assertj.core.api.Assertions.assertThat

class XodusPersistenceService_Test {

    @get:Rule
    val tempDir = TemporaryFolder()

    @Test
    fun createNode() {
        withPersistenceService {
            val entity = it.addNode("type", ImmutableMap.of<String, String>("key", "value") as Map<String, Comparable<Any?>>)

            assertThat(entity.id).isNotNull()

            assertThat(entity.properties["key"]).isNotNull()
            assertThat(entity.properties["key"]).isEqualTo("value")
        }
    }

    @Test
    fun linkNode() {
        withPersistenceService {
            val entity1 = it.addNode("type", ImmutableMap.of<String, String>("key", "value1") as Map<String, Comparable<Any?>>)
            val entity2 = it.addNode("type", ImmutableMap.of<String, String>("key", "value2") as Map<String, Comparable<Any?>>)

            it.link(entity1.id, "hasA", entity2.id)

            val entityWithLink = it.get(entity1.id)

            assertThat(entityWithLink.links).isNotNull()
            assertThat(entityWithLink.links.size()).isEqualTo(1)
            assertThat(entityWithLink.links.get("hasA").asList()[0]).isEqualTo(entity2.id)
        }
    }

    @Test
    fun listNodes() {
        withPersistenceService {
            it.addNode("type", ImmutableMap.of<String, String>("key", "value1") as Map<String, Comparable<Any?>>)
            it.addNode("type", ImmutableMap.of<String, String>("key", "value2") as Map<String, Comparable<Any?>>)

            val sequence = it.get("type")

            assertThat(sequence.count()).isEqualTo(2)
        }
    }

    @Test
    fun findNode() {
        withPersistenceService {
            it.addNode("type", ImmutableMap.of<String, String>("key", "value1") as Map<String, Comparable<Any?>>)
            it.addNode("type", ImmutableMap.of<String, String>("key", "value2") as Map<String, Comparable<Any?>>)

            val sequence = it.find("type", "key", "value2" as Comparable<Any?>)

            assertThat(sequence.count()).isEqualTo(1)
        }
    }

    @Test
    fun deleteNode() {
        withPersistenceService {

        }
    }

    private fun withPersistenceService(test: (persistenceService: XodusPersistenceService)->Unit) {
        val xodusPersistentStore = PersistentEntityStores.newInstance(tempDir.newFolder())

        xodusPersistentStore.use {
            val persistenceService = XodusPersistenceService(xodusPersistentStore, createTestRequestContext())
            test(persistenceService)
        }
    }
}

fun createTestRequestContext(): RequestContext {
    return RequestContext()
}

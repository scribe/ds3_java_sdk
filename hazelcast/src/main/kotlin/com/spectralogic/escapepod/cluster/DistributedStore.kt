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

package com.spectralogic.escapepod.cluster

import com.hazelcast.core.HazelcastInstance
import com.spectralogic.escapepod.api.DistributedMap
import com.spectralogic.escapepod.api.DistributedSet
import com.spectralogic.escapepod.api.Shutdownable
import io.reactivex.Completable
import io.reactivex.Single

internal interface DistributedStore<T: Any> {
    fun store(name: String): Single<T>
}

internal class MapStore constructor(private val hazelcastInstance: HazelcastInstance): DistributedStore<DistributedMap<*, *>>, Shutdownable {

    private val maps = HashMap<String, HazelcastDistributedMap<*, *>>()

    override fun store(name: String): Single<DistributedMap<*, *>> {
        if (maps.containsKey(name)) {
            return Single.just(maps[name])
        }

        val newMap = HazelcastDistributedMap<Any, Any>(hazelcastInstance.getMap(name))
        maps[name] = newMap

        return Single.just(newMap)
    }

    override fun shutdown(): Completable {

        return Completable.create {
            maps.forEach {
                it.value.cleanup()
            }

            it.onComplete()
        }
    }
}

internal class SetStore constructor(private val hazelcastInstance: HazelcastInstance): DistributedStore<DistributedSet<*>>, Shutdownable {

    private val sets = HashMap<String, HazelcastDistributedSet<*>>()

    override fun store(name: String): Single<DistributedSet<*>> {
        if (sets.containsKey(name)) {
            return Single.just(sets[name])
        }
        val newSet = HazelcastDistributedSet<Any>(hazelcastInstance.getSet(name))
        sets[name] = newSet
        return Single.just(newSet)
    }

    override fun shutdown(): Completable {
        return Completable.create {
            sets.forEach {
                it.value.cleanup()
            }
            it.onComplete()
        }
    }
}
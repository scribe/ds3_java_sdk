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

import com.hazelcast.core.*
import com.hazelcast.map.listener.EntryAddedListener
import com.hazelcast.map.listener.EntryEvictedListener
import com.hazelcast.map.listener.EntryRemovedListener
import com.hazelcast.map.listener.EntryUpdatedListener
import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.util.ifNotNull
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import org.slf4j.LoggerFactory

internal class InstrumentedClusterService(private val clusterService: ClusterService, private val requestContext: RequestContext): ClusterService by clusterService {
    override fun clusterNodes(): Observable<ClusterNode> {
        requestContext.tracer.buildSpan("getClusterNodes").asChildOf(requestContext.currentSpan).startActive().use {
            val continuation = it.capture()
            return clusterService.clusterNodes().doOnComplete {
                continuation.activate().close()
            }
        }
    }
}

internal class HazelcastClusterService(private val hazelcastInstance: HazelcastInstance, private val instanceName : String) : ClusterService {

    private companion object {
        private val LOG = LoggerFactory.getLogger(HazelcastClusterService::class.java)
    }

    private val mapStore = MapStore(hazelcastInstance)
    private val setStore = SetStore(hazelcastInstance)

    override fun instanceName(): Single<String> {
        return Single.just(instanceName)
    }

    override fun name(): Single<String> {
        return Single.just(hazelcastInstance.config.groupConfig.name)
    }

    override fun <K, V> getDistributedMap(name: String): Single<DistributedMap<K, V>> {
        return mapStore.store(name) as Single<DistributedMap<K, V>>
    }

    override fun <V> getDistributedSet(name: String): Single<DistributedSet<V>> {
        return setStore.store(name) as Single<DistributedSet<V>>
    }

    override fun clusterNodes(): Observable<ClusterNode> {
        return Observable.fromIterable(hazelcastInstance.cluster.members.map { ClusterNode(it.address.host, it.address.port) })
    }

    internal fun getClusterNode(): ClusterNode {
        val address = hazelcastInstance.cluster.localMember.address
        return ClusterNode(address.host, address.port)
    }

    internal fun shutdown(): Completable {
        return mapStore.shutdown().andThen(setStore.shutdown()).andThen {
            LOG.info("Shutting down hazelcast")
            hazelcastInstance.shutdown()
            it.onComplete()
        }
    }
}

/**
 * The current implementation for this creates new event listeners each time the collection is retrieved.  This
 * will leak resources if we do not update this to cache the results and handle the event handlers separately.
 */
internal class HazelcastDistributedMap<K, V>(private val hazelcastMap : IMap<K, V>) : MutableMap<K, V> by hazelcastMap, DistributedMap<K, V> {

    private val entryAddedSubject = PublishSubject.create<Pair<K,V>>()
    private val entryRemovedSubject = PublishSubject.create<Pair<K,V>>()
    private val entryModifiedSubject = PublishSubject.create<Pair<K,V>>()

    private val entryListenerIdentifier : String

    init {
        val entryListener = object : EntryAddedListener<K, V>, EntryRemovedListener<K, V>, EntryUpdatedListener<K, V>, EntryEvictedListener<K, V> {
            override fun entryAdded(event: EntryEvent<K, V>?) {
                event.ifNotNull {
                    entryAddedSubject.onNext(Pair(it.key, it.value))
                }
            }

            override fun entryRemoved(event: EntryEvent<K, V>?) {
                event.ifNotNull {
                    entryRemovedSubject.onNext(Pair(it.key, it.oldValue))
                }
            }

            override fun entryUpdated(event: EntryEvent<K, V>?) {
                event.ifNotNull {
                    entryModifiedSubject.onNext(Pair(it.key, it.value))
                }
            }

            override fun entryEvicted(event: EntryEvent<K, V>?) {
                event.ifNotNull {
                    entryRemovedSubject.onNext(Pair(it.key, it.value))
                }
            }
        }

        entryListenerIdentifier = hazelcastMap.addEntryListener(entryListener, true)  // TODO this returns a string that we need to remove the listener
    }

    override fun entryAdded(onNext: (Pair<K, V>) -> Unit): Disposable {
        return entryAddedSubject.subscribe(onNext)
    }

    override fun entryRemoved(onNext: (Pair<K, V>) -> Unit): Disposable {
        return entryRemovedSubject.subscribe(onNext)
    }

    override fun entryModified(onNext: (Pair<K, V>) -> Unit): Disposable {
        return entryModifiedSubject.subscribe(onNext)
    }

    internal fun cleanup() {
        hazelcastMap.removeEntryListener(entryListenerIdentifier)
        entryAddedSubject.onComplete()
        entryRemovedSubject.onComplete()
        entryModifiedSubject.onComplete()
    }
}

internal class HazelcastDistributedSet<V>(private val hazelcastSet : ISet<V>) : MutableSet<V> by hazelcastSet, DistributedSet<V> {

    private val entryAddedSubject = PublishSubject.create<V>()
    private val entryRemovedSubject = PublishSubject.create<V>()

    private val itemListenerIdentifier : String

    init {
        itemListenerIdentifier = hazelcastSet.addItemListener(object : ItemListener<V> {
            override fun itemAdded(item: ItemEvent<V>?) {
                item.ifNotNull {
                    entryAddedSubject.onNext(it.item)
                }
            }

            override fun itemRemoved(item: ItemEvent<V>?) {
                item.ifNotNull {
                    entryRemovedSubject.onNext(it.item)
                }
            }
        }, true)
    }


    override fun entryAdded(onNext: (V) -> Unit): Disposable {
        return entryAddedSubject.subscribe(onNext)
    }

    override fun entryRemoved(onNext: (V) -> Unit): Disposable {
        return entryRemovedSubject.subscribe(onNext)
    }

    internal fun cleanup() {
        hazelcastSet.removeItemListener(itemListenerIdentifier)
        entryAddedSubject.onComplete()
        entryRemovedSubject.onComplete()
    }
}
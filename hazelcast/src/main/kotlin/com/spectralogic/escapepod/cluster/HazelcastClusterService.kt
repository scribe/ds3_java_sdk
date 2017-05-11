package com.spectralogic.escapepod.cluster

import com.hazelcast.core.*
import com.hazelcast.map.listener.EntryAddedListener
import com.hazelcast.map.listener.EntryEvictedListener
import com.hazelcast.map.listener.EntryRemovedListener
import com.hazelcast.map.listener.EntryUpdatedListener
import com.spectralogic.escapepod.api.ClusterNode
import com.spectralogic.escapepod.api.ClusterService
import com.spectralogic.escapepod.api.DistributedMap
import com.spectralogic.escapepod.api.DistributedSet
import com.spectralogic.escapepod.util.ifNotNull
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject

internal class HazelcastClusterService(internal val hazelcastInstance: HazelcastInstance, internal val instanceName : String) : ClusterService {
    override fun instanceName(): Single<String> {
        return Single.just(instanceName)
    }

    internal fun getInstance() : HazelcastInstance {
        return hazelcastInstance
    }

    override fun name(): Single<String> {
        return Single.just(hazelcastInstance.config.groupConfig.name)
    }

    override fun <K, V> getDistributedMap(name: String): DistributedMap<K, V> {
        return HazelcastDistributedMap(hazelcastInstance.getMap(name))
    }

    override fun <V> getDistributedSet(name: String): DistributedSet<V> {
        return HazelcastDistributedSet(hazelcastInstance.getSet(name))
    }

    override fun clusterNodes(): Observable<ClusterNode> {

        return Observable.create { emitter ->
            hazelcastInstance
                .cluster
                .members
                .asSequence()
                .map { ClusterNode(it.address.host, it.address.port) }
                .forEach(emitter::onNext)

            emitter.onComplete()
        }
    }
}

internal class HazelcastDistributedMap<K, V>(hazelcastMap : IMap<K, V>) : MutableMap<K, V> by hazelcastMap, DistributedMap<K, V> {

    private val entryAddedSubject = PublishSubject.create<Pair<K,V>>()
    private val entryRemovedSubject = PublishSubject.create<Pair<K,V>>()
    private val entryModifiedSubject = PublishSubject.create<Pair<K,V>>()

    init {
        val entryListener = object : EntryAddedListener<K, V>, EntryRemovedListener<K, V>, EntryUpdatedListener<K, V>, EntryEvictedListener<K, V> {
            override fun entryAdded(event: EntryEvent<K, V>?) {
                event.ifNotNull {
                    entryAddedSubject.onNext(Pair(it.key, it.value))
                }
            }

            override fun entryRemoved(event: EntryEvent<K, V>?) {
                event.ifNotNull {
                    entryRemovedSubject.onNext(Pair(it.key, it.value))
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

        hazelcastMap.addEntryListener(entryListener, true)
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
}

internal class HazelcastDistributedSet<V>(hazelcastSet : ISet<V>) : MutableSet<V> by hazelcastSet, DistributedSet<V> {

    private val entryAddedSubject = PublishSubject.create<V>()
    private val entryRemovedSubject = PublishSubject.create<V>()

    init {
        hazelcastSet.addItemListener(object : ItemListener<V> {
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
}
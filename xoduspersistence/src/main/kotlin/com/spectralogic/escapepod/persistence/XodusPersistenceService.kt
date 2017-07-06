package com.spectralogic.escapepod.persistence

import com.spectralogic.escapepod.api.PersistenceService
import jetbrains.exodus.entitystore.Entity
import jetbrains.exodus.entitystore.EntityIterable
import jetbrains.exodus.entitystore.PersistentEntityStore
import jetbrains.exodus.entitystore.StoreTransaction

class XodusPersistenceService(val entityStore: PersistentEntityStore) : PersistenceService {

    //These are just examples of things a persistence service could provide, we need to finalize what it should do.
    enum class NodeTypes {
        CLUSTER,
        BLACK_PEARL
    }

    enum class LinkType {
        HAS
    }

    fun get(node:NodeTypes): EntityIterable = get(node.toString())

    fun get(node:String): EntityIterable {
        val tx:StoreTransaction = entityStore.beginReadonlyTransaction()
        val entities:EntityIterable = tx.getAll(node)
        tx.commit()
        return entities
    }

    fun get(nodeType:NodeTypes, property:String, value:Comparable<Any?>): EntityIterable {
        val tx:StoreTransaction = entityStore.beginReadonlyTransaction()
        val entities:EntityIterable = tx.find(nodeType.name, property, value)
        tx.commit()
        return entities
    }

    fun addNode(node:NodeTypes, properties:Map<String,Comparable<Any?>> = mapOf()): Entity {
        val tx:StoreTransaction = entityStore.beginTransaction()
        val e:Entity = tx.newEntity(node.toString())
        for((k,v) in properties) {
            e.setProperty(k, v)
        }
        tx.commit()
        return e
    }

    fun link(source:Entity, link:LinkType, destination:Entity): Unit {
        entityStore.executeInTransaction {
            source.addLink(link.name, destination)
        }
    }
}
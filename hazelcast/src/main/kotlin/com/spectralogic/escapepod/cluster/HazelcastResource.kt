package com.spectralogic.escapepod.cluster

import com.hazelcast.core.HazelcastInstance
import java.util.*

class HazelcastResource {

    private var hazelcast : Optional<HazelcastInstance> = Optional.empty()

    fun getInstance() : Optional<HazelcastInstance> {
        return hazelcast
    }

    fun setInstance(hazelcastInstance : HazelcastInstance?) {
        this.hazelcast = Optional.ofNullable(hazelcastInstance)
    }
}

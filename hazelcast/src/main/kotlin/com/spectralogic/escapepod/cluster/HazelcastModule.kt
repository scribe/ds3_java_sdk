package com.spectralogic.escapepod.cluster

import com.google.inject.AbstractModule
import com.google.inject.Provides
import com.spectralogic.escapepod.api.CacheService
import com.spectralogic.escapepod.api.ClusterServiceProvider
import javax.inject.Named
import javax.inject.Singleton

class HazelcastModule : AbstractModule() {
    override fun configure() {
        bind(CacheService::class.java).to(CacheServiceImpl::class.java).`in`(Singleton::class.java)
        bind(ClusterServiceProvider::class.java).to(ClusterServiceProviderImpl::class.java).`in`(Singleton::class.java)
        bind(HazelcastResource::class.java).`in`(Singleton::class.java)
    }

    @Provides
    @Named("hazelcastInterface")
    fun hazelcastInterface() : String {
        return System.getenv()["hazelcast_interface"]?: "127.0.0.1"
    }
}

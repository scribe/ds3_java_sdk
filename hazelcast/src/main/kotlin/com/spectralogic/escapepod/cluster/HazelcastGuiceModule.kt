package com.spectralogic.escapepod.cluster

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.CacheService
import com.spectralogic.escapepod.api.ClusterServiceProvider
import javax.inject.Singleton

internal class HazelcastGuiceModule : AbstractModule() {
    override fun configure() {
        bind(CacheService::class.java).to(CacheServiceImpl::class.java).`in`(Singleton::class.java)
        bind(ClusterServiceProvider::class.java).to(ClusterServiceProviderImpl::class.java).`in`(Singleton::class.java)
        bind(ClusterClientFactory::class.java).to(ClusterClientFactoryImpl::class.java)
        bind(ClusterModuleLoader::class.java)
    }
}

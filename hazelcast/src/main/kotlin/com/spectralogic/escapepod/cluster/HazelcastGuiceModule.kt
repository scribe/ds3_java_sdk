package com.spectralogic.escapepod.cluster

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.ClusterServiceProvider
import com.spectralogic.escapepod.cluster.config.ClusterConfigResource
import com.spectralogic.escapepod.cluster.config.ClusterConfigService
import com.spectralogic.escapepod.cluster.config.ClusterConfigServiceImpl
import javax.inject.Singleton

internal class HazelcastGuiceModule : AbstractModule() {
    override fun configure() {
        bind(ClusterServiceProvider::class.java).to(ClusterServiceProviderImpl::class.java).`in`(Singleton::class.java)
        bind(ClusterClientFactory::class.java).to(ClusterClientFactoryImpl::class.java)
        bind(ClusterModuleLoader::class.java)
        bind(ClusterConfigService::class.java).to(ClusterConfigServiceImpl::class.java).`in`(Singleton::class.java)
        bind(ClusterConfigResource::class.java).`in`(Singleton::class.java)
    }
}

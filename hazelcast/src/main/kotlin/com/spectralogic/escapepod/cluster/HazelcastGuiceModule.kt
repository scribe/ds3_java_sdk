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

import com.google.inject.AbstractModule
import com.google.inject.TypeLiteral
import com.spectralogic.escapepod.api.ClusterServiceProvider
import com.spectralogic.escapepod.cluster.config.ClusterConfig
import com.spectralogic.escapepod.cluster.config.ClusterConfigResource
import com.spectralogic.escapepod.cluster.config.ClusterConfigService
import com.spectralogic.escapepod.cluster.config.ClusterConfigServiceImpl
import com.spectralogic.escapepod.util.resource.Resource
import javax.inject.Singleton

internal class HazelcastGuiceModule : AbstractModule() {
    override fun configure() {
        bind(ClusterServiceProvider::class.java).to(ClusterServiceProviderImpl::class.java).`in`(Singleton::class.java)
        bind(ClusterClientFactory::class.java).to(ClusterClientFactoryImpl::class.java)
        bind(ClusterModule::class.java)
        bind(ClusterConfigService::class.java).to(ClusterConfigServiceImpl::class.java).`in`(Singleton::class.java)
        bind(object : TypeLiteral<Resource<ClusterConfig>>(){} ).to(ClusterConfigResource::class.java).`in`(Singleton::class.java)
        bind(ClusterHandlerChain::class.java).`in`(Singleton::class.java)
    }
}

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
import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.httpservice.HttpDeregistrationAggregator
import com.spectralogic.escapepod.httpservice.HttpRouter
import io.reactivex.Completable
import org.slf4j.LoggerFactory
import javax.inject.Inject

class ClusterModuleRegistration : ModuleRegistration<ClusterModule> {
    override fun module(): Class<ClusterModule> = ClusterModule::class.java

    override fun guiceModule(): AbstractModule = HazelcastGuiceModule()
}

class ClusterModule @Inject constructor(private val clusterServiceProvider: ClusterServiceProvider, private val httpRouter: HttpRouter, private val clusterHandler: ClusterHandlerChain) : Module {

    private companion object {
        private val LOG = LoggerFactory.getLogger(ClusterModule::class.java)
    }

    private val deregistrationAggregator = HttpDeregistrationAggregator()

    override val name: String = "Cluster"

    override fun loadModule(): Completable {

        return Completable.create { emitter ->
            clusterServiceProvider.clusterLifecycleEvents().subscribe { event ->
                when (event) {
                    is ClusterNodeJoinedEvent -> {
                        LOG.info("New node joined cluster: {}:{}", event.clusterNode.ip, event.clusterNode.port)
                    }
                    is ClusterNodeLeftEvent -> {
                        LOG.info("Node left the cluster: {}:{}", event.clusterNode.ip, event.clusterNode.port)
                    }
                }
            }

            emitter.onComplete()
        }
    }

    override fun startModule(): Completable {
        LOG.info("Starting the cluster module")

        return Completable.create { emitter ->
            deregistrationAggregator.addDeregistration(httpRouter.register("cluster", clusterHandler))
            httpRouter.registerExceptionHandler(ClusterException::class.java) { ctx, t ->
                ctx.response.status(400).send()
            }
            emitter.onComplete()
        }.mergeWith(clusterServiceProvider.startService())
    }

    override fun shutdownModule(): Completable {
        deregistrationAggregator.deregister()
        return clusterServiceProvider.shutdown()
    }
}

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

import com.spectralogic.escapepod.api.ClusterService
import com.spectralogic.escapepod.api.ClusterServiceProvider
import com.spectralogic.escapepod.api.RequestContext
import com.spectralogic.escapepod.httpservice.ExceptionHandlerMapper
import com.spectralogic.escapepod.httpservice.toPromise

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import org.slf4j.LoggerFactory
import ratpack.func.Action
import ratpack.handling.Chain
import ratpack.handling.Context
import java.util.concurrent.ExecutorService
import javax.inject.Inject

class ClusterHandlerChain @Inject constructor(workers : ExecutorService, private val clusterServiceProvider: ClusterServiceProvider): Action<Chain> {

    private companion object {
        private val LOG = LoggerFactory.getLogger(ClusterHandlerChain::class.java)
    }

    private val scheduler : Scheduler = Schedulers.from(workers)

    override fun execute(chain: Chain) {

        chain.get("members") { ctx ->

            val exceptionMapper = ctx.get(ExceptionHandlerMapper::class.java)

            clusterServiceProvider.getService(ctx.get(RequestContext::class.java))
                    .observeOn(scheduler)
                    .flatMapObservable(ClusterService::clusterNodes)
                    .toPromise()
                    .onError {
                        LOG.error("Failed to get cluster members", it)
                        exceptionMapper.handle(ctx, it)
                    }
                    .then { clusterList ->
                        ctx.render(clusterList.joinToString(", ") { it.ip + ":" + it.port })
                    }
        }

        chain.all { ctx -> ctx.byMethod {

            val requestContext = ctx.get(RequestContext::class.java)

            it.get { ctx ->

                val exceptionMapper = ctx.get(ExceptionHandlerMapper::class.java)

                clusterServiceProvider.getService(requestContext)
                        .observeOn(scheduler)
                        .flatMap(ClusterService::name)
                        .toPromise()
                        .onError { t ->
                            LOG.error("Failed to get cluster name", t)
                            exceptionMapper.handle(ctx, t)
                        }
                        .then { name ->
                            ctx.render(name)
                        }
            }

            it.post { ctx ->
                when {
                    "name" in ctx.request.queryParams -> createCluster(ctx)
                    "ip" in ctx.request.queryParams -> joinCluster(ctx)
                    else -> ctx.response.status(400).send("The request must have either name or ip set")
                }
            }

            it.delete { ctx ->
                clusterServiceProvider.leaveCluster()
                        .observeOn(scheduler)
                        .toPromise()
                        .onError {
                            LOG.error("Could not remove the system from the cluster", it)
                            ctx.response.status(400).send("Failed to remove system from cluster")
                        }
                        .then {
                            ctx.response.status(204).send("Successfully removed from cluster")
                        }
            }}
        }
    }

    private fun joinCluster(ctx: Context) {
        val ip = ctx.request.queryParams["ip"]
        if (ip.isNullOrEmpty()) {
            ctx.response.status(400).send("'ip' cannot be empty")
        } else {
            clusterServiceProvider.joinCluster(ip!!)
                    .observeOn(scheduler)
                    .toPromise()
                    .onError { t ->
                        LOG.error("Failed to join cluster", t)
                        ctx.response.status(400).send("Failed to join cluster because: " + t.message)
                    }
                    .then {
                        ctx.response.status(202).send("Successfully joined a cluster")
                    }
        }
    }

    private fun createCluster(ctx: Context) {
        val clusterName = ctx.request.queryParams["name"]
        if (clusterName.isNullOrEmpty()) {
            ctx.response.status(400).send("'name' cannot be empty")
        } else {
            clusterServiceProvider.createCluster(clusterName!!)
                    .observeOn(scheduler)
                    .toPromise()
                    .onError { t ->
                        LOG.error("failed to create cluster", t)
                        ctx.response.status(400).send("Failed to create cluster with name: " + clusterName)
                    }
                    .then {
                        ctx.response.status(202).send("Successfully created a new cluster")
                    }
        }
    }
}

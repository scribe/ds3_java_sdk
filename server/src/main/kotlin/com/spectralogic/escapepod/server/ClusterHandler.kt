package com.spectralogic.escapepod.server

import com.spectralogic.escapepod.api.ClusterService
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import org.slf4j.LoggerFactory
import ratpack.func.Action
import ratpack.handling.Chain
import ratpack.handling.Context
import java.util.concurrent.ExecutorService
import javax.inject.Inject

class ClusterHandlerChain @Inject constructor(workers : ExecutorService, private val clusterService: ClusterService): Action<Chain> {

    private companion object {
        private val LOG = LoggerFactory.getLogger(ClusterHandlerChain::class.java)
    }

    private val scheduler : Scheduler = Schedulers.from(workers)

    override fun execute(chain: Chain) {
        chain.post { ctx ->
            try {
                if ("name" in ctx.request.queryParams) {
                    createCluster(ctx)
                } else if ("ip" in ctx.request.queryParams) {
                    joinCluster(ctx)
                } else {
                    ctx.response.status(400).send("The request must have either name or ip set")
                }
            } catch (e : RuntimeException) {
                ctx.response.status(400).send("Encountered an error with the cluster: " + e.message)
            }
        }

        chain.delete { ctx ->
            clusterService.leaveCluster().doOnSuccess {
                ctx.response.status(204).send("Successfully removed from cluster")
            }
            .doOnError {
                ctx.response.status(400).send("Failed to remove system from cluster")
            }
            .observeOn(scheduler).subscribe()
        }

        chain.get("members") { ctx ->
            try {
                clusterService.clusterNodes().toList().doOnSuccess { clusterList ->
                    ctx.render(clusterList.joinToString(", ") { it.ip + ":" + it.port })
                }.observeOn(scheduler).subscribe()
            } catch( e : RuntimeException) {
                ctx.response.status(400).send("Encountered an error with the cluster: " + e.message)
            }
        }


    }

    private fun joinCluster(ctx: Context) {
        val ip = ctx.request.queryParams["ip"]
        if (ip.isNullOrEmpty()) {
            ctx.response.status(400).send("'ip' cannot be empty")
        } else {
            clusterService.joinCluster(ip!!).doOnSuccess {
                ctx.response.status(202).send("Successfully joined a cluster")
            }.doOnError { t ->
                LOG.error("Failed to join cluster", t)
                ctx.response.status(400).send("Failed to join cluster because: " + t.message)
            }.observeOn(scheduler).subscribe()
        }
    }

    private fun createCluster(ctx: Context) {
        val clusterName = ctx.request.queryParams["name"]
        if (clusterName.isNullOrEmpty()) {
            ctx.response.status(400).send("'name' cannot be empty")
        } else {
            clusterService.createCluster(clusterName!!)
                    .doOnSuccess {
                        ctx.response.status(202).send("Successfully created a new cluster")
                    }
                    .doOnError { t ->
                        // do error stuff
                        ctx.response.status(400).send("Failed to create cluster with name: " + clusterName)
                    }
                    .observeOn(scheduler)
                    .subscribe()
        }
    }
}

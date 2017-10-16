package com.spectralogic.escapepod.pammigrate

import com.spectralogic.escapepod.httpservice.handleError
import com.spectralogic.escapepod.httpservice.toPromise
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import org.slf4j.LoggerFactory
import ratpack.func.Action
import ratpack.handling.Chain
import ratpack.handling.Context
import ratpack.jackson.Jackson.json
import java.util.concurrent.ExecutorService
import javax.inject.Inject

internal class PamMigrateHandlerChain
@Inject constructor(workers: ExecutorService, private val pamMigrateProvider: PamMigrateProvider) : Action<Chain> {

    private companion object {
        private val LOG = LoggerFactory.getLogger(PamMigrateHandlerChain::class.java)
    }

    private val scheduler: Scheduler = Schedulers.from(workers)

    override fun execute(chain: Chain) {
        chain.get("folders") { ctx ->
            getFolders(ctx)
        }

        chain.get("profiles") { ctx ->
            getProfiles(ctx)
        }

        chain.get("files") { ctx ->
            getFiles(ctx)
        }

        chain.get("jobstatus") { ctx ->
            getJobStatus(ctx)
        }

        chain.get("maxarchiveassetsize") { ctx ->
            getMaxArchiveAssetSize(ctx)
        }

        chain.get("workgroups") { ctx ->
            getWorkGroups(ctx)
        }


        chain.post("archive") { ctx ->
            archiveFile(ctx)
        }

        chain.post("restore") { ctx ->
            restoreFile(ctx)
        }
    }

    private fun getWorkGroups(ctx: Context) {
        pamMigrateProvider.getWorkGroups().observeOn(scheduler)
                .toPromise()
                .onError { t ->
                    val message = "Encountered an error with getting all the work groups: "
                    LOG.error(message, t)
                    ctx.handleError(t)
                }
                .then { res ->
                    ctx.render(json(res))
                }
    }

    private fun getMaxArchiveAssetSize(ctx: Context) {
        val workGroup = ctx.request.queryParams["workgroup"]

        if (workGroup.isNullOrEmpty()) {
            ctx.response.status(400).send("'workgroup' must be set")
        } else {
            pamMigrateProvider.getMaxArchiveAssetSize(workGroup!!).observeOn(scheduler)
                    .toPromise()
                    .onError { t ->
                        val message = "Encountered an error with getting the max archive asset size: "
                        LOG.error(message, t)
                        ctx.handleError(t)
                    }
                    .then { res ->
                        ctx.render(json(res))
                    }
        }
    }

    private fun getFolders(ctx: Context) {
        val workGroup = ctx.request.queryParams["workgroup"]

        if (workGroup.isNullOrEmpty()) {
            ctx.response.status(400).send("'workgroup' must be set")
        } else {
            pamMigrateProvider.getFolders(workGroup!!).observeOn(scheduler)
                    .toPromise()
                    .onError { t ->
                        val message = "Encountered an error with getting folders: "
                        LOG.error(message, t)
                        ctx.handleError(t)
                    }
                    .then { res ->
                        ctx.render(json(res))
                    }
        }
    }

    private fun getFiles(ctx: Context) {
        val workGroup = ctx.request.queryParams["workgroup"]
        val folder = ctx.request.queryParams["folder"]

        if (workGroup.isNullOrEmpty() || folder.isNullOrEmpty()) {
            ctx.response.status(400).send("'workgroup' and 'folder' must be set")
        } else {
            pamMigrateProvider.getFiles(workGroup!!, folder!!).observeOn(scheduler)
                    .toPromise()
                    .onError { t ->
                        val message = "Encountered an error with getting files: "
                        LOG.error(message, t)
                        ctx.handleError(t)
                    }
                    .then { res ->
                        ctx.render(json(res))
                    }
        }
    }

    private fun getProfiles(ctx: Context) {
        val workGroup = ctx.request.queryParams["workgroup"]

        if (workGroup.isNullOrEmpty()) {
            ctx.response.status(400).send("'workgroup' must be set")
        } else {
            pamMigrateProvider.getProfiles(workGroup!!).observeOn(scheduler)
                    .toPromise()
                    .onError { t ->
                        val message = "Encountered an error with getting the profiles: "
                        LOG.error(message, t)
                        ctx.handleError(t)
                    }
                    .then { res ->
                        ctx.render(json(res))
                    }
        }
    }

    private fun getJobStatus(ctx: Context) {
        val workGroup = ctx.request.queryParams["workgroup"]
        val jobId = ctx.request.queryParams["jobid"]

        if (workGroup.isNullOrEmpty() || jobId.isNullOrEmpty()) {
            ctx.response.status(400).send("'workgroup' and 'jobid' must be set")
        } else {
            pamMigrateProvider.getJobStatus(workGroup!!, jobId!!).observeOn(scheduler)
                    .toPromise()
                    .onError { t ->
                        val message = "Encountered an error when getting job status: "
                        LOG.error(message, t)
                        ctx.handleError(t)
                    }
                    .then { res ->
                        ctx.render(json(res))
                    }
        }
    }

    private fun restoreFile(ctx: Context) {
        val workGroup = ctx.request.queryParams["workgroup"]
        val profile = ctx.request.queryParams["profile"]
        val mobid = ctx.request.queryParams["mobid"]

        if (workGroup.isNullOrEmpty() || profile.isNullOrEmpty() || mobid.isNullOrEmpty()) {
            ctx.response.status(400).send("'workgroup', 'profile' and 'mobid' must be set")
        } else {
            pamMigrateProvider.restoreFile(workGroup!!, profile!!, mobid!!).observeOn(scheduler)
                    .toPromise()
                    .onError { t ->
                        val message = "Encountered an error when restoring an asset: "
                        LOG.error(message, t)
                        ctx.handleError(t)
                    }
                    .then { res ->
                        ctx.render(json(res))
                    }
        }
    }

    private fun archiveFile(ctx: Context) {
        val workGroup = ctx.request.queryParams["workgroup"]
        val profile = ctx.request.queryParams["profile"]
        val mobid = ctx.request.queryParams["mobid"]

        if (workGroup.isNullOrEmpty() || profile.isNullOrEmpty() || mobid.isNullOrEmpty()) {
            ctx.response.status(400).send("'workgroup', 'profile' and 'mobid' must be set")
        } else {
            pamMigrateProvider.archiveFile(workGroup!!, profile!!, mobid!!).observeOn(scheduler)
                    .toPromise()
                    .onError { t ->
                        val message = "Encountered an error when archiving an asset: "
                        LOG.error(message, t)
                        ctx.handleError(t)
                    }
                    .then { res ->
                        ctx.render(json(res))
                    }
        }
    }
}

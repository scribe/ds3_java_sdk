package com.spectralogic.escapepod.pammigrate

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

class PamMigrateHandlerChain
@Inject constructor(workers: ExecutorService, private val pamMigrateProvider: PamMigrateProvider) : Action<Chain> {

    companion object {
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

        chain.get("maxarchiveassetsize") { ctx ->
            getMaxArchiveAssetSize(ctx)
        }



        chain.post("archive") { ctx ->
            archive(ctx)
        }

        chain.post("restore") { ctx ->
            restore(ctx)
        }
    }

    private fun getMaxArchiveAssetSize(ctx: Context) {
        //TODO
        pamMigrateProvider.getMaxArchiveAssetSize("").observeOn(scheduler)
                .toPromise()
                .onError {
                    ctx.response.status(400).send("Encountered an error with getting the max archive asset size: " + it.message)
                }
                .then { res ->
                    ctx.render(json(res))
                }
    }

    private fun getFolders(ctx: Context) {
        val workGroup = ctx.request.queryParams["workgroup"]

        if (workGroup.isNullOrEmpty()) {
            ctx.response.status(400).send("'workgroup' cannot be empty")
        } else {
            pamMigrateProvider.getFolders(workGroup!!).observeOn(scheduler)
                    .toPromise()
                    .onError {
                        ctx.response.status(400).send("Encountered an error with getting folders: " + it.message)
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
            ctx.response.status(400).send("'workgroup' and 'folder' cannot be empty")
        } else {
            pamMigrateProvider.getFiles(workGroup!!, folder!!).observeOn(scheduler)
                    .toPromise()
                    .onError {
                        ctx.response.status(400).send("Encountered an error with getting files: " + it.message)
                    }
                    .then { res ->
                        ctx.render(json(res))
                    }
        }
    }

    private fun getProfiles(ctx: Context) {
        val workGroup = ctx.request.queryParams["workgroup"]

        if (workGroup.isNullOrEmpty()) {
            ctx.response.status(400).send("'workgroup' cannot be empty")
        } else {
            pamMigrateProvider.getProfiles(workGroup!!).observeOn(scheduler)
                    .toPromise()
                    .onError {
                        ctx.response.status(400).send("Encountered an error with getting the profiles: " + it.message)
                    }
                    .then { res ->
                        ctx.render(json(res))
                    }
        }
    }

    private fun restore(ctx: Context) {
        val workGroup = ctx.request.queryParams["workgroup"]
        val profile = ctx.request.queryParams["profile"]
        val mobid = ctx.request.queryParams["mobid"]

        if (workGroup.isNullOrEmpty() || profile.isNullOrEmpty() || mobid.isNullOrEmpty()) {
            ctx.response.status(400).send("'workgroup', 'profile' and 'mobid' cannot be empty")
        } else {
            pamMigrateProvider.restore(workGroup!!, profile!!, mobid!!).observeOn(scheduler)
                    .toPromise()
                    .onError {
                        ctx.response.status(400).send("Encountered an error when restoring an asset: " + it.message)
                    }
                    .then { res ->
                        ctx.render(json(res))
                    }
        }
    }

    private fun archive(ctx: Context) {
        val workGroup = ctx.request.queryParams["workgroup"]
        val profile = ctx.request.queryParams["profile"]
        val mobid = ctx.request.queryParams["mobid"]

        if (workGroup.isNullOrEmpty() || profile.isNullOrEmpty() || mobid.isNullOrEmpty()) {
            ctx.response.status(400).send("'workgroup', 'profile' and 'mobid' cannot be empty")
        } else {
            pamMigrateProvider.archive(workGroup!!, profile!!, mobid!!).observeOn(scheduler)
                    .toPromise()
                    .onError {
                        ctx.response.status(400).send("Encountered an error when archiving an asset: " + it.message)
                    }
                    .then { res ->
                        ctx.render(json(res))
                    }
        }
    }
}

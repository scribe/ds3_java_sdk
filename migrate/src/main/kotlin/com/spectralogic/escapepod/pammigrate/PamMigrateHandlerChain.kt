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
        chain.post("archivetoblackpearl") { ctx ->
            archiveFileToBlackPearl(ctx)
        }
    }

    private fun archiveFileToBlackPearl(ctx: Context) {
        val workGroup = ctx.request.queryParams["workgroup"]
        val mobid = ctx.request.queryParams["mobid"]
        val blackPearl = ctx.request.queryParams["blackpearl"]
        val bucket = ctx.request.queryParams["bucket"]


        if (workGroup.isNullOrEmpty() || blackPearl.isNullOrEmpty() || mobid.isNullOrEmpty()) {
            ctx.response.status(400).send("'workgroup', 'mobid', 'blackpearl' and 'bucket must be set")
        } else {
            pamMigrateProvider.archivePamAssetToBlackPearl(workGroup!!, mobid!!, blackPearl!!, bucket!!).observeOn(scheduler)
                    .toPromise()
                    .onError { t ->
                        val message = "Encountered an error when archiving an asset to Black Pearl: "
                        LOG.error(message, t)
                        ctx.handleError(t)
                    }
                    .then { _ ->
                        ctx.render(json("Archive finished successfully."))
                    }
        }
    }
}

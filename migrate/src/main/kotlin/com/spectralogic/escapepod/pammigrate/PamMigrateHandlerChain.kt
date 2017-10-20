package com.spectralogic.escapepod.pammigrate

import com.spectralogic.escapepod.httpservice.handleError
import com.spectralogic.escapepod.httpservice.toPromise
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import org.slf4j.LoggerFactory
import ratpack.func.Action
import ratpack.handling.Chain
import ratpack.jackson.Jackson.json
import java.util.concurrent.ExecutorService
import javax.inject.Inject

internal class PamMigrateHandlerChain
@Inject constructor(workers: ExecutorService, private val pamMigrateHandlers: PamMigrateHandlers) : Action<Chain> {

    private companion object {
        private val LOG = LoggerFactory.getLogger(PamMigrateHandlerChain::class.java)
    }

    private val scheduler: Scheduler = Schedulers.from(workers)

    override fun execute(chain: Chain) {
        chain.post(":name/archivetoblackpearl") { ctx ->
            val name = ctx.pathTokens["name"]
            val mobid = ctx.request.queryParams["mobid"]
            val blackPearl = ctx.request.queryParams["blackpearl"]
            val bucket = ctx.request.queryParams["bucket"]

            if (blackPearl.isNullOrEmpty() || mobid.isNullOrEmpty()) {
                ctx.response.status(400).send("'mobid', 'blackpearl' and 'bucket must be set")
            } else {
                pamMigrateHandlers.archivePamAssetToBlackPearl(name!!, mobid!!, blackPearl!!, bucket!!).observeOn(scheduler)
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
}

package com.spectra.escapepod.http

import ratpack.func.Action
import ratpack.handling.Chain
import javax.inject.Inject

internal class RootHandler @Inject constructor(private val moduleHandler: ModuleHandler, private val clusterHandlerChain: ClusterHandlerChain) : Action<Chain> {

    override fun execute(chain: Chain) {
        chain.get("modules", moduleHandler)
        chain.prefix("cluster", clusterHandlerChain)
        chain.get { ctx ->
            ctx.response.status(404).send("Handler not found")
        }
    }
}

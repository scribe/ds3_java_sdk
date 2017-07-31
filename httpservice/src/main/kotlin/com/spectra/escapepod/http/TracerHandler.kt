package com.spectra.escapepod.http

import com.spectralogic.escapepod.api.monitoring.HTTP_METHOD_TAG
import com.spectralogic.escapepod.api.monitoring.HTTP_URI
import io.opentracing.Tracer
import org.slf4j.LoggerFactory
import ratpack.handling.Context
import ratpack.handling.Handler

internal class TracerHandler constructor(private val tracer: Tracer): Handler {

    private companion object {
        private val LOG = LoggerFactory.getLogger(TracerHandler::class.java)
    }

    override fun handle(ctx: Context) {
        LOG.info("creating tracer span")
        tracer.buildSpan("request").startActive().use { span ->
            span.log("Started Handling Request")
            span.setTag(HTTP_METHOD_TAG, ctx.request.method.name)
            span.setTag(HTTP_URI, ctx.request.uri)
            val spanContinuation = span.capture()
            ctx.onClose {
                LOG.info("deactivating tracer span")
                spanContinuation.activate().use {
                    it.log("Finished Handling Request")
                }
            }
        }

        ctx.next()
    }
}
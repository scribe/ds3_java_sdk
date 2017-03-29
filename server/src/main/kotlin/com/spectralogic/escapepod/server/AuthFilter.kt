package com.spectralogic.escapepod.server

import org.slf4j.LoggerFactory
import ratpack.handling.Context
import ratpack.handling.Handler

class AuthFilter(private val handler: Handler) : Handler {

    private companion object {
        private val LOG = LoggerFactory.getLogger(AuthFilter::class.java)
    }

    override fun handle(ctx: Context?) {
        LOG.info("Passing through auth handler")
        handler.handle(ctx)
    }
}

fun Handler.auth() : AuthFilter {
    return AuthFilter(this)
}

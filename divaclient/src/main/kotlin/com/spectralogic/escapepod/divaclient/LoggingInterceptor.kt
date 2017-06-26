package com.spectralogic.escapepod.divaclient

import okhttp3.Interceptor
import okhttp3.Response
import org.slf4j.LoggerFactory

import java.io.IOException

internal class LoggingInterceptor : Interceptor {
    companion object {
        private val LOG = LoggerFactory.getLogger(LoggingInterceptor::class.java)
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val t1 = System.nanoTime()
        LOG.info(String.format("Sending request %s on %s%n%s",
                request.url(), chain.connection(), request.headers()))

        val response = chain.proceed(request)

        val t2 = System.nanoTime()
        LOG.info(String.format("Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6, response.headers()))

        return response
    }

}
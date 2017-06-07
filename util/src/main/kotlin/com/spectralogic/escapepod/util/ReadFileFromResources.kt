package com.spectralogic.escapepod.util

import io.reactivex.Single
import org.apache.commons.io.IOUtils
import org.slf4j.LoggerFactory
import java.io.IOException

object ReadFileFromResources {
    private val LOG = LoggerFactory.getLogger(ReadFileFromResources::class.java)

    fun readFile(fileName: String): Single<String> {
        return Single.create { emitter ->
            val classLoader = Thread.currentThread().contextClassLoader
            try {
                classLoader.getResourceAsStream(fileName).use {
                    resourceAsStream ->
                    emitter.onSuccess(IOUtils.toString(resourceAsStream))
                }
            } catch (e: IOException) {
                LOG.error("Failed to read xml from resource", e)
                emitter.onError(e)
            }
        }
    }
}
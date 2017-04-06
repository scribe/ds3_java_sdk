package com.spectralogic.escapepod.util

import org.apache.commons.io.IOUtils
import org.slf4j.LoggerFactory
import java.io.IOException

object ReadFileFromResources {
    private val LOG = LoggerFactory.getLogger(ReadFileFromResources::class.java)

    fun readFile(fileName: String): String {

        val classLoader = Thread.currentThread().contextClassLoader
        try {
            classLoader.getResourceAsStream(fileName).use {
                resourceAsStream -> return IOUtils.toString(resourceAsStream)
            }
        } catch (e: IOException) {
            LOG.error("Failed to read xml from resource", e)
            throw e
        }
    }
}
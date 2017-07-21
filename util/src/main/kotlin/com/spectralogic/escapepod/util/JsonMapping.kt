package com.spectralogic.escapepod.util

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.guava.GuavaModule
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule

import java.io.InputStream
import java.io.OutputStream

object JsonMapping {

    private val MAPPER = ObjectMapper()

    init {
        MAPPER.registerModule(GuavaModule())
        MAPPER.registerModule(JavaTimeModule())
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    }

    fun mapper() : ObjectMapper {
        return MAPPER.copy()
    }

    fun <T> fromJson(stream: InputStream, clazz: Class<T>): T {
        return MAPPER.readValue(stream, clazz)
    }

    fun toJson(output: OutputStream, obj: Any) {
        MAPPER.writeValue(output, obj)
    }
}
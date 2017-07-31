/*
 * *****************************************************************************
 *    Copyright 2014-2017 Spectra Logic Corporation. All Rights Reserved.
 *    Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *    this file except in compliance with the License. A copy of the License is located at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *    or in the "license" file accompanying this file.
 *    This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *    CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *    specific language governing permissions and limitations under the License.
 *  ****************************************************************************
 */

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
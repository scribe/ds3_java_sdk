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

package com.spectralogic.escapepod.util.json

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.guava.GuavaModule
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.vavr.jackson.datatype.VavrModule

object Mapper {

    private val internalMapper = ObjectMapper()

    /**
     * This property returns a new copy of a pre-configured ObjectMapper on each invocation.
     * The intention for this class is to provide a ObjectMapper with sane defaults that
     * can be used in most cases, but then modified as needed without affecting other
     * ObjectMappers that are returned by this call.
     */
    val mapper: ObjectMapper
    get (): ObjectMapper {
        return internalMapper.copy()
    }

    init {
        internalMapper.registerModule(GuavaModule())
        internalMapper.registerModule(JavaTimeModule())
        internalMapper.registerModule(VavrModule())
        internalMapper.registerModule(KotlinModule())
        internalMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    }
}


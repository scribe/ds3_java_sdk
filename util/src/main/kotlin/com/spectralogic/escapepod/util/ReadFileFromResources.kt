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
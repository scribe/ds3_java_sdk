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

package com.spectralogic.escapepod.ratpack

import com.spectralogic.escapepod.api.RequestContext
import org.slf4j.LoggerFactory
import ratpack.handling.Context
import ratpack.handling.Handler
import ratpack.registry.Registry
import java.time.Duration
import java.time.Instant
import java.util.*

internal class TracerHandler : Handler {

    private companion object {
        private val LOG = LoggerFactory.getLogger(TracerHandler::class.java)
    }

    override fun handle(ctx: Context) {

        val requestId = UUID.randomUUID()
        val timer = Instant.now()

        LOG.info("Request: {}\nHTTP Method: {}, HTTP URI: {}", requestId, ctx.request.method.toString(), ctx.request.uri)


        ctx.onClose {
            LOG.info("Request {} finished in {} with status code {}", requestId, formattedTimeDifference(timer), ctx.response.status.code)
        }

        ctx.next(Registry.single(RequestContext(requestId)))
    }

    private fun formattedTimeDifference(startTime: Instant): String {
        val currentInstant = Instant.now()

        return Duration.between(startTime, currentInstant).toString()
    }
}
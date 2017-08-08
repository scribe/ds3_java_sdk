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

import com.spectralogic.escapepod.api.monitoring.HTTP_METHOD_TAG
import com.spectralogic.escapepod.api.monitoring.HTTP_URI
import io.opentracing.Tracer
import ratpack.handling.Context
import ratpack.handling.Handler

internal class TracerHandler constructor(private val tracer: Tracer): Handler {

    override fun handle(ctx: Context) {
        tracer.buildSpan("request").startActive().use { span ->
            span.log("Started Handling Request")
            span.setTag(HTTP_METHOD_TAG, ctx.request.method.name)
            span.setTag(HTTP_URI, ctx.request.uri)
            val spanContinuation = span.capture()
            ctx.onClose {
                spanContinuation.activate().use {
                    it.log("Finished Handling Request")
                }
            }
        }

        ctx.next()
    }
}
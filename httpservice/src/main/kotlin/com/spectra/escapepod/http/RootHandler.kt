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

package com.spectra.escapepod.http

import io.opentracing.Tracer
import ratpack.func.Action
import ratpack.handling.Chain
import javax.inject.Inject

internal class RootHandler
@Inject constructor(
        private val moduleHandler: ModuleHandler,
        private val clusterHandlerChain: ClusterHandlerChain,
        private val tracer : Tracer
) : Action<Chain> {

    override fun execute(chain: Chain) {
        chain.all(TracerHandler(tracer))
        chain.get("modules", moduleHandler)
        chain.prefix("cluster", clusterHandlerChain)
        chain.get { ctx ->
            ctx.response.status(404).send("Handler not found")
        }
    }
}

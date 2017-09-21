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

import com.google.common.collect.ImmutableList
import com.spectralogic.escapepod.httpservice.HttpHandlerDeregistration
import com.spectralogic.escapepod.httpservice.HttpRouter
import com.spectralogic.escapepod.util.collections.toImmutableList
import org.slf4j.LoggerFactory
import ratpack.func.Action
import ratpack.handling.Chain

internal class RatpackHttpRouter : HttpRouter, Action<Chain>{

    private companion object {
        private val LOG = LoggerFactory.getLogger(RatpackHttpRouter::class.java)
    }

    @Volatile
    private var actionChains: ImmutableList<ActionChainRegistration> = ImmutableList.of()

    override fun execute(t: Chain) {
        actionChains.forEach {t.prefix(it.prefix, it.actionChain)}
    }

    override fun register(prefix: String, action: Action<Chain>): HttpHandlerDeregistration {
        LOG.info("Registering action chain for prefix: {}", prefix)
        synchronized(this) {
            val actionChain = ActionChainRegistration(prefix, action)

            actionChains = ImmutableList.builder<ActionChainRegistration>().addAll(actionChains).add(actionChain).build()
            return RatpackDeregistration(actionChain, this::deregister)
        }
    }

    private fun deregister(actionChain: ActionChainRegistration) {
        LOG.info("Deregistering action chain for prefix: {}", actionChain.prefix)
        synchronized(this) {
            actionChains = actionChains.asSequence().filter { actionChain != it }.toImmutableList()
        }
    }
}

internal data class ActionChainRegistration(val prefix: String, val actionChain: Action<Chain>)

internal class RatpackDeregistration(private val actionChain: ActionChainRegistration, private val deregisterAction: (actionChain: ActionChainRegistration) -> Unit) : HttpHandlerDeregistration {
    override fun deregister() {
        deregisterAction(actionChain)
    }
}
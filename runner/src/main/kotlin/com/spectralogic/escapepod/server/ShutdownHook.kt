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

package com.spectralogic.escapepod.server

import com.spectralogic.escapepod.api.Module
import io.reactivex.Completable
import org.slf4j.LoggerFactory

class ShutdownHook constructor(private val modules : List<Module>) : Thread("module-shutdown-hook") {

    private companion object {
        private val LOG = LoggerFactory.getLogger(ShutdownHook::class.java)
    }

    override fun run() {

        LOG.info("Shutting down all modules")

        Completable.merge(modules.map { it.shutdownModule() })
                .doOnError { t ->
                    LOG.error("Failed to shutdown modules", t)
                }
                .subscribe()
    }
}

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

import com.google.inject.Guice
import com.spectralogic.escapepod.api.ModuleRegistration
import com.spectralogic.escapepod.util.UtilGuiceModule
import com.spectralogic.escapepod.util.append

import com.spectralogic.escapepod.util.collections.toImmutableList
import com.spectralogic.escapepod.webui.WebUiGuiceModule
import io.reactivex.Completable
import org.slf4j.LoggerFactory


private val LOG = LoggerFactory.getLogger("Main")

fun main(arg: Array<String>) {

    val moduleLoader = ModuleLoaderImpl()

    val loadedModules = moduleLoader.loadModules()

    val injector = Guice.createInjector(loadedModules.map(ModuleRegistration<*>::guiceModule).append(UtilGuiceModule(), WebUiGuiceModule()).asIterable())

    val moduleInstances = loadedModules.map(ModuleRegistration<*>::module).map { injector.getInstance(it) }.toImmutableList()

    Runtime.getRuntime().addShutdownHook(ShutdownHook(moduleInstances))

    LOG.info("Loading modules: {}", moduleInstances.joinToString(", ") { it.name })

    try {
        // 2 stage loading of the modules
        Completable.merge(moduleInstances.map { it.loadModule() }).doOnError(::exitOnError)
                .andThen(Completable.merge(moduleInstances.map { it.startModule() })).subscribe()
    } catch (t: Throwable) {
        exitOnError(t)
    }

}

fun exitOnError(t: Throwable) {
    LOG.error("Failed to start server", t)
    System.exit(1)
}
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

import com.google.inject.AbstractModule
import com.google.inject.Provides
import com.spectralogic.escapepod.api.Server
import com.uber.jaeger.Configuration
import com.uber.jaeger.senders.Sender
import io.opentracing.Tracer
import java.nio.file.Path
import java.nio.file.Paths
import java.util.concurrent.ExecutorService
import java.util.concurrent.ForkJoinPool
import javax.inject.Named
import javax.inject.Singleton

class ServerGuiceModule : AbstractModule() {

    private val workers: ExecutorService = ForkJoinPool.commonPool()

    override fun configure() {
        bind(ModuleHandler::class.java).`in`(Singleton::class.java)
    }


    @Provides
    @Singleton
    fun tracer() : Tracer {
        val configuration = Configuration("escapePod", Configuration.SamplerConfiguration("const",  1), null)

        return configuration.tracer
    }

    @Provides
    @Named("dataDir")
    fun dataDir(@Named("baseDir") baseDir: Path) : Path = baseDir.resolve("data")

    @Provides
    @Named("configDir")
    fun configDir(@Named("baseDir") baseDir : Path) : Path = baseDir.resolve("config")

    @Provides
    @Named("baseDir")
    fun baseDir() : Path {
        val dataDirName = System.getenv()["baseDir"]

        return if (dataDirName == null) {
            Paths.get(System.getProperty("user.dir"), ".escapepod")
        } else {
            Paths.get(dataDirName)
        }
    }

    @Provides
    @Named("managementPort")
    fun managementPort() : Int {
        val envVars = System.getenv()
        if ("serverPort" in envVars) {
            val port = envVars["serverPort"]
            if (port != null) {
                return port.toInt()
            }
        }

        return 5050
    }

    @Provides
    @Named("interfaceIp")
    fun interfaceIp() : String = System.getenv()["interfaceIp"]?: "127.0.0.1"

    @Provides
    @Named("persistencePort")
    fun persistencePort() : Int {

        val port = System.getenv()["persistencePort"]

        if (port == null) {
            return 27017
        } else {
            return port.toInt()
        }
    }

    @Provides
    fun workers() : ExecutorService = workers

}

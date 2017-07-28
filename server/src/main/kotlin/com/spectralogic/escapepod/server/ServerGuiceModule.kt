package com.spectralogic.escapepod.server

import com.google.inject.AbstractModule
import com.google.inject.Provides
import com.spectralogic.escapepod.api.Server
import java.nio.file.Path
import java.nio.file.Paths
import java.util.concurrent.ExecutorService
import java.util.concurrent.ForkJoinPool
import javax.inject.Named
import javax.inject.Singleton

class ServerGuiceModule : AbstractModule() {

    private val workers: ExecutorService = ForkJoinPool.commonPool()

    override fun configure() {
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

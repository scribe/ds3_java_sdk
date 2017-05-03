package com.spectralogic.escapepod.server

import com.google.inject.AbstractModule
import com.google.inject.Provides
import com.greyrock.escapepod.util.ifNotNull
import com.spectralogic.escapepod.api.Server
import java.nio.file.Path
import java.nio.file.Paths
import java.util.concurrent.ExecutorService
import java.util.concurrent.ForkJoinPool
import javax.inject.Named
import javax.inject.Singleton

class ServerModule : AbstractModule() {

    private val workers: ExecutorService = ForkJoinPool.commonPool()

    override fun configure() {
        bind(Server::class.java).to(EscapePodServer::class.java)
        bind(RootHandler::class.java).`in`(Singleton::class.java)
        bind(ClusterHandlerChain::class.java).`in`(Singleton::class.java)
        bind(ShutdownHook::class.java).`in`(Singleton::class.java)
    }

    @Provides
    @Named("dataDir")
    fun dataDir(@Named("baseDir") baseDir: Path) : Path {
        return baseDir.resolve("data")
    }

    @Provides
    @Named
    fun configDir(@Named("baseDir") baseDir : Path) : Path {
        return baseDir.resolve("config")
    }

    @Provides
    @Named("baseDir")
    fun baseDir() : Path {
        val dataDirName = System.getenv()["baseDir"]

        if (dataDirName == null) {
            return Paths.get(System.getProperty("user.dir"), ".escapepod")
        } else {
            return Paths.get(dataDirName)
        }
    }

    @Provides
    @Named("httpPort")
    fun httpPort() : Int {
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
    fun interfaceIp() : String {
        return System.getenv()["interfaceIp"]?: "127.0.0.1"
    }

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
    fun workers() : ExecutorService {
        return workers
    }

}

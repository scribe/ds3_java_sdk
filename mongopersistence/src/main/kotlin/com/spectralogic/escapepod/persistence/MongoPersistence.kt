package com.spectralogic.escapepod.persistence

import com.greyrock.escapepod.util.ifNotNull
import com.spectralogic.escapepod.api.PersistenceService
import io.reactivex.Completable
import org.slf4j.LoggerFactory
import java.util.concurrent.TimeUnit

class MongoPersistence : PersistenceService {

    private companion object {
        private val LOG = LoggerFactory.getLogger(MongoPersistence::class.java)
    }

    private var mongoProcess : Process? = null

    override fun joinPersistenceCluster(name: String, nodes: Sequence<String>) {

    }

    override fun createNewPersistenceCluster(name: String, port : Int){
        // create new mongo process
        val processBuilder = ProcessBuilder("mongod", "--config", "/usr/local/etc/mongod.conf", "--port", port.toString())

        processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT)
        processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT)
        mongoProcess = processBuilder.start()
    }

    override fun shutdown() : Completable {

        return Completable.create{ emitter ->
            try {

                mongoProcess.ifNotNull {
                    it.destroy()
                    it.waitFor(30, TimeUnit.SECONDS)

                    if (it.isAlive) {
                        LOG.error("Mongo instance still active after shutdown attempt")
                    } else {
                        LOG.info("Mongo exited successfully with exit code: {}", it.exitValue())
                    }
                }

                emitter.onComplete()
            } catch (t : Throwable) {
                emitter.onError(t)
            }
        }

    }
}

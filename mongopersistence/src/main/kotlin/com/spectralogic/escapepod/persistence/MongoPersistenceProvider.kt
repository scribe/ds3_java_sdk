package com.spectralogic.escapepod.persistence

import com.greyrock.escapepod.util.ifNotNull
import com.spectralogic.escapepod.api.ClusterServiceProvider
import com.spectralogic.escapepod.api.PersistenceService
import com.spectralogic.escapepod.api.PersistenceServiceProvider
import io.reactivex.Completable
import org.slf4j.LoggerFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Named

class MongoPersistenceProvider @Inject constructor(private val clusterServiceProvider: ClusterServiceProvider, @Named("interfaceIp") private val interfaceIp : String): PersistenceServiceProvider {

    private companion object {
        private val LOG = LoggerFactory.getLogger(MongoPersistenceProvider::class.java)
        private val MONGO_CLUSTER_ENDPOINT = "mongoClusterEndpoint"
    }

    override fun startService(): Completable {
        return Completable.complete()
    }

    override fun getService(): PersistenceService {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var mongoProcess : Process? = null

    override fun joinPersistenceCluster(name: String, nodes: Sequence<String>) : Completable {
        return Completable.create {


        }
    }

    override fun createNewPersistenceCluster(name: String, port : Int) : Completable {
        // create new mongo process

        // TODO add check to make sure we are not already in a cluster

        return Completable.create { emitter ->

            try {

                val clusterService = clusterServiceProvider.getService()

                val processBuilder = ProcessBuilder("mongod", "--config", "/usr/local/etc/mongod.conf", "--port", port.toString(), "--replSet", name)

                processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT)
                processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT)
                mongoProcess = processBuilder.start()

                val distributedSet = clusterService.getDistributedSet<MongoNode>(MONGO_CLUSTER_ENDPOINT)
                distributedSet.add(MongoNode(interfaceIp, port))

                emitter.onComplete()

            } catch (t : Throwable) {
                emitter.onError(t)
            }
        }
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

data class MongoNode(val ip : String, val port : Int)

class MongoPersistenceService : PersistenceService {

}

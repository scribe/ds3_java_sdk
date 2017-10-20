package com.spectralogic.escapepod.avidpamwsclient

import com.spectralogic.escapepod.httpservice.handleError
import com.spectralogic.escapepod.httpservice.toPromise
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import org.slf4j.LoggerFactory
import ratpack.func.Action
import ratpack.handling.Chain
import ratpack.jackson.Jackson.json
import java.util.concurrent.ExecutorService
import javax.inject.Inject

internal class AvidPamWsClientHandlerChain
@Inject constructor(workers: ExecutorService, private val avidPamPersistenceHandlers: AvidPamPersistenceHandlers, private val avidPamWsClientHandlers: AvidPamWsClientHandlers) : Action<Chain> {

    private companion object {
        private val LOG = LoggerFactory.getLogger(AvidPamWsClientHandlerChain::class.java)
    }

    private val scheduler: Scheduler = Schedulers.from(workers)

    override fun execute(chain: Chain) {
        chain.path(":name?") { ctx ->
            ctx.byMethod {
                it.delete { ctx ->
                    val name = ctx.pathTokens["name"]

                    if (name.isNullOrEmpty()) {
                        ctx.response.status(403).send("")
                    } else {
                        avidPamPersistenceHandlers.deletePamSystem(name!!)
                                .observeOn(scheduler)
                                .toPromise()
                                .onError { t ->
                                    val message = "Encountered an error with deleting a pam system: "
                                    LOG.error(message, t)
                                    ctx.handleError(t)
                                }
                                .then { _ ->
                                    ctx.response.status(204).send("")
                                }
                    }
                }

                it.get { ctx ->
                    val name = ctx.pathTokens["name"]
                    if (name.isNullOrEmpty()) {
                        avidPamPersistenceHandlers.getAllPamSystems()
                                .observeOn(scheduler)
                                .toPromise()
                                .onError { t ->
                                    val message = "Encountered an error with getting all the pam systems: "
                                    LOG.error(message, t)
                                    ctx.handleError(t)
                                }
                                .then { res ->
                                    ctx.render(json(res))
                                }
                    } else {
                        avidPamPersistenceHandlers.getPamSystem(name!!)
                                .observeOn(scheduler)
                                .toPromise()
                                .onError { t ->
                                    val message = "Encountered an error with getting a pam system: "
                                    LOG.error(message, t)
                                    ctx.handleError(t)
                                }
                                .then { res ->
                                    ctx.render(json(res))
                                }
                    }
                }

                it.put { ctx ->
                    val name = ctx.pathTokens["name"]
                    val username = ctx.request.queryParams["username"]
                    val password = ctx.request.queryParams["password"]
                    val endpoint = ctx.request.queryParams["endpoint"]
                    val workGroup = ctx.request.queryParams["workgroup"]

                    if (name.isNullOrEmpty() || username.isNullOrEmpty() || password.isNull() || endpoint.isNullOrEmpty() || workGroup.isNullOrEmpty()) {
                        val message = "name, username, password, endpoint and workgroup must be set"
                        LOG.error(message)
                        ctx.handleError(Throwable(message))
                    } else {
                        avidPamPersistenceHandlers.putPamSystem(name!!, username!!, password!!, endpoint!!, workGroup!!)
                                .observeOn(scheduler)
                                .toPromise()
                                .onError { t ->
                                    val message = "Encountered an error with putting a pam system: "
                                    LOG.error(message, t)
                                    ctx.handleError(t)
                                }
                                .then { res ->
                                    //TODO map result to different type (ex not including password)
                                    ctx.render(json(res))
                                }
                    }
                }

                it.post { ctx ->
                    val name = ctx.request.queryParams["name"]
                    val username = ctx.request.queryParams["username"]
                    val password = ctx.request.queryParams["password"]
                    val endpoint = ctx.request.queryParams["endpoint"]
                    val workGroup = ctx.request.queryParams["workgroup"]

                    if (name.isNullOrEmpty() || username.isNullOrEmpty() || password.isNull() || endpoint.isNullOrEmpty() || workGroup.isNullOrEmpty()) {
                        val message = "name, username, password, endpoint and workgroup must be set"
                        LOG.error(message)
                        ctx.handleError(Throwable(message))
                    } else {
                        avidPamPersistenceHandlers.postPamSystem(name!!, username!!, password!!, endpoint!!, workGroup!!)
                                .observeOn(scheduler)
                                .toPromise()
                                .onError { t ->
                                    val message = "Encountered an error with posting a pam system: "
                                    LOG.error(message, t)
                                    ctx.handleError(t)
                                }
                                .then { res ->
                                    //TODO map result to different type (ex not including password)
                                    ctx.render(json(res))
                                }
                    }
                }
            }
        }

        chain.get(":name/folders") { ctx ->
            val name = ctx.pathTokens["name"]

            avidPamWsClientHandlers.getFolders(name!!)
                    .observeOn(scheduler)
                    .toPromise()
                    .onError { t ->
                        val message = "Encountered an error with get pam system '$name' folders: "
                        LOG.error(message, t)
                        ctx.handleError(t)
                    }
                    .then { res ->
                        ctx.render(json(res))
                    }
        }

        chain.get(":name/profiles") { ctx ->
            val name = ctx.pathTokens["name"]

            avidPamWsClientHandlers.getProfiles(name!!)
                    .observeOn(scheduler)
                    .toPromise()
                    .onError { t ->
                        val message = "Encountered an error with get pam system '$name' profiles: "
                        LOG.error(message, t)
                        ctx.handleError(t)
                    }
                    .then { res ->
                        ctx.render(json(res))
                    }
        }

        chain.get(":name/assets") { ctx ->
            val name = ctx.pathTokens["name"]
            var folder = ctx.request.queryParams["folder"]

            if (folder.isNullOrEmpty()) {
                folder = "/"
            }

            avidPamWsClientHandlers.getPamAssets(name!!, folder!!)
                    .observeOn(scheduler)
                    .toPromise()
                    .onError { t ->
                        val message = "Encountered an error with get pam system '$name' assets: "
                        LOG.error(message, t)
                        ctx.handleError(t)
                    }
                    .then { res ->
                        ctx.render(json(res))
                    }

        }

        chain.get(":name/jobstatus") { ctx ->
            val name = ctx.pathTokens["name"]
            val jobId = ctx.request.queryParams["jobid"]

            if (jobId.isNullOrEmpty()) {
                val message = "'jobid' must be set"
                LOG.error(message)
                ctx.handleError(Throwable(message))
            } else {
                avidPamWsClientHandlers.getJobStatus(name!!, jobId!!)
                        .observeOn(scheduler)
                        .toPromise()
                        .onError { t ->
                            val message = "Encountered an error when getting job status: "
                            LOG.error(message, t)
                            ctx.handleError(t)
                        }
                        .then { res ->
                            ctx.render(json(res))
                        }
            }
        }


        chain.get(":name/maxarchiveassetsize") { ctx ->
            val name = ctx.pathTokens["name"]

            avidPamWsClientHandlers.getMaxArchiveAssetSize(name!!)
                    .observeOn(scheduler)
                    .toPromise()
                    .onError { t ->
                        val message = "Encountered an error with get pam system '$name' max archive asset size: "
                        LOG.error(message, t)
                        ctx.handleError(t)
                    }
                    .then { res ->
                        ctx.render(json(res))
                    }
        }

        chain.get(":name/workgroups") { ctx ->
            val name = ctx.pathTokens["name"]

            avidPamWsClientHandlers.getWorkGroups(name!!)
                    .observeOn(scheduler)
                    .toPromise()
                    .onError { t ->
                        val message = "Encountered an error with get pam system '$name' workgroups: "
                        LOG.error(message, t)
                        ctx.handleError(t)
                    }
                    .then { res ->
                        ctx.render(json(res))
                    }
        }


        chain.get(":name/filelocations") { ctx ->
            val name = ctx.pathTokens["name"]
            val mobid = ctx.request.queryParams["mobid"]

            if (mobid.isNullOrEmpty()) {
                ctx.response.status(400).send("mobid must be set")
            } else {
                avidPamWsClientHandlers.getFileLocations(name!!, mobid!!)
                        .observeOn(scheduler)
                        .toPromise()
                        .onError { t ->
                            val message = "Encountered an error with get pam system '$name' file locations: "
                            LOG.error(message, t)
                            ctx.handleError(t)
                        }
                        .then { res ->
                            ctx.render(json(res))
                        }
            }
        }

        chain.get(":name/sequencerelatives") { ctx ->
            val name = ctx.pathTokens["name"]
            val mobid = ctx.request.queryParams["mobid"]

            if (mobid.isNullOrEmpty()) {
                ctx.response.status(400).send("mobid must be set")
            } else {
                avidPamWsClientHandlers.getSequenceRelatives(name!!, mobid!!)
                        .observeOn(scheduler)
                        .toPromise()
                        .onError { t ->
                            val message = "Encountered an error with get pam system '$name' sequence relatives: "
                            LOG.error(message, t)
                            ctx.handleError(t)
                        }
                        .then { res ->
                            ctx.render(json(res))
                        }
            }
        }

        chain.get(":name/assettype") { ctx ->
            val name = ctx.pathTokens["name"]
            val mobid = ctx.request.queryParams["mobid"]

            if (mobid.isNullOrEmpty()) {
                ctx.response.status(400).send("mobid must be set")
            } else {
                avidPamWsClientHandlers.getAssetType(name!!, mobid!!)
                        .observeOn(scheduler)
                        .toPromise()
                        .onError { t ->
                            val message = "Encountered an error with get pam system '$name' asset type: "
                            LOG.error(message, t)
                            ctx.handleError(t)
                        }
                        .then { res ->
                            ctx.render(json(res))
                        }
            }
        }

        chain.post(":name/archive") { ctx ->
            val name = ctx.pathTokens["name"]
            val profile = ctx.request.queryParams["profile"]
            val mobid = ctx.request.queryParams["mobid"]

            if (profile.isNullOrEmpty() || mobid.isNullOrEmpty()) {
                ctx.response.status(400).send("'profile' and 'mobid' must be set")
            } else {
                avidPamWsClientHandlers.archiveFile(name!!, profile!!, mobid!!)
                        .observeOn(scheduler)
                        .toPromise()
                        .onError { t ->
                            val message = "Encountered an error with archiving pam system '$name' asset type: "
                            LOG.error(message, t)
                            ctx.handleError(t)
                        }
                        .then { res ->
                            ctx.render(json(res))
                        }
            }
        }

        chain.post(":name/restore") { ctx ->
            val name = ctx.pathTokens["name"]
            val profile = ctx.request.queryParams["profile"]
            val mobid = ctx.request.queryParams["mobid"]

            if (profile.isNullOrEmpty() || mobid.isNullOrEmpty()) {
                ctx.response.status(400).send("'profile' and 'mobid' must be set")
            } else {
                avidPamWsClientHandlers.restoreFile(name!!, profile!!, mobid!!)
                        .observeOn(scheduler)
                        .toPromise()
                        .onError { t ->
                            val message = "Encountered an error with restoring pam system '$name' asset type: "
                            LOG.error(message, t)
                            ctx.handleError(t)
                        }
                        .then { res ->
                            ctx.render(json(res))
                        }
            }
        }
    }
}
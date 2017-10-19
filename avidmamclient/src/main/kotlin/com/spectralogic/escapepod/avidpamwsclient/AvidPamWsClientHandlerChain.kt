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
@Inject constructor(workers: ExecutorService, private val avidPamPersistenceHandlers: AvidPamPersistenceHandlers) : Action<Chain> {

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
                        avidPamPersistenceHandlers.deleteAllPamSystems()
                                .observeOn(scheduler)
                                .toPromise()
                                .onError { t ->
                                    val message = "Encountered an error with deleting all pam systems: "
                                    LOG.error(message, t)
                                    ctx.handleError(t)
                                }
                                .then { _ ->
                                    ctx.render(json("All the Pam systems were deleted successfully."))
                                }
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
                                    ctx.render(json("Pam system '$name' was deleted successfully."))
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
//
//                chain.get("folders") { ctx ->
//                    getFolders(ctx)
//                }
//
//                chain.get("profiles") { ctx ->
//                    getProfiles(ctx)
//                }
//
//                chain.get("files") { ctx ->
//                    getFiles(ctx)
//                }
//
//                chain.get("jobstatus") { ctx ->
//                    getJobStatus(ctx)
//                }
//
//                chain.get("maxarchiveassetsize") { ctx ->
//                    getMaxArchiveAssetSize(ctx)
//                }
//
//                chain.get("workgroups") { ctx ->
//                    getWorkGroups(ctx)
//                }
//
//                chain.get("filelocations") { ctx ->
//                    getFileLocations(ctx)
//                }
//
//                chain.get("sequencerelatives") { ctx ->
//                    getSequenceRelatives(ctx)
//                }
//
//                chain.get("assettype") { ctx ->
//                    getAssetType(ctx)
//                }
//
//                chain.post("archive") { ctx ->
//                    archiveFile(ctx)
//                }
//
//                chain.post("restore") { ctx ->
//                    restoreFile(ctx)
//                }
    }
}
package com.spectralogic.escapepod.avidpamwsclient

import org.slf4j.LoggerFactory

internal object AvidPamWsClientHandlers {
    private val LOG = LoggerFactory.getLogger(AvidPamWsClientHandlers::class.java)

//    fun getWorkGroups(ctx: Context) {
//        pamMigrateProvider.getWorkGroups().observeOn(scheduler)
//                .toPromise()
//                .onError { t ->
//                    val message = "Encountered an error with getting all the work groups: "
//                    LOG.error(message, t)
//                    ctx.handleError(t)
//                }
//                .then { res ->
//                    ctx.render(Jackson.json(res))
//                }
//    }

//    fun getMaxArchiveAssetSize(ctx: Context) {
//        val workGroup = ctx.request.queryParams["workgroup"]
//
//        if (workGroup.isNullOrEmpty()) {
//            ctx.response.status(400).send("'workgroup' must be set")
//        } else {
//            pamMigrateProvider.getMaxArchiveAssetSize(workGroup!!).observeOn(scheduler)
//                    .toPromise()
//                    .onError { t ->
//                        val message = "Encountered an error with getting the max archive asset size: "
//                        LOG.error(message, t)
//                        ctx.handleError(t)
//                    }
//                    .then { res ->
//                        ctx.render(Jackson.json(res))
//                    }
//        }
//    }
//
//    fun getFolders(ctx: Context) {
//        val workGroup = ctx.request.queryParams["workgroup"]
//
//        if (workGroup.isNullOrEmpty()) {
//            ctx.response.status(400).send("'workgroup' must be set")
//        } else {
//            pamMigrateProvider.getFolders(workGroup!!).observeOn(scheduler)
//                    .toPromise()
//                    .onError { t ->
//                        val message = "Encountered an error with getting folders: "
//                        LOG.error(message, t)
//                        ctx.handleError(t)
//                    }
//                    .then { res ->
//                        ctx.render(Jackson.json(res))
//                    }
//        }
//    }
//
//    fun getFiles(ctx: Context) {
//        val workGroup = ctx.request.queryParams["workgroup"]
//        val folder = ctx.request.queryParams["folder"]
//
//        if (workGroup.isNullOrEmpty() || folder.isNullOrEmpty()) {
//            ctx.response.status(400).send("'workgroup' and 'folder' must be set")
//        } else {
//            pamMigrateProvider.getFiles(workGroup!!, folder!!).observeOn(scheduler)
//                    .toPromise()
//                    .onError { t ->
//                        val message = "Encountered an error with getting files: "
//                        LOG.error(message, t)
//                        ctx.handleError(t)
//                    }
//                    .then { res ->
//                        ctx.render(Jackson.json(res))
//                    }
//        }
//    }
//
//    fun getProfiles(ctx: Context) {
//        val workGroup = ctx.request.queryParams["workgroup"]
//
//        if (workGroup.isNullOrEmpty()) {
//            ctx.response.status(400).send("'workgroup' must be set")
//        } else {
//            pamMigrateProvider.getProfiles(workGroup!!).observeOn(scheduler)
//                    .toPromise()
//                    .onError { t ->
//                        val message = "Encountered an error with getting the profiles: "
//                        LOG.error(message, t)
//                        ctx.handleError(t)
//                    }
//                    .then { res ->
//                        ctx.render(Jackson.json(res))
//                    }
//        }
//    }
//
//    fun getJobStatus(ctx: Context) {
//        val workGroup = ctx.request.queryParams["workgroup"]
//        val jobId = ctx.request.queryParams["jobid"]
//
//        if (workGroup.isNullOrEmpty() || jobId.isNullOrEmpty()) {
//            ctx.response.status(400).send("'workgroup' and 'jobid' must be set")
//        } else {
//            pamMigrateProvider.getJobStatus(workGroup!!, jobId!!).observeOn(scheduler)
//                    .toPromise()
//                    .onError { t ->
//                        val message = "Encountered an error when getting job status: "
//                        LOG.error(message, t)
//                        ctx.handleError(t)
//                    }
//                    .then { res ->
//                        ctx.render(Jackson.json(res))
//                    }
//        }
//    }
//
//    fun getFileLocations(ctx: Context) {
//        val workGroup = ctx.request.queryParams["workgroup"]
//        val mobid = ctx.request.queryParams["mobid"]
//
//        if (workGroup.isNullOrEmpty() || mobid.isNullOrEmpty()) {
//            ctx.response.status(400).send("'workgroup' and 'mobid' must be set")
//        } else {
//            pamMigrateProvider.getFileLocations(workGroup!!, mobid!!).observeOn(scheduler)
//                    .toPromise()
//                    .onError { t ->
//                        val message = "Encountered an error when getting file locations: "
//                        LOG.error(message, t)
//                        ctx.handleError(t)
//                    }
//                    .then { res ->
//                        ctx.render(Jackson.json(res))
//                    }
//        }
//    }
//
//    fun getSequenceRelatives(ctx: Context) {
//        val workGroup = ctx.request.queryParams["workgroup"]
//        val mobid = ctx.request.queryParams["mobid"]
//
//        if (workGroup.isNullOrEmpty() || mobid.isNullOrEmpty()) {
//            ctx.response.status(400).send("'workgroup' and 'mobid' must be set")
//        } else {
//            pamMigrateProvider.getSequenceRelatives(workGroup!!, mobid!!).observeOn(scheduler)
//                    .toPromise()
//                    .onError { t ->
//                        val message = "Encountered an error when getting sequence relatives: "
//                        LOG.error(message, t)
//                        ctx.handleError(t)
//                    }
//                    .then { res ->
//                        ctx.render(Jackson.json(res))
//                    }
//        }
//    }
//
//    fun getAssetType(ctx: Context) {
//        val workGroup = ctx.request.queryParams["workgroup"]
//        val mobid = ctx.request.queryParams["mobid"]
//
//        if (workGroup.isNullOrEmpty() || mobid.isNullOrEmpty()) {
//            ctx.response.status(400).send("'workgroup' and 'mobid' must be set")
//        } else {
//            pamMigrateProvider.getAssetType(workGroup!!, mobid!!).observeOn(scheduler)
//                    .toPromise()
//                    .onError { t ->
//                        val message = "Encountered an error when getting asset type: "
//                        LOG.error(message, t)
//                        ctx.handleError(t)
//                    }
//                    .then { res ->
//                        ctx.render(Jackson.json(res))
//                    }
//        }
//    }
//
//    fun restoreFile(ctx: Context) {
//        val workGroup = ctx.request.queryParams["workgroup"]
//        val profile = ctx.request.queryParams["profile"]
//        val mobid = ctx.request.queryParams["mobid"]
//
//        if (workGroup.isNullOrEmpty() || profile.isNullOrEmpty() || mobid.isNullOrEmpty()) {
//            ctx.response.status(400).send("'workgroup', 'profile' and 'mobid' must be set")
//        } else {
//            pamMigrateProvider.restoreFile(workGroup!!, profile!!, mobid!!).observeOn(scheduler)
//                    .toPromise()
//                    .onError { t ->
//                        val message = "Encountered an error when restoring an asset: "
//                        LOG.error(message, t)
//                        ctx.handleError(t)
//                    }
//                    .then { res ->
//                        ctx.render(Jackson.json(res))
//                    }
//        }
//    }
//
//    fun archiveFile(ctx: Context) {
//        val workGroup = ctx.request.queryParams["workgroup"]
//        val profile = ctx.request.queryParams["profile"]
//        val mobid = ctx.request.queryParams["mobid"]
//
//        if (workGroup.isNullOrEmpty() || profile.isNullOrEmpty() || mobid.isNullOrEmpty()) {
//            ctx.response.status(400).send("'workgroup', 'profile' and 'mobid' must be set")
//        } else {
//            pamMigrateProvider.archiveFile(workGroup!!, profile!!, mobid!!).observeOn(scheduler)
//                    .toPromise()
//                    .onError { t ->
//                        val message = "Encountered an error when archiving an asset: "
//                        LOG.error(message, t)
//                        ctx.handleError(t)
//                    }
//                    .then { res ->
//                        ctx.render(Jackson.json(res))
//                    }
//        }
//    }
}
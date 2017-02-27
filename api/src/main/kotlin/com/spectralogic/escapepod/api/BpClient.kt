package com.spectralogic.escapepod.api

import java.util.*

interface BpClient {
    /**
     * Transfers a list of files to black pearl.  These files have to be accessible on the local file system
     */
    fun transferFiles(localFileList: Sequence<String>, prefix: String = "")

    /**
     * Resets the timeout for a remove BP job
     */
    fun keepJobAlive(jobId: UUID)

    /**
     * Checks if the job is still active
     */
    fun isJobActive(jobId: UUID) : Boolean

    /**
     * Get the list of buckets in the bp
     */
    fun buckets() : Sequence<BpBucket>

    /**
     * Creates a bucket with the name `bucketName` only if it doesn't already exist
     */
    fun ensureBucketExists(bucketName: String)

    /**
     * Get the list of objects in a buckets
     */
    fun objects(bucketName: String): Sequence<BpObject>
}

data class BpBucket(val name: String)

data class BpObject(val name: String, val size: Long)
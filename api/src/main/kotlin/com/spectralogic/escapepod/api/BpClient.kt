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
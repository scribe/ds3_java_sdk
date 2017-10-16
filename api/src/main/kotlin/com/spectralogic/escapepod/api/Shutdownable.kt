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

import io.reactivex.Completable

interface Shutdownable {
    fun shutdown() : Completable
}

/**
 * This will, in a blocking way, shutdown the `Shutdownable` class.
 * This should primarily be used only for testing since it is a blocking call.
 */
fun <T: Shutdownable> T.use(function: (T) -> Unit) {
    try {
        function(this)
    } finally {
        this.shutdown().blockingAwait()
    }
}
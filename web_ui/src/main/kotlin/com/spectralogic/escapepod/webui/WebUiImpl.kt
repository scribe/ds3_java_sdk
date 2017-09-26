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

package com.spectralogic.escapepod.webui

import com.spectralogic.escapepod.httpservice.WebUi
import ratpack.handling.Context
import ratpack.handling.Handler
import ratpack.server.BaseDir
import java.nio.file.Paths
import org.slf4j.LoggerFactory

internal class WebUiImpl: WebUi {
    override fun slashHandler(): Handler {
        return StaticFilesHandler()
    }
}

internal class StaticFilesHandler: Handler {
    private companion object {
        private val LOG = LoggerFactory.getLogger(StaticFilesHandler::class.java)
        private val staticFilesLoaderPage = "index.html"
    }

    private val staticFilesPath: String?

    init {
        staticFilesPath = findStaticFilesPath()

        if (staticFilesPath == null) {
            LOG.error("Could not locate web ui static files.")
        }
    }

    private fun findStaticFilesPath(): String? {
        val staticFilesFolderPath = BaseDir.find(staticFilesLoaderPage)

        return staticFilesFolderPath?.toString()
    }

    override fun handle(ctx: Context) {
        if (staticFilesPath != null) {
            val staticFileName = ctx.pathBinding.pastBinding
            if (staticFileName.isNullOrBlank()) {
                ctx.response.sendFile(Paths.get(staticFilesPath, staticFilesLoaderPage))
            } else {
                ctx.response.sendFile(Paths.get(staticFilesPath, staticFileName))
            }
        }
    }
}
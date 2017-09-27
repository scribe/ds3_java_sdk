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
        private val STATIC_FILES_LANDING_PAGE = "index.html"
        private val LANDING_PAGE_NOT_FOUND_STATUS = 404
        private val ERROR_PAGE_BACKGROUND_COLOR = "cadetBlue"
        private val ERROR_PAGE_TEXT_COLOR = "white"
        private val ERROR_PAGE_TITLE = "Error page"
        private val LANDING_PAGE_NOT_FOUND_ERROR_TEXT = "We cannot locate our application page.  Please accept our apologies."
    }

    private val staticFilesPath: String?

    init {
        staticFilesPath = findStaticFilesPath()

        if (staticFilesPath == null) {
            LOG.error("Could not locate web ui static files.")
        }
    }

    private fun findStaticFilesPath(): String? {
        val staticFilesFolderPath = BaseDir.find(STATIC_FILES_LANDING_PAGE)

        return staticFilesFolderPath?.toString()
    }

    override fun handle(ctx: Context) {
        if (staticFilesPath != null) {
            val staticFileName = ctx.pathBinding.pastBinding
            if (staticFileName.isNullOrBlank()) {
                ctx.response.sendFile(Paths.get(staticFilesPath, STATIC_FILES_LANDING_PAGE))
            } else {
                ctx.response.sendFile(Paths.get(staticFilesPath, staticFileName))
            }
        } else {
            sendErrorPage(ctx, LANDING_PAGE_NOT_FOUND_STATUS, ERROR_PAGE_BACKGROUND_COLOR, ERROR_PAGE_TEXT_COLOR,
                    ERROR_PAGE_TITLE, LANDING_PAGE_NOT_FOUND_ERROR_TEXT)
        }
    }

    private fun sendErrorPage(ctx: Context, httpStatus: Int, backgroundColor: String, textColor: String, pageTitle: String, errorText: String) {
        val payloadTextBuilder = StringBuilder("<html><head><title>")
                .append(pageTitle)
                .append("</title>")
                .append("<style> body { ")
                .append("background-color: ")
                .append(backgroundColor)
                .append("; ")
                .append("text-align: center; ")
                .append("color: ")
                .append(textColor)
                .append("} ")
                .append("</style></head><body><h1>")
                .append(errorText)
                .append("</h1></body></html>")

        ctx.response.status(httpStatus).contentType("text/html").send(payloadTextBuilder.toString())
    }
}
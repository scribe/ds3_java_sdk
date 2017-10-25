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

import com.spectralogic.escapepod.httpservice.UiModuleRegistration
import com.spectralogic.escapepod.httpservice.UiModuleRegistry
import com.spectralogic.escapepod.httpservice.WebUi
import ratpack.handling.Context
import ratpack.handling.Handler
import ratpack.server.BaseDir
import java.nio.file.Paths
import org.slf4j.LoggerFactory
import javax.inject.Inject

internal class WebUiImpl @Inject constructor(private val uiModuleRegistry: UiModuleRegistry,
                                             private val uiRouteGenerator: UIRouteGenerator,
                                             private val dynamicContentGenerator: DynamicContentGenerator) : WebUi
{
    override fun slashHandler(): Handler {
        return StaticFilesHandler(uiModuleRegistry, uiRouteGenerator, dynamicContentGenerator)
    }
}

// !!! get rid of this.  it's just here for development
internal class StubHandler : Handler {
    override fun handle(ctx: Context?) {
        ctx?.response?.sendFile(Paths.get(BaseDir.find("index.html").toString(), ctx.request.path))
    }
}

internal class StaticFilesHandler(private val uiModuleRegistry: UiModuleRegistry,
                                  private val uiRouteGenerator: UIRouteGenerator,
                                  private val dynamicContentGenerator: DynamicContentGenerator): Handler
{
    private companion object {
        private  val LOG = LoggerFactory.getLogger(StaticFilesHandler::class.java)
        private const val STATIC_FILES_LANDING_PAGE = "index.html"
        private const val LANDING_PAGE_NOT_FOUND_STATUS = 404
        private const val ERROR_PAGE_BACKGROUND_COLOR = "cadetBlue"
        private const val ERROR_PAGE_TEXT_COLOR = "white"
        private const val ERROR_PAGE_TITLE = "Error page"
        private const val LANDING_PAGE_NOT_FOUND_ERROR_TEXT = "We cannot locate our application page.  Please accept our apologies."
        private const val UI_ROUTING_TABLE_FILE_NAME = "app/app.routing.ts"
    }

    private val staticFilesPath: String?

    init {
        // !!! get rid of this.  it's just here for development
        uiModuleRegistry.registerUiModule(UiModuleRegistration("search", "app/search/search.module#SearchModule", "app/search/search.module.ts", StubHandler()))

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
            handleFileRequest(ctx)
        } else {
            handleFileRequestError(ctx)
        }
    }

    private fun handleFileRequest(ctx: Context) {
        val urlPath = ctx.request.path
        when {
            urlPath.isNullOrBlank() -> ctx.response.sendFile(Paths.get(staticFilesPath, STATIC_FILES_LANDING_PAGE))
            urlPath == UI_ROUTING_TABLE_FILE_NAME -> ctx.response.send(uiRouteGenerator.generateRoutes(uiModuleRegistry.registrations()))
            else -> handleModuleChain(urlPath, ctx)
        }
    }

    private fun handleModuleChain(urlPath: String, ctx: Context) {
        val uiModuleRegistration = uiModuleRegistry.registration(urlPath)

        if (uiModuleRegistration != null) {
            ctx.insert(uiModuleRegistration.resourceResolver)
        } else {
            ctx.response.sendFile(Paths.get(staticFilesPath, urlPath))
        }
    }

    private fun handleFileRequestError(ctx: Context) {
        ctx.response
                .status(LANDING_PAGE_NOT_FOUND_STATUS)
                .contentType("text/html")
                .send(dynamicContentGenerator.resourceNotFoundContent(ERROR_PAGE_BACKGROUND_COLOR,
                        ERROR_PAGE_TEXT_COLOR,
                        ERROR_PAGE_TITLE,
                        LANDING_PAGE_NOT_FOUND_ERROR_TEXT)
                )
    }
}

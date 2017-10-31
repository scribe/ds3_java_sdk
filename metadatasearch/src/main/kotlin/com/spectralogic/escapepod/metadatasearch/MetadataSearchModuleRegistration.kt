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

package com.spectralogic.escapepod.metadatasearch

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.httpservice.UiModuleRegistration
import com.spectralogic.escapepod.httpservice.UiModuleRegistry
import com.spectralogic.escapepod.ratpack.staticFilesPath
import io.reactivex.Completable
import ratpack.handling.Context
import ratpack.handling.Handler
import java.nio.file.Paths
import javax.inject.Inject

class MetadataSearchModuleRegistration : ModuleRegistration<MetadataSearchModule> {
    override fun module(): Class<MetadataSearchModule> = MetadataSearchModule::class.java

    override fun guiceModule(): AbstractModule = ElasticSearchGuiceModule()
}

class MetadataSearchModule
@Inject constructor(
        private val clusterServiceProvider: ClusterServiceProvider,
        private val metadataSearchServiceProvider: MetadataSearchServiceProvider,
        private val uiModuleRegistry: UiModuleRegistry) : Module
{
    override val name: String = "Metadata Search"

    // This has to come after the injected name field, otherwise the injection fails.  Shrug.
    private companion object {
        private const val uiUrl = "app/search/search.component.html"
    }

    override fun loadModule(): Completable {
        return Completable.create { emitter ->
            clusterServiceProvider.clusterLifecycleEvents().subscribe(metadataSearchServiceProvider::clusterHandler)
            emitter.onComplete()
        }
    }

    override fun startModule(): Completable {
        uiModuleRegistry.registerUiModule(UiModuleRegistration(name, "app/search/search.module#SearchModule", uiUrl, SearchModuleUiHandler()))

        return Completable.complete()
    }

    override fun shutdownModule(): Completable {
        uiModuleRegistry.unRegisterUiModule(uiUrl)

        return Completable.complete()
    }
}

internal class SearchModuleUiHandler : Handler {
    override fun handle(ctx: Context) {
        // TODO: This is an example generating content you want independent of whatever else is in the web client.
        // We're rendering html, but you could send back a file by doing something like the following:
        // ctx.response.sendFile(Paths.get(staticFilesPath().toString(), ctx.request.path))
        ctx.response.contentType("text/html").send("<html><body><h1>Hello from the Searchinator!</h1></body></html>")
    }
}

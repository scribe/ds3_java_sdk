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
import com.google.inject.Provides
import com.spectralogic.escapepod.api.MetadataSearchServiceProvider
import java.nio.file.Path
import java.nio.file.Paths
import javax.inject.Named
import javax.inject.Singleton

internal class ElasticSearchGuiceModule : AbstractModule() {
    override fun configure() {
        bind(MetadataSearchServiceProvider::class.java).to(ElasticSearchServiceProvider::class.java).`in`(Singleton::class.java)
        bind(MetadataSearchServiceConfigFile::class.java).to(ElasticSearchConfigFile::class.java).`in`(Singleton::class.java)
        bind(MetadataSearchModuleRegistration::class.java)
    }

    @Provides
    @Named("elasticSearchDir")
    fun elasticSearchDir() : Path {
        return Paths.get(System.getenv()["elasticSearchDir"]) ?:
                throw IllegalArgumentException("Missing elasticSearchBinDir value in environment")
    }

    @Provides
    @Named("elasticSearchBinDir")
    fun elasticSearchBinDir(@Named("elasticSearchDir") elasticSearchDir: Path) : Path = elasticSearchDir.resolve("bin")

    @Provides
    @Named("elasticSearchConfigDir")
    fun elasticSearchConfigDir(@Named("elasticSearchDir") elasticSearchDir: Path) : Path =
            elasticSearchDir.resolve("config")

    @Provides
    @Named("elasticSearchPort")
    fun elasticSearchPort() : Int {

        val port = System.getenv()["elasticSearchPort"]

        return port?.toInt() ?: 9200
    }
}


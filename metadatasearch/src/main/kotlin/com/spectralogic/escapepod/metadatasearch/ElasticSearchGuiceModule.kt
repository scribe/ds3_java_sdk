package com.spectralogic.escapepod.metadatasearch

import com.google.inject.AbstractModule
import com.google.inject.Provides
import com.spectralogic.escapepod.api.MetadataSearchServiceConfigFile
import com.spectralogic.escapepod.api.MetadataSearchServiceProvider
import java.nio.file.Path
import java.nio.file.Paths
import javax.inject.Named
import javax.inject.Singleton

internal class ElasticSearchGuiceModule : AbstractModule() {
    override fun configure() {
        bind(MetadataSearchServiceProvider::class.java).to(ElasticSearchServiceProvider::class.java).`in`(Singleton::class.java)
        bind(MetadataSearchServiceConfigFile::class.java).to(ElasticSearchConfigFile::class.java).`in`(Singleton::class.java)
        bind(MetadataSearchModuleLoader::class.java)
    }

    @Provides
    @Named("elasticSearchDir")
    fun elasticSearchDir() : Path {
        return Paths.get(System.getenv()["elasticSearchDir"]) ?:
                throw IllegalArgumentException("Missing elasticSearchBinDir value in environment")
    }

    @Provides
    @Named("elasticSearchBinDir")
    fun elasticSearchBinDir(@Named("elasticSearchDir") elasticSearchDir: Path) : Path {
        return elasticSearchDir.resolve("bin")
    }

    @Provides
    @Named("elasticSearchConfigDir")
    fun elasticSearchConfigDir(@Named("elasticSearchDir") elasticSearchDir: Path) : Path {
        return elasticSearchDir.resolve("config")
    }

    @Provides
    @Named("elasticSearchPort")
    fun elasticSearchPort() : Int {

        val port = System.getenv()["elasticSearchPort"]

        if (port == null) {
            return 9200
        } else {
            return port.toInt()
        }
    }
}


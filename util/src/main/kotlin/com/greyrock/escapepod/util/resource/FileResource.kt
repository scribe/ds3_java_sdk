package com.greyrock.escapepod.util.resource

import org.slf4j.LoggerFactory
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption

/**
 * FileResource classes are intended to hold configuration data for a system that is backed by a file.
 *
 * It will read from the file system once to load the configuration, and will then cache the configuration.
 * When the configuration is updated, the file backing the configuration will be overwritten, and the cached
 * version will be updated.
 */
class FileResource<T>(
        private val configDir : Path,
        configFileName : String,
        private val resourceMarshaller: ResourceMarshaller<T>
) : Resource<T> {
    private companion object {
        private val LOG = LoggerFactory.getLogger(FileResource::class.java)
    }

    private val configFilePath = configDir.resolve(configFileName)
    private val resourceLock = ResourceLock()

    private var configResource: T? = null

    override fun getResource(): T? {
        return resourceLock.readLock {
            if (configResource == null) {
                if (Files.exists(configFilePath)) {
                    configResource = loadConfigFromFile(configFilePath)
                } else {
                    LOG.warn("Attempted to load the cluster configResource file when it does not exist")
                }
            }
            configResource
        }
    }

    override fun saveResource(resource : T) {
        resourceLock.writeLock {
            ensureConfigDirExists(configDir)

            persistConfigFile(resource, configFilePath)
            configResource = resource
        }
    }

    override fun deleteResource() {
        resourceLock.writeLock {
            LOG.info("Deleting resource file {}", configFilePath)
            Files.deleteIfExists(configFilePath)
        }
    }

    private fun loadConfigFromFile(configPath : Path) : T {
        Files.newInputStream(configPath).use {
            return resourceMarshaller.loadResource(it)
        }
    }

    private fun ensureConfigDirExists(configDir: Path) {
        if (!Files.exists(configDir)) {
            Files.createDirectories(configDir)
        }
    }

    private fun persistConfigFile(config : T, configFilePath : Path) {
        Files.newOutputStream(configFilePath,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE).use {
            resourceMarshaller.saveResource(config, it)
        }
    }
}

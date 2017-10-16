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

package com.spectralogic.escapepod.util.resource

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
        private val resourceMarshaller: ResourceMarshaller,
        private val clazz: Class<T>
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
        LOG.info("Reading config from file")
        Files.newInputStream(configPath).use {
            return resourceMarshaller.loadResource(it, clazz)
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

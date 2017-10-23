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

import com.spectralogic.escapepod.httpservice.UIRouteGenerator
import freemarker.template.Configuration
import freemarker.template.TemplateExceptionHandler
import org.slf4j.LoggerFactory
import java.io.File
import java.io.StringWriter

class UIRouteGeneratorImpl : UIRouteGenerator {
    private companion object {
        private val LOG = LoggerFactory.getLogger(UIRouteGeneratorImpl::class.java)

        private const val APP_ROUTING_FILE_TEMPLATE = "appRoutingTypescriptFile.ftl"

        private var freeMarkerConfiguration: Configuration? = null
    }

    override fun generateRoutes(routeNames: Sequence<String>) : String {
        val appRoutingConfigurableValues = AppRoutingConfigurableValues(routeNames)

        val routingFileContentTemplate = freeMarkerConfiguration().getTemplate(APP_ROUTING_FILE_TEMPLATE)

        val stringWriter = StringWriter()

        routingFileContentTemplate.process(appRoutingConfigurableValues, stringWriter)

        return stringWriter.toString()
    }

    private fun freeMarkerConfiguration() : Configuration {
        synchronized(UIRouteGeneratorImpl::class.java) {
            if (freeMarkerConfiguration == null) {
                freeMarkerConfiguration = Configuration()
                freeMarkerConfiguration?.setDirectoryForTemplateLoading(resourceBundleLocation())
                freeMarkerConfiguration?.defaultEncoding = "UTF-8"
                freeMarkerConfiguration?.templateExceptionHandler = TemplateExceptionHandler.RETHROW_HANDLER
            }

            return freeMarkerConfiguration!!
        }
    }

    private fun resourceBundleLocation() : File {
        return File(javaClass.classLoader.getResource(APP_ROUTING_FILE_TEMPLATE).path).parentFile
    }
}

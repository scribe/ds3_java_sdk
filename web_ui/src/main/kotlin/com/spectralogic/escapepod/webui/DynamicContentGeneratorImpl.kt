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

import com.google.common.collect.ImmutableMap
import com.spectralogic.escapepod.httpservice.UiModuleRegistration
import freemarker.template.Configuration
import freemarker.template.Template
import freemarker.template.TemplateExceptionHandler
import java.io.File
import java.io.StringWriter

class DynamicContentGeneratorImpl : DynamicContentGenerator {
    override fun resourceNotFoundContent(backgroundColor: String,
                                         textColor: String,
                                         pageTitle: String,
                                         errorText: String): String
    {
        val errorPageTemplate = template("errorPage.ftl")

        val stringWriter = StringWriter()

        val errorPageConfigurableValues = ErrorPageConfigurableValues(backgroundColor,
                textColor,
                pageTitle,
                errorText)

        errorPageTemplate.process(errorPageConfigurableValues, stringWriter)

        return stringWriter.toString()
    }

    private fun template(templateFileName: String) : Template {
        return freeMarkerConfiguration(templateFileName).getTemplate(templateFileName)
    }

    private fun freeMarkerConfiguration(templateFileName: String) : Configuration {
        val freeMarkerConfiguration = Configuration()
        freeMarkerConfiguration.setDirectoryForTemplateLoading(resourceBundleLocation(templateFileName))
        freeMarkerConfiguration.defaultEncoding = "UTF-8"
        freeMarkerConfiguration.templateExceptionHandler = TemplateExceptionHandler.RETHROW_HANDLER

        return freeMarkerConfiguration
    }

    private fun resourceBundleLocation(templateFileName: String) : File {
        return File(javaClass.classLoader.getResource(templateFileName).path).parentFile
    }

    override fun webClientRoutingFileContent(routingInfo: ImmutableMap<String, UiModuleRegistration>) : String {
        val routingFileContentTemplate = template("appRoutingTypescriptFile.ftl")

        val stringWriter = StringWriter()

        val appRoutingConfigurableValues = AppRoutingConfigurableValues(routingInfo)

        routingFileContentTemplate.process(appRoutingConfigurableValues, stringWriter)

        return stringWriter.toString()
    }
}
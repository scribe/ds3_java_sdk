/*
 * ****************************************************************************
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

package com.spectralogic.escapepod.flashnetclient.requests

import com.google.common.base.Joiner
import com.google.inject.Inject
import com.spectralogic.escapepod.flashnetclient.FlashNetConfig
import org.simpleframework.xml.core.Persister
import org.simpleframework.xml.strategy.Type
import org.simpleframework.xml.strategy.Visitor
import org.simpleframework.xml.strategy.VisitorStrategy
import org.simpleframework.xml.stream.InputNode
import org.simpleframework.xml.stream.NodeMap
import org.simpleframework.xml.stream.OutputNode
import java.io.ByteArrayOutputStream

class FlashNetRequestFactoryImpl @Inject constructor(private val flashNetConfig: FlashNetConfig) : FlashNetRequestFactory
{
    private companion object {
        const val xmlNodeClassTag = "class"
        const val requestSpecificXmlNodeTag = "requestSpecificElement"
        const val utf8 = "UTF-8"

        /**
         * An implementation of xml persister that allows us to replace parts of the generated xml tree
         * with our own content.  What we're using this for is to inject request-type-specific nodes into
         * a request envelope.  Since all requests are contained in an outer request envelope, this allows
         * is to inject the right kind of request node -- a letter -- into a generic envelope.
         */
        val xmlPersister = Persister(VisitorStrategy(object : Visitor {
            @Throws(Exception::class)
            override fun read(type: Type, node: NodeMap<InputNode>) {
                // Intentionally not implemented
            }

            @Throws(Exception::class)
            override fun write(type: Type, node: NodeMap<OutputNode>) {
                if (node.name == requestSpecificXmlNodeTag) {
                    node.node.name = node
                            .node
                            .attributes[xmlNodeClassTag]
                            .value
                            .replaceBeforeLast(delimiter = '.', replacement = "", missingDelimiterValue = "")
                            .replace(".", "")
                    node.remove(xmlNodeClassTag)
                }
            }
        }))
    }

    override fun toMigrateAssetsRequest(migrate: Migrate): String {
        return makeFlashNetRequestPayload(requestType = "MigrateAssets", requestSpecificPayload = migrate)
    }

    override fun toListGroupRequest(): String {
        return makeFlashNetRequestPayload("ListGroup",null)
    }

    private fun<T> makeFlashNetRequestPayload(requestType : String, requestSpecificPayload : T) : String {
        val request = Request(flashNetConfig.flashNetApiVersion,
                flashNetConfig.flashNetSourceServer,
                flashNetConfig.flashNetUserName,
                flashNetConfig.flashNetCallingApplication,
                requestType, requestSpecificPayload)

        ByteArrayOutputStream().use { byteArrayOutputStream ->
            byteArrayOutputStream.write(Joiner.on("").join("<?xml version=\"1.0\" encoding=\"", utf8, "\"?>").toByteArray())

            xmlPersister.write(request, byteArrayOutputStream, utf8)

            val requestPayload = byteArrayOutputStream.toString(utf8)
            return Joiner.on(" ").join("FlashNet XML", requestPayload.length, requestPayload)
        }
    }

    override fun toStatusRequest(status: Status): String {
        return makeFlashNetRequestPayload(requestType = "Status", requestSpecificPayload = status)
    }
}
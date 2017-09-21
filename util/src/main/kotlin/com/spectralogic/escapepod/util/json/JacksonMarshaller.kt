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

package com.spectralogic.escapepod.util.json

import com.fasterxml.jackson.databind.ObjectMapper
import com.spectralogic.escapepod.util.resource.ResourceMarshaller
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

class JacksonMarshaller @Inject constructor(private val objectMapper: ObjectMapper): ResourceMarshaller {

    override fun <T> saveResource(resource: T, outStream: OutputStream) {
        objectMapper.writeValue(outStream, resource)
    }

    override fun <T> loadResource(inStream: InputStream, clazz: Class<T>): T {
        return objectMapper.readValue(inStream, clazz)
    }
}
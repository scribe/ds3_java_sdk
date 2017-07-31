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

/**
 * A ResourceProvider is responsible for Marshalling and Un-Marshalling a Resource.
 *
 * A ResourceProvider should not be concerned with locking or with if the streams exist.
 */
interface ResourceMarshaller<T> {
    fun saveResource(resource : T, outStream : java.io.OutputStream) : Unit
    fun loadResource(inStream: java.io.InputStream) : T
}

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

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "Status")
data class Status(
        @field:Attribute(name = "RequestId.DWD")
        @param:Attribute(name = "RequestId.DWD")
        val RequestId : Int,

        @field:Attribute(name = "Guid", required = false)
        @param:Attribute(name = "Guid", required = false)
        val Guid : String?
)
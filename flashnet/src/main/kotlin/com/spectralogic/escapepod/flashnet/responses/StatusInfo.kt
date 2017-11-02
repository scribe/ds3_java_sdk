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

package com.spectralogic.escapepod.flashnet.responses

import org.simpleframework.xml.Attribute

class StatusInfo {
    @field:Attribute(name = "Priority.DWD", required = false)
    var priority : Int = 0

    @field:Attribute(name = "SourceServer", required = false)
    var sourceServer : String = ""

    @field:Attribute(name = "JobStatus", required = false)
    var jobStatus: String = ""

    @field:Attribute(name = "ProcessType", required = false)
    var processType: String = ""
}


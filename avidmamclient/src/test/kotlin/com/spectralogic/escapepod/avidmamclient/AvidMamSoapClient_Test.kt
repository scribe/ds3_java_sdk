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

package com.spectralogic.escapepod.avidmamclient

import com.spectralogic.escapepod.avidmamclient.soap.bpmprocess.BPMProcessLocator
import org.junit.Test

internal class AvidMamSoapClient_Test {
    @Test
    fun basicTest() {
        val bpmProcessLocator = BPMProcessLocator()

        val endpoint = "10.85.41.233:9900"

        val endpointUrl = "http://$endpoint/WorkflowLibraryWS/BPMProcess.asmx"

        bpmProcessLocator.setEndpointAddress("BPMProcessSoap12", endpointUrl)
        val soapClient = bpmProcessLocator.bpmProcessSoap12
        val startProcess = soapClient.startProcess("", "", null, null, null)

        val processStatus = soapClient.getProcessStatus("", startProcess)

        println("Progress ${processStatus.progress}")

    }
}
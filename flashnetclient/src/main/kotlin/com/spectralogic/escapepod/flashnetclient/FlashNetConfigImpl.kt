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

package com.spectralogic.escapepod.flashnetclient

class FlashNetConfigImpl : FlashNetConfig {
    override fun portNumber(flashNetHost: String): Int? {
        return 49152
    }

    override fun flashNetApiVersion(): String {
        return "1.0"
    }

    override fun flashNetSourceServer(): String {
        return "FlashNet-source-server"
    }

    override fun flashNetUserName(): String {
        return "FlashNet-user-name"
    }

    override fun flashNetCallingApplication(): String {
        return "FlashNet-calling-application"
    }
}
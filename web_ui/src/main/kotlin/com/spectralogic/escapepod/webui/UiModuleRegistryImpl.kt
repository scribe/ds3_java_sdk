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

import com.google.common.collect.ImmutableList
import com.spectralogic.escapepod.httpservice.UiModuleRegistration
import com.spectralogic.escapepod.httpservice.UiModuleRegistry

internal class UiModuleRegistryImpl: UiModuleRegistry {
    private var uiModuleRegistrations: ImmutableList<UiModuleRegistration> = ImmutableList.of()

    override fun registerUiModule(uiModuleRegistration: UiModuleRegistration) {
        synchronized(this) {
            uiModuleRegistrations = ImmutableList.builder<UiModuleRegistration>().addAll(uiModuleRegistrations).add(uiModuleRegistration).build()
        }
    }

    override fun routeNames(): Sequence<String> {
        synchronized(this) {
            return uiModuleRegistrations.asSequence()
                    .map { it.name }
        }
    }
}

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

package com.spectralogic.escapepod.deviceregistry

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.DeviceRegistryModule
import com.spectralogic.escapepod.api.ModuleRegistration

class DeviceRegistryModuleRegistration : ModuleRegistration<DeviceRegistryModule> {
    override fun module(): Class<DeviceRegistryModule> = DeviceRegistryModule::class.java

    override fun guiceModule(): AbstractModule  = DeviceRegistryGuiceModule()
}
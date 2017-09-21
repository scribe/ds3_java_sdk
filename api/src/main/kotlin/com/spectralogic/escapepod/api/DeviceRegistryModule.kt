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

package com.spectralogic.escapepod.api

import io.reactivex.Completable
import io.reactivex.Single

interface DeviceRegistryModule : Module

interface DeviceRegistryServiceProvider : ServiceProvider<DeviceRegistryService>

/**
 * This service is used to store information about Verdes, Black Pearls, and other remote systems that
 * escape pod services will need to communicate with.
 */
interface DeviceRegistryService {
    fun registerDevice(credentials: ManagementCredentials): Single<DeviceRegistration>
    fun deviceRegistration(endpoint: String): Single<DeviceRegistration>
    fun removeRegistration(endpoint: String): Completable
}

data class ManagementCredentials(val endpoint: String, val username: String, val password: String)
data class DeviceRegistration(val endpoint: String, val users: Sequence<SpectraUser>)
data class SpectraUser(val userName: String, val fullName: String)
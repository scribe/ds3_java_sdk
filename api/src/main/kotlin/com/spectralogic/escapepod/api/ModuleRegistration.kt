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

import com.google.inject.AbstractModule
import io.reactivex.Completable

/**
 * ModuleRegistrations are used to retrieve all the Modules.  These Registrations are retrieved at runtime by the
 * ServiceLoader interface, and as such must register the registration in the file:
 * "META-INF/services/com.spectralogic.escapepod.api.ModuleRegistration"
 * interface.
 */
interface ModuleRegistration<T : Module> {
    fun module() : Class<T>
    fun guiceModule() : AbstractModule
}

interface Module {
    val name : String
    fun loadModule() : Completable
    fun startModule() : Completable
    fun shutdownModule() : Completable
}
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

package com.spectralogic.escapepod.httpservice

import com.google.common.collect.ImmutableMap
import ratpack.handling.Handler

interface UiModuleRegistry {
    fun registerUiModule(uiModuleRegistration: UiModuleRegistration)
    fun unRegisterUiModule(url: String)
    fun registration(routeName: String): UiModuleRegistration?
    fun registrations() : ImmutableMap<String, UiModuleRegistration>
}

/**
 * The UI Module Registration is how Escape Pod modules can register their own UI components into the standard UI.
 *
 * routeName is the string you want the UI to display
 *
 * routingTableEntry is the module route needed to populate the Angular routing table, e.g.
 * "app/search/search.module#SearchModule"
 *
 * url is the value you want the web client to send to the server to handle the request from routeName.
 *
 * resourceResolver is a handler that responds to a request to service url.  This allows a module implementer to
 * implement their UI logic however they want without the UI having to know how/where resources are retrieved.
 */
data class UiModuleRegistration(val routeName: String, val routingTableEntry: String, val url: String, val resourceResolver: Handler)

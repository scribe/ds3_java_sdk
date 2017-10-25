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

import com.spectralogic.escapepod.httpservice.UiModuleRegistration
import org.junit.Assert.assertEquals
import org.junit.Test
import ratpack.handling.Handler

class UiModuleRegistry_Test {
    @Test
    fun testAddingStuffToUiModuleRegistry() {
        val (url, routeName, uiModuleRegistry) = addStuffToUiModuleRegistry("url")

        assertEquals(1, uiModuleRegistry.registrations().size)
        assertEquals(routeName, uiModuleRegistry.registration(url)?.routeName)
    }

    private fun addStuffToUiModuleRegistry(url: String): Triple<String, String, UiModuleRegistryImpl> {
        val routeName = "routeName"
        val uiModuleRegistry = UiModuleRegistryImpl()
        uiModuleRegistry.registerUiModule(UiModuleRegistration(routeName, "routingTableEntry", url, Handler { }))
        return Triple(url, routeName, uiModuleRegistry)
    }

    @Test
    fun testRemovingStuffFromUiModuleRegistry() {
        val (url, routeName, uiModuleRegistry) = addStuffToUiModuleRegistry("url")
        val routeName2 = "routeName2"
        val url2 = "url2"
        uiModuleRegistry.registerUiModule(UiModuleRegistration(routeName2, "routingTableEntry", url2, Handler {  }))

        assertEquals(2, uiModuleRegistry.registrations().size)
        assertEquals(routeName, uiModuleRegistry.registration(url)?.routeName)

        uiModuleRegistry.unRegisterUiModule(url)

        assertEquals(1, uiModuleRegistry.registrations().size)
        assertEquals(routeName2, uiModuleRegistry.registration(url2)?.routeName)
    }
}
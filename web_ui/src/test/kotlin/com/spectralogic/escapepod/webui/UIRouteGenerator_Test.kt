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

import com.google.common.collect.ImmutableMap
import com.spectralogic.escapepod.httpservice.UiModuleRegistration
import org.junit.Assert.assertEquals
import org.junit.Test
import ratpack.handling.Handler

class UIRouteGenerator_Test {
    @Test
    fun testGeneratingAppRoutingContentWithOneRoute() {
        val uiRouteGenerator = UIRouteGeneratorImpl(DynamicContentGeneratorImpl())
        val moduleName = "search"
        val uiModuleRegistration = UiModuleRegistration(moduleName, "app/search/search.module#SearchModule", "app/search/search.module.ts", Handler {  })
        val routingInfo = ImmutableMap.of(moduleName, uiModuleRegistration)
        val routingFileContent = uiRouteGenerator.generateRoutes(routingInfo)

        val expected = "import { ModuleWithProviders } from '@angular/core';\n" +
                "import { RouterModule } from '@angular/router';\n" +
                "import { Routes } from '@angular/router';\n" +
                "\n" +
                "const routes: Routes = [\n" +
                "    \n" +
                "    { path: 'search', loadChildren: 'app/search/search.module#SearchModule' },\n" +
                "\n" +
                "];\n" +
                "\n" +
                "export const routing: ModuleWithProviders = RouterModule.forRoot(routes);\n"

        assertEquals(expected, routingFileContent)
    }

    @Test
    fun testGeneratingAppRoutingContentWithTwoRoutes() {
        val uiRouteGenerator = UIRouteGeneratorImpl(DynamicContentGeneratorImpl())
        val moduleName = "search"
        val moduleName2 = "Gracie"
        val uiModuleRegistration = UiModuleRegistration(moduleName, "app/search/search.module#SearchModule", "app/search/search.module.ts", Handler {  })
        val uiModuleRegistration2 = UiModuleRegistration(moduleName2, "app/Gracie/Gracie.module#GracieModule", "app/search/search.module.ts", Handler {  })
        val routingInfo = ImmutableMap.of(moduleName, uiModuleRegistration, moduleName2, uiModuleRegistration2)
        val routingFileContent = uiRouteGenerator.generateRoutes(routingInfo)

        val expected = "import { ModuleWithProviders } from '@angular/core';\n" +
                "import { RouterModule } from '@angular/router';\n" +
                "import { Routes } from '@angular/router';\n" +
                "\n" +
                "const routes: Routes = [\n" +
                "    \n" +
                "    { path: 'search', loadChildren: 'app/search/search.module#SearchModule' },\n" +
                "\n" +
                "\n" +
                "    { path: 'Gracie', loadChildren: 'app/Gracie/Gracie.module#GracieModule' },\n" +
                "\n" +
                "];\n" +
                "\n" +
                "export const routing: ModuleWithProviders = RouterModule.forRoot(routes);\n"

        assertEquals(expected, routingFileContent)
    }
}
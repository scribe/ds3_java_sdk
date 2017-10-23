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

import org.junit.Assert.assertEquals
import org.junit.Test

class UIRouteGenerator_Test {
    @Test
    fun testGeneratingAppRoutingContentWithOneRoute() {
        val uiRouteGenerator = UIRouteGeneratorImpl()
        val routingFileContent = uiRouteGenerator.generateRoutes(sequenceOf("search"))

        val expected = "<!--\n" +
                "* *****************************************************************************\n" +
                "*    Copyright 2014-2017 Spectra Logic Corporation. All Rights Reserved.\n" +
                "*    Licensed under the Apache License, Version 2.0 (the \"License\"). You may not use\n" +
                "*    this file except in compliance with the License. A copy of the License is located at\n" +
                "*\n" +
                "*    http://www.apache.org/licenses/LICENSE-2.0\n" +
                "*\n" +
                "*    or in the \"license\" file accompanying this file.\n" +
                "*    This file is distributed on an \"AS IS\" BASIS, WITHOUT WARRANTIES OR\n" +
                "*    CONDITIONS OF ANY KIND, either express or implied. See the License for the\n" +
                "*    specific language governing permissions and limitations under the License.\n" +
                "*  ****************************************************************************\n" +
                "-->\n" +
                "\n" +
                "import { ModuleWithProviders } from '@angular/core';\n" +
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
        val uiRouteGenerator = UIRouteGeneratorImpl()
        val routingFileContent = uiRouteGenerator.generateRoutes(sequenceOf("search", "Gracie"))

        val expected = "<!--\n" +
                "* *****************************************************************************\n" +
                "*    Copyright 2014-2017 Spectra Logic Corporation. All Rights Reserved.\n" +
                "*    Licensed under the Apache License, Version 2.0 (the \"License\"). You may not use\n" +
                "*    this file except in compliance with the License. A copy of the License is located at\n" +
                "*\n" +
                "*    http://www.apache.org/licenses/LICENSE-2.0\n" +
                "*\n" +
                "*    or in the \"license\" file accompanying this file.\n" +
                "*    This file is distributed on an \"AS IS\" BASIS, WITHOUT WARRANTIES OR\n" +
                "*    CONDITIONS OF ANY KIND, either express or implied. See the License for the\n" +
                "*    specific language governing permissions and limitations under the License.\n" +
                "*  ****************************************************************************\n" +
                "-->\n" +
                "\n" +
                "import { ModuleWithProviders } from '@angular/core';\n" +
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
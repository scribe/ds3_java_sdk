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

import org.junit.Assert
import org.junit.Test

class DynamicContentGenerator_Test {
    @Test
    fun testGeneratingModuleNotFoundPage() {
        val errorPageBackgroundColor = "cadetBlue"
        val errorPageTextColor = "white"
        val errorPageTitle = "Error page"
        val landingPageNotFoundErrorText = "We cannot locate our application page.  Please accept our apologies."

        val moduleNogtFoundPageText = DynamicContentGeneratorImpl()
                .resourceNotFoundContent(errorPageBackgroundColor, errorPageTextColor, errorPageTitle, landingPageNotFoundErrorText)

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
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <title>Error page</title>\n" +
                "        <style>\n" +
                "            body {\n" +
                "                background-color: cadetBlue;\n" +
                "                text-align: center;\n" +
                "                color: white\n" +
                "            }\n" +
                "        </style>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h1>We cannot locate our application page.  Please accept our apologies.</h1>\n" +
                "    </body>\n" +
                "</html>\n"

        Assert.assertEquals(expected, moduleNogtFoundPageText)
    }

}
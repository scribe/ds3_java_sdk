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
import com.google.common.collect.ImmutableMap
import com.spectralogic.escapepod.httpservice.UiModuleRegistration

internal class AppRoutingConfigurableValues(routingInfo: ImmutableMap<String, UiModuleRegistration>) {
    // These two properties need to be public so that the Freemarker template can use them.
    val root: ImmutableMap<String, Any>
    val pathInfoList: ImmutableList<PathInfo>

    init {
        val pathInfoListBuilder = ImmutableList.Builder<PathInfo>()
        routingInfo.forEach { routeInfo ->
            pathInfoListBuilder.add(PathInfo(routeInfo.value.routeName, routeInfo.value.routingTableEntry))
        }
        pathInfoList = pathInfoListBuilder.build()

        root = ImmutableMap.of("pathInfoList", pathInfoList)
    }
}

internal data class PathInfo(val linkText: String, val routeUrl: String)
package com.spectralogic.escapepod.webui

import com.google.common.collect.ImmutableMap
import com.spectralogic.escapepod.httpservice.UiModuleRegistration

interface UIRouteGenerator {
    fun generateRoutes(routingInfo: ImmutableMap<String, UiModuleRegistration>) : String
}
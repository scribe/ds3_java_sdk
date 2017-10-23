package com.spectralogic.escapepod.httpservice

interface UIRouteGenerator {
    fun generateRoutes(routeNames: Sequence<String>) : String
}
package com.spectralogic.escapepod.server

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.Server

class ServerModule : AbstractModule() {
    override fun configure() {
        bind(Server::class.java).to(EscapePodServer::class.java)
    }
}

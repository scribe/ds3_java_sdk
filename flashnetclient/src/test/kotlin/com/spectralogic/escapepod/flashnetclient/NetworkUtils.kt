package com.spectralogic.escapepod.flashnetclient

import java.net.ServerSocket

data class SocketPortTuple(val socket: ServerSocket?, val boundPort: Int)

fun bindToUnusedPort() : SocketPortTuple {
    val LOWEST_PORT_TO_BIND = 49152
    val HIGHEST_PORT_TO_BIND = 65535

    for (portNumber in LOWEST_PORT_TO_BIND..HIGHEST_PORT_TO_BIND) {
        try {
            val serverSocket = ServerSocket(portNumber)
            return SocketPortTuple(serverSocket, portNumber)
        } catch (throwable : Throwable) { }
    }

    return SocketPortTuple(null, 0)
}
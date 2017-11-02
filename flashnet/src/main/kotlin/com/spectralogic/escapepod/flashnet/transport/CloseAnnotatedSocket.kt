package com.spectralogic.escapepod.flashnet.transport

import org.slf4j.LoggerFactory
import java.net.Socket

class CloseAnnotatedSocket(host: String, port: Int) : Socket(host, port) {
    private companion object {
        private val LOG = LoggerFactory.getLogger(CloseAnnotatedSocket::class.java)
    }
    override fun close() {
        LOG.info("Socket was closed")
        super.close()
    }
}

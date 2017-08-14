package com.spectralogic.escapepod.flashnetclient

class FlashNetConfigImpl : FlashNetConfig {
    override fun portNumber(flashNetHost: String): Int? {
        return 49152;
    }

    override fun flashNetApiVersion(): String {
        return "1.0"
    }

    override fun flashNetSourceServer(): String {
        return "FlashNet-source-server"
    }

    override fun flashNetUserName(): String {
        return "FlashNet-user-name"
    }

    override fun flashNetCallingApplication(): String {
        return "FlashNet-calling-application"
    }
}
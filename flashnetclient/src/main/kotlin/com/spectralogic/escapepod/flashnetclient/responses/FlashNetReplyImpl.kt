package com.spectralogic.escapepod.flashnetclient.responses

import org.simpleframework.xml.core.Persister

class FlashNetReplyImpl : FlashNetReply {
    override fun fromResponsePayload(responsePayload: String): Reply {
        val serializer = Persister()
        return serializer.read(Reply::class.java, responsePayload)
    }
}
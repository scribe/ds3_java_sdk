package com.spectralogic.escapepod.flashnetclient.responses

import com.fasterxml.jackson.xml.XmlMapper

// TODO: Figure out how to handle unspecified values

class FlashNetReplyImpl : FlashNetReply {
    override fun fromResponsePayload(responsePayload: String): Reply {
        val xmlMapper = XmlMapper()
        return xmlMapper.readValue(responsePayload, Reply::class.java)
    }
}
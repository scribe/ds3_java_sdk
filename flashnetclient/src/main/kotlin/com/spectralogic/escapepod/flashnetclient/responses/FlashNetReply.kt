package com.spectralogic.escapepod.flashnetclient.responses

interface FlashNetReply {
    fun fromResponsePayload(responsePayload : String) : Reply
}
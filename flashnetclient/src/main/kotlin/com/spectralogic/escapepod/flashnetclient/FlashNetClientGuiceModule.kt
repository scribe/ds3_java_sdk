package com.spectralogic.escapepod.flashnetclient

import com.google.inject.AbstractModule
import com.google.inject.Singleton
import com.spectralogic.escapepod.flashnetclient.responses.FlashNetReplyFactory

class FlashNetClientGuiceModule : AbstractModule() {
    override fun configure() {
        bind(FlashNetReplyFactory::class.java).`in`(Singleton::class.java)
        bind(FlashNetConfig::class.java).to(FlashNetConfigImpl::class.java).`in`(Singleton::class.java)
    }
}

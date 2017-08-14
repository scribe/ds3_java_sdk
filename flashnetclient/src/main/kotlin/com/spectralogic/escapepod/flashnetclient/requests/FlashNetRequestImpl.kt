package com.spectralogic.escapepod.flashnetclient.requests

import com.google.common.base.Joiner
import com.google.inject.Inject
import com.spectralogic.escapepod.flashnetclient.FlashNetConfig
import org.simpleframework.xml.core.Persister
import java.io.ByteArrayOutputStream

class FlashNetRequestImpl @Inject constructor(private val flashNetConfig: FlashNetConfig) : FlashNetRequest
{
    override fun toMigrateAssetsRequest(migrate: Migrate): String {
        val request = Request(flashNetConfig.flashNetApiVersion(),
                flashNetConfig.flashNetSourceServer(),
                flashNetConfig.flashNetUserName(),
                flashNetConfig.flashNetCallingApplication(),
                "MigrateAssets",
                Migrate = migrate)
        return makeFlashNetRequestPayload(request)
    }

    private fun makeFlashNetRequestPayload(request : Request) : String {
        val byteArrayOutputStream = ByteArrayOutputStream()

        byteArrayOutputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>".toByteArray())

        val xmlPersister = Persister()
        xmlPersister.write(request, byteArrayOutputStream)

        val requestPayload = byteArrayOutputStream.toString()

        return Joiner.on(" ").join("FlashNet XML", requestPayload.length, requestPayload)
    }
}
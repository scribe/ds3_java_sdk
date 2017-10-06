package com.spectralogic.escapepod.avidpamwsclient

import com.spectralogic.ds3client.helpers.MetadataAccess
import com.spectralogic.escapepod.api.AvidPamWsClient
import org.slf4j.LoggerFactory

class PamMetadataAccess : MetadataAccess {

    private var metadata : MutableMap<String, MutableMap<String, String>> = mutableMapOf()

    private companion object {
        private val LOG = LoggerFactory.getLogger(AvidPamWsClient::class.java)
    }

    override fun getMetadataValue(fileName: String): MutableMap<String, String> {
        val res = metadata[fileName]
        if (res == null) {
            LOG.warn("No metadata found for asset '$fileName'.")
            return mutableMapOf()
        }

        return res
    }

    public fun addMedataValue(fileName: String, metadataValue: MutableMap<String, String>) {
        metadata.put(fileName, metadataValue)
    }
}
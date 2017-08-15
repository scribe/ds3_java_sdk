package com.spectralogic.escapepod.flashnetclient.requests

interface FlashNetRequest {
    fun toMigrateAssetsRequest(migrate: Migrate) : String
    fun toStatusRequest(status: Status) : String
}
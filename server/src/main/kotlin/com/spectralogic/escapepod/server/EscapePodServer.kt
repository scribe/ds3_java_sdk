package com.spectralogic.escapepod.server

import com.spectralogic.escapepod.api.DiskCache
import com.spectralogic.escapepod.api.Server
import javax.inject.Inject

class EscapePodServer @Inject constructor(private val cache: DiskCache) : Server {
    override fun run() {
        println("Cache size " + cache.totalSize)
    }
}

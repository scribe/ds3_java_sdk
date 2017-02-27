package com.spectralogic.escapepod.cache

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.DiskCache

class CacheModule : AbstractModule() {
    override fun configure() {
        bind(DiskCache::class.java).to(LocalDiskCache::class.java)
    }

}

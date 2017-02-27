package com.spectralogic.escapepod.cache

import com.spectralogic.escapepod.api.DiskCache

internal class LocalDiskCache : DiskCache {

    private var size : Long = 0

    override val totalSize: Long
        get() = size
    override val allocatedSize: Long
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val totalUsed: Long
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun filesInCache(): Sequence<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

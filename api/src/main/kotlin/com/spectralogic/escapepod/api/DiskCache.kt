package com.spectralogic.escapepod.api

interface DiskCache {

    val totalSize : Long
    val allocatedSize : Long
    val totalUsed : Long

    fun filesInCache() : Sequence<String>
}

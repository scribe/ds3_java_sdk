package com.greyrock.escapepod.util

interface ResourceProvider<T> {
    fun loadResource() : T
    fun setResource(resource : T) : Unit
}

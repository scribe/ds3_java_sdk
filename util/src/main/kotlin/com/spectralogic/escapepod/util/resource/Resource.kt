package com.spectralogic.escapepod.util.resource

interface Resource<T> {
    fun getResource(): T?
    fun saveResource(resource : T)
    fun deleteResource()
}

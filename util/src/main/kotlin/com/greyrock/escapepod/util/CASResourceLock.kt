package com.greyrock.escapepod.util

class CASResourceLock<T : Any>(private val resourceProvider: ResourceProvider<T?>) {

    private val resourceLock = ResourceLock()

    fun getResource() : ResourceResult<T?> {
        val resource : T? = resourceLock.readLock{
            resourceProvider.loadResource()
        }

        return ResourceResult(resource, getCASFromResource(resource))
    }

    fun setResource(resource : T, cas: Int) {
        resourceLock.writeLock {
            val (currentResource, currentCas) = this.getResource()

            currentResource.ifNotNull {
                if (currentCas != cas) {
                    throw CASMismatchException(currentCas)
                }
            }

            resourceProvider.setResource(resource)
        }
    }

    private fun getCASFromResource(resource: T?) : Int {
        if (resource != null) {
            return resource.hashCode()
        } else {
            return 0
        }
    }
}

data class ResourceResult<out T : Any?>(val resource : T, val cas : Int)

class CASMismatchException(cas: Int) : Exception("The cas number provided does not match the current one of $cas")
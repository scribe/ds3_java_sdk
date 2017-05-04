package com.greyrock.escapepod.util.resource

/**
 * A ResourceProvider is responsible for Marshalling and Un-Marshalling a Resource.
 *
 * A ResourceProvider should not be concerned with locking or with if the streams exist.
 */
interface ResourceMarshaller<T> {
    fun saveResource(resource : T, outStream : java.io.OutputStream) : Unit
    fun loadResource(inStream: java.io.InputStream) : T
}

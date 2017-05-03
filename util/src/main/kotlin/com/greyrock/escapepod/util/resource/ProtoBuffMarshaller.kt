package com.greyrock.escapepod.util.resource

import com.google.protobuf.Message
import java.io.InputStream
import java.io.OutputStream

class ProtoBuffMarshaller<T : Message>(
        private val builderFunction : () -> com.google.protobuf.Message.Builder
) : ResourceMarshaller<T> {
    override fun saveResource(resource: T, outStream: OutputStream) {
        resource.writeTo(outStream)
    }

    override fun loadResource(inStream: InputStream): T {
        return builderFunction.invoke().mergeFrom(inStream).build() as T
    }
}

/*
 * ****************************************************************************
 *    Copyright 2014-2017 Spectra Logic Corporation. All Rights Reserved.
 *    Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *    this file except in compliance with the License. A copy of the License is located at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *    or in the "license" file accompanying this file.
 *    This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *    CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *    specific language governing permissions and limitations under the License.
 *  ****************************************************************************
 */

package com.spectralogic.escapepod.flashnet.responses

import io.reactivex.Single
import kotlin.reflect.KClass

class FlashNetReplyImpl(private val reply : Reply) : FlashNetReply {
    private companion object {
        const val SUCCESS_VALUE = "passed"
    }

    override val Version: String?
        get() = reply.Version
    override val Status: String?
        get() = reply.Status
    override val Error: String?
        get() = reply.Error
    override val RequestId: Int?
        get() = reply.RequestId

    override fun toStatusReply() : Single<StatusInfo> {
        return toFlashNetReply(StatusInfo::class)
    }

    private fun <T : Any> toFlashNetReply(replyType : KClass<T>) : Single<T> {
        if (failed()) {
            return Single.error(FlashNetResponseException(reply.Error ?: ""))
        }

        return Single.create( { emitter ->
            try {
                val flashNetReply : T? = replyForType(replyType)
                emitter.onSuccess(flashNetReply!!)
            } catch (throwable : Throwable) {
                emitter.onError(FlashNetResponseException(throwable.message ?: ""))
            }
        })
    }

    private fun failed() : Boolean {
        return reply.Status?.toLowerCase() != SUCCESS_VALUE
    }

    private fun <T : Any> replyForType(replyType : KClass<T>) : T? {
        return when (replyType) {
            StatusInfo::class -> reply.StatusInfo as T
            GroupDetails::class -> reply.GroupDetails as T
            else -> null
        }
    }

    override fun toListGroupReply(): Single<GroupDetails> {
        return toFlashNetReply(GroupDetails::class)
    }
}

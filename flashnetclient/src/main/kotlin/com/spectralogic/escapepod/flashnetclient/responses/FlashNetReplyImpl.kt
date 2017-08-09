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

package com.spectralogic.escapepod.flashnetclient.responses

import io.reactivex.Observable
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

    override fun toStatusReply() : Observable<StatusInfo> {
        return toFlashNetReply(StatusInfo::class)
    }

    private fun <T : Any> toFlashNetReply(replyType : KClass<T>) : Observable<T> {
        if (failed()) {
            return Observable.create { emitter ->
                emitter.onError(FlashNetResponseException(reply.Error ?: ""))
            }
        }

        var flashNetReply : T? = null

        return Observable.create( { emitter ->
            try {
                when (replyType) {
                    StatusInfo::class -> flashNetReply = reply.StatusInfo as T
                    GroupDetails::class -> flashNetReply = reply.GroupDetails as T
                }

                emitter.onNext(flashNetReply!!)
                emitter.onComplete()
            } catch (throwable : Throwable) {
                emitter.onError(FlashNetResponseException(throwable.message ?: ""))
            }
        })
    }

    private fun failed() : Boolean {
        return reply.Status?.toLowerCase() != SUCCESS_VALUE
    }

    override fun toListGroupReply(): Observable<GroupDetails> {
        return toFlashNetReply(GroupDetails::class)
    }
}
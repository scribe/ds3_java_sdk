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
import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element

data class Reply(@field:Attribute(name = "Version", required = false)
                 @param:Attribute(name = "Version", required = false)
                 val Version : String?,

                 @field:Attribute(name = "Status", required = false)
                 @param:Attribute(name = "Status", required = false)
                 val Status : String?,

                 @field:Attribute(name = "Error", required = false)
                 @param:Attribute(name = "Error", required = false)
                 val Error : String?,

                 @field:Attribute(name = "RequestId", required = false)
                 @param:Attribute(name = "RequestId", required = false)
                 val RequestId : Int?,

                 @field:Element(name = "StatusInfo", required = false)
                 @param:Element(name = "StatusInfo", required = false)
                 val StatusInfo : StatusInfo?)
{
    private companion object {
        const val SUCCESS_VALUE = "Passed"
    }

    fun toStatusInfo() : Observable<StatusInfo> {
        if (failed()) {
            return Observable.create { emitter ->
                emitter.onError(FlashNetResponseException(Error ?: ""))
            }
        }

        return Observable.create( { emitter ->
            try {
                emitter.onNext(StatusInfo!!)
                emitter.onComplete()
            } catch (throwable : Throwable) {
                emitter.onError(throwable)
            }
        })
    }

    fun failed() : Boolean {
        return Status == SUCCESS_VALUE
    }
}

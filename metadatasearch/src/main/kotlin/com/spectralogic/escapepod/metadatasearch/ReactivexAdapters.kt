/*
 * *****************************************************************************
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

package com.spectralogic.escapepod.metadatasearch

import com.spectralogic.escapepod.api.MetadataException
import io.reactivex.*
import org.elasticsearch.client.ResponseException

internal object ReactivexAdapters {
    fun <T> createSingle(body: (SingleEmitter<T>) -> Unit): Single<T> {
        return Single.create { emitter ->
            try {
                body.invoke(emitter)
            } catch (ex: ResponseException) {
                emitter.onError(MetadataException(ex.response.statusLine.statusCode,
                        ex.response.statusLine.reasonPhrase, ex))
            } catch (ex: Exception) {
                emitter.onError(ex)
            }
        }
    }

    fun createCompletable(body: (CompletableEmitter) -> Unit): Completable {
        return Completable.create { emitter ->
            try {
                body.invoke(emitter)
            } catch (ex: ResponseException) {
                emitter.onError(MetadataException(ex.response.statusLine.statusCode,
                        ex.response.statusLine.reasonPhrase, ex))
            } catch (ex: Exception) {
                emitter.onError(ex)
            }
        }
    }

    fun <T> createObservable(body: (ObservableEmitter<T>) -> Unit): Observable<T> {
        return Observable.create { emitter ->
            try {
                body.invoke(emitter)
            } catch (ex: ResponseException) {
                emitter.onError(MetadataException(ex.response.statusLine.statusCode,
                        ex.response.statusLine.reasonPhrase, ex))
            } catch (ex: Exception) {
                emitter.onError(ex)
            }
        }
    }
}

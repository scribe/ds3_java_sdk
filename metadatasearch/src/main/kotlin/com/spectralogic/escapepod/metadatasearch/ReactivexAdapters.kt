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

package com.spectralogic.escapepod.metadatasearch.api

import com.spectralogic.escapepod.api.MetadataSearchService
import io.reactivex.Completable

internal interface ElasticSearchMetadataService : MetadataSearchService {

    /***
     * Close the connection to the underline search provider
     */
    fun closeConnection(): Completable
}


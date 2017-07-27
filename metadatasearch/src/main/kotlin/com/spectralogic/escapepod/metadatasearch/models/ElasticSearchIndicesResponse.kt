package com.spectralogic.escapepod.metadatasearch.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

internal data class ElasticSearchIndicesResponse @JsonCreator constructor(val indices: List<ElasticSearchIndex>)

internal data class ElasticSearchIndex @JsonCreator constructor(
        @JsonProperty("index")
        val indexName: String,

        @JsonProperty("pri")
        val primaries: Int,

        @JsonProperty("rep")
        val replications: Int,

        @JsonProperty("docs.count")
        val numberOfDocuments: Long)
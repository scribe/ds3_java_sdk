package com.spectralogic.escapepod.metadatasearch.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class ElasticSearchResponse @JsonCreator constructor(
        @JsonProperty("hits")
        val hits: ElasticSearchHits)

data class ElasticSearchHits @JsonCreator constructor(
        @JsonProperty("hits")
        val hits: List<ElasticSearchHitsNode>)

data class ElasticSearchHitsNode @JsonCreator constructor(
        @JsonProperty("_index")
        val index: String,

        @JsonProperty("_type")
        val type: String,

        @JsonProperty("_id")
        val id: String,

        @JsonProperty("_score")
        val score: Double,

        @JsonProperty("_source")
        val source: Map<String, String>)

package com.spectralogic.escapepod.metadatasearch.modle

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class ElasticSearchHealthResponse @JsonCreator constructor(
        @JsonProperty("cluster_name")
        val clusterName: String,

        @JsonProperty("status")
        val status: String)

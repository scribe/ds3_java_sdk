package com.spectralogic.escapepod.metadatasearch.models

import com.fasterxml.jackson.annotation.JsonCreator

data class ElasticSearchIndicesResponse @JsonCreator constructor(val indices: List<ElasticSearchIndex>)

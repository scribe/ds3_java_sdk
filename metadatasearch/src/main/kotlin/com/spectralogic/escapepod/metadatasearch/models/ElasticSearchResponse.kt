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

package com.spectralogic.escapepod.metadatasearch.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

internal data class ElasticSearchResponse @JsonCreator constructor(
        @JsonProperty("hits")
        val hits: ElasticSearchHits)

internal data class ElasticSearchHits @JsonCreator constructor(
        @JsonProperty("hits")
        val hits: List<ElasticSearchHitsNode>)

internal data class ElasticSearchHitsNode @JsonCreator constructor(
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

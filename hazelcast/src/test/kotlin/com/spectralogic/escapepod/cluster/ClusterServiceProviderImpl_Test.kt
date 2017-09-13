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

package com.spectralogic.escapepod.cluster

import com.spectralogic.escapepod.api.RequestContext
import com.spectralogic.escapepod.api.use
import com.spectralogic.escapepod.cluster.config.ClusterConfigService
import io.opentracing.mock.MockTracer
import io.reactivex.Single
import org.junit.Test

import org.mockito.Mockito.*
import org.assertj.core.api.Assertions.*
import java.util.NoSuchElementException

class ClusterServiceProviderImpl_Test {
    @Test
    fun startService() {

        val clusterConfigService = mock(ClusterConfigService::class.java)
        `when`(clusterConfigService.getConfig()).thenReturn(Single.error(NoSuchElementException()))

        val clusterClientFactory = mock(ClusterClientFactory::class.java)

        ClusterServiceProviderImpl("localhost", 5055, clusterConfigService, clusterClientFactory).use {
            it.startService().blockingAwait()

            assertThat(it.getService(stubRequestContext())).isNotNull()
        }
    }
}

fun stubRequestContext(): RequestContext {

    val mockTracer = MockTracer()
    val span = mockTracer.buildSpan("test").startActive()

    return RequestContext(mockTracer, span)
}
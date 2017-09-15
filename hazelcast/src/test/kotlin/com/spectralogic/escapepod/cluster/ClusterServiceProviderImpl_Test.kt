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

import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.cluster.config.ClusterConfig
import com.spectralogic.escapepod.cluster.config.ClusterConfigService
import com.spectralogic.escapepod.cluster.config.NodeUrl
import com.spectralogic.escapepod.testutils.VerifyMatchers
import io.opentracing.mock.MockTracer
import io.reactivex.Single
import io.vavr.collection.List
import org.junit.Test

import org.mockito.Mockito.*
import org.assertj.core.api.Assertions.*
import org.mockito.ArgumentMatchers
import java.util.*
import java.util.concurrent.atomic.AtomicBoolean

class ClusterServiceProviderImpl_Test {
    @Test
    fun startService() {

        val clusterConfigService = mock(ClusterConfigService::class.java)
        `when`(clusterConfigService.getConfig()).thenReturn(Single.error(NoSuchElementException()))

        val clusterClientFactory = mock(ClusterClientFactory::class.java)

        ClusterServiceProviderImpl("127.0.0.1", 5055, clusterConfigService, clusterClientFactory).use {
            it.startService().blockingAwait()

            assertThatThrownBy{
                it.getService(stubRequestContext()).blockingGet()
            }.isExactlyInstanceOf(ClusterException::class.java)
                    .hasMessage("The server must be a member of a cluster")
        }

        verify(clusterConfigService, times(1)).getConfig()
    }

    @Test
    fun createCluster() {
        val clusterConfigService = mock(ClusterConfigService::class.java)
        `when`(clusterConfigService.getConfig()).thenReturn(Single.error(NoSuchElementException()))

        val clusterClientFactory = mock(ClusterClientFactory::class.java)

        val clusterCreatedEventFired = AtomicBoolean(false)
        val clusterShutdownEventFired = AtomicBoolean(false)

        ClusterServiceProviderImpl("127.0.0.1", 5055, clusterConfigService, clusterClientFactory).use {
            it.startService().blockingAwait()

            it.clusterLifecycleEvents().doOnNext {
                when(it) {
                    is ClusterCreatedEvent -> clusterCreatedEventFired.set(true)
                    is ClusterShutdownEvent -> clusterShutdownEventFired.set(true)
                }
            }.subscribe()

            it.createCluster("test").blockingAwait()

            assertThat(clusterCreatedEventFired).isTrue

            val clusterService = it.getService(stubRequestContext()).blockingGet()

            assertThat(clusterService.name().blockingGet()).isEqualTo("test")
        }

        assertThat(clusterShutdownEventFired).isTrue

        verify(clusterConfigService, times(1)).createConfig(ArgumentMatchers.anyString(), VerifyMatchers.any())
    }

    @Test
    fun joinCluster() {
        val clusterConfigService = mock(ClusterConfigService::class.java)
        `when`(clusterConfigService.getConfig()).thenReturn(Single.error(NoSuchElementException()))

        val clusterClientFactory = mock(ClusterClientFactory::class.java)

        val clusterClient = mock(ClusterClient::class.java)
        `when`(clusterClient.clusterName()).thenReturn(Single.just("test"))

        `when`(clusterClientFactory.createClusterClient("127.0.0.1")).thenReturn(clusterClient)

        val nodeJoinedClusterEventFired = AtomicBoolean(false)
        val nodeLeftClusterEventFired = AtomicBoolean(false)

        ClusterServiceProviderImpl("127.0.0.1", 5055, clusterConfigService, clusterClientFactory).use {

            it.clusterLifecycleEvents().doOnNext {
                when (it) {
                    is ClusterNodeJoinedEvent -> nodeJoinedClusterEventFired.set(true)
                    is ClusterNodeLeftEvent -> nodeLeftClusterEventFired.set(true)
                }
            }.subscribe()

            it.startService().blockingAwait()

            it.createCluster("test").blockingAwait()

            val joinedClusterEvent = AtomicBoolean(false)
            val leftClusterEvent = AtomicBoolean(false)

            val secondClusterConfigService = mock(ClusterConfigService::class.java)
            `when`(secondClusterConfigService.getConfig()).thenReturn(Single.error(NoSuchElementException()))

            ClusterServiceProviderImpl("127.0.0.1", 5056, secondClusterConfigService, clusterClientFactory).use {
                it.clusterLifecycleEvents().doOnNext {
                    when (it) {
                        is ClusterJoinedEvent -> joinedClusterEvent.set(true)
                        is ClusterLeftEvent -> leftClusterEvent.set(true)
                    }
                }.subscribe()
                val clusterName = it.joinCluster("127.0.0.1").blockingGet()
                assertThat(clusterName).isEqualTo("test")

                assertThat(nodeJoinedClusterEventFired).isTrue
                assertThat(joinedClusterEvent).isTrue

                it.leaveCluster().blockingAwait()
                assertThat(leftClusterEvent).isTrue
            }
            assertThat(nodeLeftClusterEventFired).isTrue
            it.leaveCluster().blockingAwait()
            verify(secondClusterConfigService, times(1)).deleteConfig()
        }

        verify(clusterConfigService, times(1)).addNode(VerifyMatchers.any())
        verify(clusterConfigService, times(1)).deleteConfig()
    }

    @Test
    fun resumeCluster() {
        val clusterConfigService = mock(ClusterConfigService::class.java)

        val clusterConfig = ClusterConfig("test", UUID.randomUUID(), List.empty())

        `when`(clusterConfigService.getConfig()).thenReturn(Single.just(clusterConfig))

        val clusterClientFactory = mock(ClusterClientFactory::class.java)

        val clusterStartupEventFired = AtomicBoolean(false)

        ClusterServiceProviderImpl("127.0.0.1", 5055, clusterConfigService, clusterClientFactory).use {
            it.clusterLifecycleEvents().doOnNext {
                when(it) {
                    is ClusterStartupEvent -> clusterStartupEventFired.set(true)
                }
            }.subscribe()

            it.startService().blockingAwait()

            assertThat(it.getService(stubRequestContext()).blockingGet()).isNotNull()
            assertThat(clusterStartupEventFired).isTrue
        }
    }

    @Test
    fun rejoinOnStartup() {
        val parentClusterConfigService = mock(ClusterConfigService::class.java)
        `when`(parentClusterConfigService.getConfig()).thenReturn(Single.error(NoSuchElementException()))

        val firstClusterClientFactory = mock(ClusterClientFactory::class.java)

        ClusterServiceProviderImpl("127.0.0.1", 5055, parentClusterConfigService, firstClusterClientFactory).use {
            it.startService().blockingAwait()

            it.createCluster("test").blockingAwait()

            val secondaryClusterConfigService = mock(ClusterConfigService::class.java)
            val clusterConfig = ClusterConfig("test", UUID.randomUUID(), List.of(NodeUrl("127.0.0.1", 5055)))

            `when`(secondaryClusterConfigService.getConfig()).thenReturn(Single.just(clusterConfig))

            val clusterClientFactory = mock(ClusterClientFactory::class.java)
            val clusterClient = mock(ClusterClient::class.java)
            `when`(clusterClient.clusterName()).thenReturn(Single.just("test"))
            `when`(clusterClientFactory.createClusterClient("127.0.0.1:5055")).thenReturn(clusterClient)

            val clusterStartupEventFired = AtomicBoolean(false)
            ClusterServiceProviderImpl("127.0.0.1", 5056, secondaryClusterConfigService, clusterClientFactory).use {
                it.clusterLifecycleEvents().doOnNext {
                    when(it) {
                        is ClusterStartupEvent -> clusterStartupEventFired.set(true)
                    }
                }.subscribe()

                it.startService().blockingAwait()

                assertThat(clusterStartupEventFired).isTrue

                val clusterService = it.getService(stubRequestContext()).blockingGet()
                assertThat(clusterService.name().blockingGet()).isEqualTo("test")
            }
        }
    }

    @Test
    fun leaveFromNonExistentCluster() {
        val clusterConfigService = mock(ClusterConfigService::class.java)
        `when`(clusterConfigService.getConfig()).thenReturn(Single.error(NoSuchElementException()))
        val clusterClientFactory = mock(ClusterClientFactory::class.java)

        ClusterServiceProviderImpl("127.0.0.1", 5055, clusterConfigService, clusterClientFactory).use {
             it.startService().blockingAwait()

            assertThatThrownBy { it.leaveCluster().blockingAwait() }
                    .isExactlyInstanceOf(ClusterException::class.java)
                    .hasMessage("The server must be a member of a cluster")
         }
    }
}

fun stubRequestContext(): RequestContext {

    val mockTracer = MockTracer()
    val span = mockTracer.buildSpan("test").startActive()

    return RequestContext(mockTracer, span)
}


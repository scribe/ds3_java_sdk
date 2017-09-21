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

package com.spectralogic.escapepod.util.resource

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

class ResourceLock_Test {

    @Test
    fun singleThreadSet() {
        val resourceLock = ResourceLock()

        var enteredWriteLock = false

        resourceLock.writeLock { enteredWriteLock = true }

        assertThat(enteredWriteLock).isTrue()

        assertThat(resourceLock.readLock { true }).isTrue()
    }

    @Test
    fun verifyReentrantBehavior() {
        val resourceLock = ResourceLock()

        var enteredWriteLock = false

        resourceLock.writeLock {
            enteredWriteLock = resourceLock.readLock {
                true
            }
        }

        assertThat(enteredWriteLock).isTrue()
    }

    @Test
    fun multipleThreadsAccessRead() {
        val resourceLock = ResourceLock()

        val countDownLatch = CountDownLatch(1)

        thread {
            resourceLock.readLock {
                assertThat(countDownLatch.await(200, TimeUnit.MILLISECONDS)).isTrue()
            }
        }

        thread {
            resourceLock.readLock {
                countDownLatch.countDown()
            }
        }

        assertThat(countDownLatch.await(300, TimeUnit.MILLISECONDS)).isTrue()
    }

    @Test
    fun verifyWriteBlocksRead() {
        val resourceLock = ResourceLock()

        val blockReadEntry = CountDownLatch(1)

        val writeBlock = CountDownLatch(1)
        val writeCompletion = CountDownLatch(1)

        thread {
            resourceLock.writeLock {
                blockReadEntry.countDown()
                assertThat(writeBlock.await(100, TimeUnit.MILLISECONDS)).isFalse() // inverting this assert should cause the test to fail
                writeCompletion.countDown()
            }
        }

        thread {
            blockReadEntry.await()
            resourceLock.readLock {
                writeBlock.countDown()
            }
        }

        assertThat(writeBlock.await(300, TimeUnit.MILLISECONDS)).isTrue()
        assertThat(writeCompletion.await(300, TimeUnit.MILLISECONDS)).isTrue()
    }
}
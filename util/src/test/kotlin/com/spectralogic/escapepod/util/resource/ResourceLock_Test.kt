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

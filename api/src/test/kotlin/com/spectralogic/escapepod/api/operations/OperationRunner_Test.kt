package com.spectralogic.escapepod.api.operations

import com.google.inject.Guice
import com.spectralogic.escapepod.api.ApiGuiceModule
import org.junit.Assert.*
import org.junit.Test
import java.util.concurrent.CountDownLatch

class OperationRunner_Test {
    @Test
    fun testCallingOperationReturningNull() {
        val operationReturningNull = object : Operation<Unit?> {
            override fun call(): Unit? {
                return null
            }
        }

        var failure : Throwable? = null

        val countDownLatch = CountDownLatch(1)

        val operationRunner = OperationRunnerImpl()
        val operationObserver = operationRunner.addAndRunOperation(operationReturningNull)
        operationObserver.subscribe(
                { _ ->
                    countDownLatch.countDown()
                },
                { throwable ->
                    failure = throwable
                    countDownLatch.countDown()
                },
                {
                    countDownLatch.countDown()
                }
        )

        countDownLatch.await()

        if (failure != null) {
            fail(failure?.message)
        }
    }

    @Test
    fun testOperationThatThrows() {
        var operationOnErrorCalled = false

        val operationThatThrows = object : Operation<Unit?> {
            override fun call(): Unit? {
                throw NullPointerException()
            }

            override fun onError(t: Throwable) {
                super.onError(t)
                operationOnErrorCalled = true
            }
        }

        var failure : Throwable? = null

        val countDownLatch = CountDownLatch(1)

        val operationRunner = OperationRunnerImpl()
        val operationObserver = operationRunner.addAndRunOperation(operationThatThrows)
        operationObserver.subscribe(
                { _ ->
                    countDownLatch.countDown()
                },
                { throwable ->
                    failure = throwable
                    countDownLatch.countDown()
                },
                {
                    countDownLatch.countDown()
                }
        )

        countDownLatch.await()

        assertTrue(operationOnErrorCalled)
        assertFalse(failure == null)
        assertTrue(failure is NullPointerException)
    }

    @Test
    fun testThatOperationPropagatesCorrectValue() {
        val expectedValue = 85

        val operationReturningInt = object : Operation<Int> {
            override fun call(): Int {
                return expectedValue
            }
        }

        val countDownLatch = CountDownLatch(1)

        var operationResult = 0

        val operationRunner = OperationRunnerImpl()
        val operationObserver = operationRunner.addAndRunOperation(operationReturningInt)
        operationObserver.subscribe(
                { result ->
                    operationResult = result
                    countDownLatch.countDown()
                },
                { _ ->
                    countDownLatch.countDown()
                },
                {
                    countDownLatch.countDown()
                }
        )

        countDownLatch.await()

        assertEquals(expectedValue, operationResult)
    }

    @Test
    fun testOperationCompleteCalled() {
        var onComplleteCalled = false

        val operationReturningNull = object : Operation<Unit?> {
            override fun call(): Unit? {
                return null
            }

            override fun onComplete(result: Unit?) {
                super.onComplete(result)
                assertNull(result)
                onComplleteCalled = true
            }
        }

        val countDownLatch = CountDownLatch(1)

        val operationRunner = OperationRunnerImpl()
        val operationObserver = operationRunner.addAndRunOperation(operationReturningNull)
        operationObserver.subscribe(
                { _ ->
                    countDownLatch.countDown()
                },
                { _ ->
                    countDownLatch.countDown()
                },
                {
                    countDownLatch.countDown()
                }
        )

        countDownLatch.await()

        assertTrue(onComplleteCalled)
    }

    @Test
    fun testCacelCalled() {
        var canceled = false

        val canceledOperation = object : Operation<Int> {
            override fun call(): Int {
                return 1
            }

            override fun cancel() {
                super.cancel()
                canceled = true
            }
        }

        val countDownLatch = CountDownLatch(1)

        val operationRunner = OperationRunnerImpl()
        val operationObserver = operationRunner.addAndRunOperation(canceledOperation)
        operationObserver.subscribe(
                { _ ->
                    canceledOperation.cancel()
                    countDownLatch.countDown()
                },
                { _ ->
                    countDownLatch.countDown()
                },
                {
                    countDownLatch.countDown()
                }
        )

        countDownLatch.await()

        assertTrue(canceled)
    }

    @Test
    fun testRunningOnCallingThread() {
        val callingThread = Thread.currentThread()

        val operationReturningInt = object : Operation<Int> {
            override fun call(): Int {
                return 1
            }
        }

        var operationThread : Thread? = null

        val operationRunner = OperationRunnerImpl()
        val operationObserver = operationRunner.addAndRunOperation(operationReturningInt, OperationResultReporterThread.CALLING_THREAD)
        operationObserver.subscribe(
                { _ ->
                    operationThread = Thread.currentThread()
                },
                { throwable ->
                    fail(throwable.message)
                }
        )

        assertEquals(callingThread, operationThread)
    }

    @Test
    fun testRunningOnSomeOtherThread() {
        val callingThread = Thread.currentThread()

        val operationReturningInt = object : Operation<Int> {
            override fun call(): Int {
                return 1
            }
        }

        val countDownLatch = CountDownLatch(1)

        var operationThread : Thread? = null

        val injector = Guice.createInjector(ApiGuiceModule())

        val operationRunner = injector.getInstance(OperationRunner::class.java)

        val operationObserver = operationRunner.addAndRunOperation(operationReturningInt)
        operationObserver.subscribe(
                { result ->
                    operationThread = Thread.currentThread()
                    countDownLatch.countDown()
                },
                { throwable ->
                    fail(throwable.message)
                }
        )

        countDownLatch.await()

        assertNotEquals(callingThread, operationThread)
    }
}

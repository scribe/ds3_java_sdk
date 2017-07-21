/*
 * ****************************************************************************
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

package com.spectralogic.escapepod.api.operations

import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import org.junit.Assert.*
import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors

class OperationRunner_Test {
    @Test
    fun testCallingOperationReturningNull() {
        var failure : Throwable? = null

        val operationReturningNull = object : Operation<Unit?> {
            override fun call(): Unit? {
                return null
            }

            override fun onError(t: Throwable) {
                super.onError(t)
                failure = t
            }
        }

        val countDownLatch = CountDownLatch(1)

        val operationRunner = OperationRunnerImpl(Executors.newSingleThreadExecutor())
        val operationObserver = operationRunner.runOperation(operationReturningNull)
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

        assertNull(failure)
    }

    @Test
    fun testCallingOperationReturningNothing() {
        var failure : Throwable? = null

        var numTimesCallCalled = 0

        val operationReturningNull = object : Operation<Unit> {
            override fun call(): Unit {
                ++numTimesCallCalled
                return
            }

            override fun onError(t: Throwable) {
                super.onError(t)
                failure = t
            }
        }

        val countDownLatch = CountDownLatch(1)

        val operationRunner = OperationRunnerImpl(Executors.newSingleThreadExecutor())
        val operationObserver = operationRunner.runOperation(operationReturningNull)
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

        assertEquals(1, numTimesCallCalled)
        assertNull(failure)
    }

    @Test
    fun testOperationThatThrows() {
        var operationOnErrorCalled = false
        var failure : Throwable? = null
        var numFailures = 0

        val operationThatThrows = object : Operation<Unit?> {
            override fun call(): Unit? {
                throw NullPointerException()
            }

            override fun onError(t: Throwable) {
                super.onError(t)
                failure = t
                operationOnErrorCalled = true
                ++numFailures
            }
        }

        val countDownLatch = CountDownLatch(1)

        val operationRunner = OperationRunnerImpl(Executors.newSingleThreadExecutor())
        val operationObserver = operationRunner.runOperation(operationThatThrows)
        operationObserver.subscribe(
                { _ ->
                    countDownLatch.countDown()
                },
                { _ ->
                    ++numFailures
                    countDownLatch.countDown()
                },
                {
                    countDownLatch.countDown()
                }
        )

        countDownLatch.await()

        assertTrue(operationOnErrorCalled)
        assertNotNull(failure)
        assertTrue(failure is NullPointerException)
        assertEquals(2, numFailures)
    }

    @Test
    fun testThatOperationPropagatesCorrectValue() {
        val expectedValue = 85

        var failure : Throwable? = null

        val operationReturningInt = object : Operation<Int> {
            override fun call(): Int {
                return expectedValue
            }

            override fun onError(t: Throwable) {
                super.onError(t)
                failure = t
            }
        }

        val countDownLatch = CountDownLatch(1)

        var operationResult = 0


        val operationRunner = OperationRunnerImpl(Executors.newSingleThreadExecutor())
        val operationObserver = operationRunner.runOperation(operationReturningInt)
        operationObserver.subscribe(
                { result ->
                    operationResult = result
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

        assertEquals(expectedValue, operationResult)
        assertNull(failure)
    }

    @Test
    fun testOperationCompleteCalled() {
        var onCompleteCalled = false
        var failure : Throwable? = null

        val operationReturningNull = object : Operation<Unit?> {
            override fun call(): Unit? {
                return null
            }

            override fun onError(t: Throwable) {
                super.onError(t)
                failure = t
            }

            override fun onComplete(result: Unit?) {
                super.onComplete(result)
                assertNull(result)
                onCompleteCalled = true
            }
        }

        val countDownLatch = CountDownLatch(1)

        val operationRunner = OperationRunnerImpl(Executors.newSingleThreadExecutor())
        val operationObserver = operationRunner.runOperation(operationReturningNull)
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

        assertNull(failure)
        assertTrue(onCompleteCalled)
    }

    @Test
    fun testCancelCalled() {
        var canceled = false

        var failure : Throwable? = null

        val canceledOperation = object : Operation<Int> {
            override fun call(): Int {
                return 1
            }

            override fun onError(t: Throwable) {
                super.onError(t)
                failure = t
            }

            override fun cancel() {
                super.cancel()
                canceled = true
            }
        }

        val countDownLatch = CountDownLatch(1)

        val operationRunner = OperationRunnerImpl(Executors.newSingleThreadExecutor())
        val operationObserver = operationRunner.runOperation(canceledOperation)
        operationObserver.subscribe(
                { _ ->
                    canceledOperation.cancel()
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

        assertNull(failure)
        assertTrue(canceled)
    }

    @Test
    fun test2operations() {
        val expectedValue = 85

        var failure : Throwable? = null

        val operationReturningInt = object : Operation<Int> {
            override fun call(): Int {
                return expectedValue
            }

            override fun onError(t: Throwable) {
                super.onError(t)
                failure = t
            }
        }

        val countDownLatch = CountDownLatch(2)

        var operationResult = 0

        val operationRunner = OperationRunnerImpl(Executors.newSingleThreadExecutor())

        val onNext = Consumer<Int> { result ->
            operationResult += result
            countDownLatch.countDown()
        }

        val onError = Consumer<Throwable> { throwable ->
            failure = throwable
            countDownLatch.countDown()
        }

        val onComplete = Action {
            countDownLatch.countDown()
        }

        operationRunner.runOperation(operationReturningInt)
                .subscribe(onNext, onError, onComplete)

        operationRunner.runOperation(operationReturningInt)
                .subscribe(onNext, onError, onComplete)

        countDownLatch.await()

        assertNull(failure)
        assertEquals(expectedValue * 2, operationResult)
    }

    @Test
    fun testIterableOperations() {
        val expectedValue = 85

        var failure : Throwable? = null

        var numTimesOnCompleteCalled = 0

        val op1 = object : Operation<Int> {
            override fun call(): Int {
                return expectedValue
            }

            override fun onError(t: Throwable) {
                super.onError(t)
                failure = t
            }

            override fun onComplete(result: Int) {
                ++numTimesOnCompleteCalled
            }
        }

        val op2 = object : Operation<Int> {
            override fun call(): Int {
                return expectedValue + 1
            }

            override fun onError(t: Throwable) {
                failure = t
            }

            override fun onComplete(result: Int) {
                ++numTimesOnCompleteCalled
            }
        }

        val operations = listOf(op1, op2)
        val countDownLatch = CountDownLatch(operations.size)

        var operationsResult = 0

        val operationRunner = OperationRunnerImpl(Executors.newSingleThreadExecutor())
        operationRunner.runOperation(operations)
                .subscribe(
                        { result ->
                            operationsResult += result
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

        assertEquals(expectedValue * 2 + 1, operationsResult)
        assertNull(failure)
        assertEquals(2, numTimesOnCompleteCalled)
    }

    @Test
    fun testIterableOperationsWithOpReturningNull() {
        var failure : Throwable? = null

        val operationReturningNull = object : Operation<Unit?> {
            override fun call(): Unit? {
                return null
            }

            override fun onError(t: Throwable) {
                super.onError(t)
                failure = t
            }
        }

        var onNextCalled = false
        var onCompleteCalled = false

        val operations = listOf<Operation<Unit?>>(operationReturningNull)
        val countDownLatch = CountDownLatch(operations.size)

        val operationRunner = OperationRunnerImpl(Executors.newSingleThreadExecutor())
        operationRunner.runOperation(operations)
                .subscribe(
                        { _ ->
                            onNextCalled = true
                            countDownLatch.countDown()
                        },
                        { throwable ->
                            failure = throwable
                            countDownLatch.countDown()
                        },
                        {
                            onCompleteCalled = true
                            countDownLatch.countDown()
                        }
                )

        countDownLatch.await()

        assertNull(failure)
        assertFalse(onNextCalled)
        assertTrue(onCompleteCalled)
    }

    @Test
    fun test1OpReturningIntAndAnotherThatThrows() {
        val expectedValue = 85

        val operationReturningInt = object : Operation<Int> {
            override fun call(): Int {
                return expectedValue
            }
        }

        var failure : Throwable? = null
        var operationResult = 0

        val operationThatThrows = object : Operation<Int> {
            override fun call(): Int {
                throw NullPointerException()
            }

            override fun onError(t: Throwable) {
                super.onError(t)
                failure = t
            }
        }

        val operations = listOf(operationReturningInt, operationThatThrows)
        val countDownLatch = CountDownLatch(operations.size)

        val operationRunner = OperationRunnerImpl(Executors.newSingleThreadExecutor())
        operationRunner.runOperation(operations)
                .subscribe(
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

        assertNotNull(failure)
        assertTrue(failure is NullPointerException)
        assertEquals(expectedValue, operationResult)
    }
}

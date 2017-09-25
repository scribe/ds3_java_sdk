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

package com.spectralogic.escapepod.ratpack

import com.spectralogic.escapepod.httpservice.ExceptionHandlerMapper
import com.spectralogic.escapepod.util.json.Mapper
import org.assertj.core.api.Assertions.assertThat

import org.junit.Test
import ratpack.func.Action
import ratpack.handling.Chain
import ratpack.test.handling.RequestFixture
import java.util.concurrent.atomic.AtomicBoolean

class RatpackHttpRouter_Test {
    @Test
    fun routerRegistration() {
        val router = RatpackHttpRouter()

        val chain = CountingChain("foo/something")
        router.register("module", chain)

        val result = RequestFixture.handle(router, Action<RequestFixture> {
            it.uri("module/foo/something").method("GET")
        })

        assertThat(chain.count).isEqualTo(1)
        assertThat(result.status.code).isEqualTo(200)
        assertThat(result.rendered(String::class.java)).isEqualTo("success")
    }

    @Test
    fun addRouteAfterHandlingRequests() {
        val router = RatpackHttpRouter()

        val firstChain = CountingChain("foo/something")
        router.register("module", firstChain)

        val firstResult = RequestFixture.handle(router, Action<RequestFixture> {
            it.uri("module/foo/something").method("GET")
        })

        assertThat(firstChain.count).isEqualTo(1)
        assertThat(firstResult.status.code).isEqualTo(200)
        assertThat(firstResult.rendered(String::class.java)).isEqualTo("success")

        val secondChain = CountingChain("foo/different")
        router.register("module2", secondChain)

        val secondResult = RequestFixture.handle(router, Action<RequestFixture> {
            it.uri("module2/foo/different").method("GET")
        })

        assertThat(firstChain.count).isEqualTo(1)
        assertThat(secondChain.count).isEqualTo(1)

        assertThat(secondResult.status.code).isEqualTo(200)
        assertThat(secondResult.rendered(String::class.java)).isEqualTo("success")
    }

    @Test
    fun removeRouteAfterHandlingRequest() {
        val router = RatpackHttpRouter()

        val firstChain = CountingChain("foo/something")
        val deregistration = router.register("module", firstChain)

        val firstResult = RequestFixture.handle(router, Action<RequestFixture> {
            it.uri("module/foo/something").method("GET")
        })

        assertThat(firstChain.count).isEqualTo(1)
        assertThat(firstResult.status.code).isEqualTo(200)
        assertThat(firstResult.rendered(String::class.java)).isEqualTo("success")

        deregistration.deregister()

        val secondResult = RequestFixture.handle(router, Action<RequestFixture> {
            it.uri("module2/foo/different").method("GET")
        })

        assertThat(firstChain.count).isEqualTo(1)
        assertThat(secondResult.rendered(String::class.java)).isNullOrEmpty()
    }

    @Test
    fun registerExceptionHandler() {
        val router = RatpackHttpRouter()

        val handlerCalled = AtomicBoolean(false)
        router.registerExceptionHandler(TestException::class.java) { ctx, t ->
            handlerCalled.set(true)
            ctx.response.status(404).send("Could not find file: ${t.testProp}")
        }

        router.register("prefix", ExceptionChain())

        val result = RequestFixture.handle(router, Action<RequestFixture> {
            it.uri("prefix").method("GET")
        })

        assertThat(result.status.code).isEqualTo(404)

        assertThat(handlerCalled).isTrue
    }

    @Test
    fun verifyDefaultHandler() {
        val router = RatpackHttpRouter()
        router.register("prefix", ExceptionChain())

        val result = RequestFixture.handle(router, Action<RequestFixture> {
            it.uri("prefix").method("GET")
        })
        assertThat(result.status.code).isEqualTo(400)

        val defaultException = Mapper.mapper.readValue(result.bodyText, DefaultException::class.java)
        assertThat(defaultException.statusCode).isEqualTo(400)
        assertThat(defaultException.message).isEqualTo("This is a test")
    }
}

internal class TestException : Exception("This is a test") {
    val testProp = "test"
}

internal class ExceptionChain: Action<Chain> {
    override fun execute(t: Chain) {
        t.all { ctx ->
            val exceptionMapper = ctx.get(ExceptionHandlerMapper::class.java)

            exceptionMapper.handle(ctx, TestException())
        }
    }
}

internal class CountingChain(private val prefix: String) : Action<Chain> {
    var count = 0
    private set
    override fun execute(t: Chain) {
        t.get(prefix) {
            count++
            it.render("success")
        }
    }
}
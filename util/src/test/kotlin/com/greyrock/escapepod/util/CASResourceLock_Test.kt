package com.greyrock.escapepod.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CASResourceLock_Test {

    @Test
    fun basicGet() {
        val casResourceLock = CASResourceLock(TestClassProvider(TestClass("test!")))

        val (resource, _) = casResourceLock.getResource()

        assertThat(resource).isNotNull()
        resource.ifNotNull {
            assertThat(it.name).isEqualTo("test!")
        }
    }

    @Test
    fun setForNull() {
        val casResourceLock = CASResourceLock(TestClassProvider(null))

        val (nullResource, cas) = casResourceLock.getResource()

        assertThat(nullResource).isNull()

        casResourceLock.setResource(TestClass("test"), cas)

        val (resource, _) = casResourceLock.getResource()

        assertThat(resource).isNotNull()
        resource.ifNotNull {
            assertThat(it.name).isEqualTo("test")
        }
    }

    @Test
    fun setWithCasMatch() {
        val casResourceLock = CASResourceLock(TestClassProvider(TestClass("test!")))

        val (resource, cas) = casResourceLock.getResource()

        assertThat(resource).isNotNull()

        casResourceLock.setResource(TestClass("test"), cas)
    }

    @Test(expected = CASMismatchException::class)
    fun setWithCasMismatch() {
        val casResourceLock = CASResourceLock(TestClassProvider(TestClass("test!")))

        val (resource, cas) = casResourceLock.getResource()

        assertThat(resource).isNotNull()

        casResourceLock.setResource(TestClass("test!"), cas + 1)
    }
}

class TestClassProvider(private var value : TestClass?): ResourceProvider<TestClass?> {

    override fun loadResource(): TestClass? {
        return value
    }

    override fun setResource(resource: TestClass?) {
        this.value = resource
    }

}

data class TestClass(val name : String)

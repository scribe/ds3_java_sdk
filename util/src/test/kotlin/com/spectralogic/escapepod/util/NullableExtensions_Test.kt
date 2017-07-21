package com.spectralogic.escapepod.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class NullableExtensions_Test {
    @Test
    fun isNotNull() {
        val obj = Any()

        var hitFlag = false

        obj.ifNotNull {
            hitFlag = true
        }

        assertThat(hitFlag).isTrue()
    }

    @Test
    fun isNull() {
        val obj : Any? = null

        var hitFlag = false

        obj.ifNotNull {
            hitFlag = true
        }

        assertThat(hitFlag).isFalse()
    }
}

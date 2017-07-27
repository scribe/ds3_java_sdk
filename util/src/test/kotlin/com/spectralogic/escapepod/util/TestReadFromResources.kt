package com.spectralogic.escapepod.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class TestReadFromResources {

    @Test
    fun testReadFromResources() {
        val expected = "{\"test\" : \"test\"}"
        assertThat(ReadFileFromResources.readFile("test.json")).isEqualTo(expected)
    }
}
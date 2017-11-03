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

package com.spectralogic.escapepod.api

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

internal class PersistenceProperties_Test {

    @Test
    fun singleValue() {
        val builder = PersistencePropertiesBuilder()
        val persistenceProperties = builder.setString("key", "value").build()
        assertThat(persistenceProperties.getString("key")).isEqualTo("value")
    }

    @Test
    fun multiValue() {
        val builder = PersistencePropertiesBuilder()
        val persistenceProperties = builder.setString("key", "value").setInt("intKey", 4).build()
        assertThat(persistenceProperties.getString("key")).isEqualTo("value")
        assertThat(persistenceProperties.getInt("intKey")).isEqualTo(4)
    }

    @Test
    fun chainedBuilder() {
        val builder = PersistencePropertiesBuilder()
        val persistenceProperties = builder.setString("key", "value").build()
        val updatedProperties = persistenceProperties.builder().setString("key", "updatedValue").build()
        assertThat(persistenceProperties.getString("key")).isEqualTo("value")
        assertThat(updatedProperties.getString("key")).isEqualTo("updatedValue")
    }

    @Test
    fun allPropertyTypes() {
     val builder = PersistencePropertiesBuilder()
        val persistenceProperties = builder.setString("key", "value")
                .setInt("intKey", 4)
                .setLong("longKey", 12L)
                .setBool("boolKey", true)
                .setFloat("floatKey", 3f)
                .setDouble("doubleKey", 2.5)
                .build()
        assertThat(persistenceProperties.getString("key")).isEqualTo("value")
        assertThat(persistenceProperties.getInt("intKey")).isEqualTo(4)
        assertThat(persistenceProperties.getLong("longKey")).isEqualTo(12L)
        assertThat(persistenceProperties.getBool("boolKey")).isTrue()
        assertThat(persistenceProperties.getFloat("floatKey")).isEqualTo(3f)
        assertThat(persistenceProperties.getDouble("doubleKey")).isEqualTo(2.5)
    }

    @Test
    fun mismatchedTypes() {
        val builder = PersistencePropertiesBuilder()
        val persistenceProperties = builder.setString("key", "value").build()

        assertThatThrownBy { persistenceProperties.getBool("key") }.isInstanceOf(ClassCastException::class.java)
    }

    @Test
    fun valueNotSet() {
        val persistenceProperties = PersistencePropertiesBuilder().build()

        assertThatThrownBy { persistenceProperties.getInt("value") }.isInstanceOf(NoSuchElementException::class.java)
    }
}
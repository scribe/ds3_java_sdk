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

import com.google.common.collect.ImmutableMap
import java.util.*

class PersistenceProperties constructor(private val propertyMap: ImmutableMap<String, Comparable<Any>>) {

    fun getString(key: String) = getValue(key) as String

    fun getInt(key: String) = getValue(key) as Int

    fun getLong(key: String) = getValue(key) as Long

    fun getBool(key: String) = getValue(key) as Boolean

    fun getFloat(key: String) = getValue(key) as Float

    fun getDouble(key: String) = getValue(key) as Double

    private fun getValue(key: String): Comparable<Any> {
        val value = propertyMap[key]

        if (value == null) {
            throw NoSuchElementException("$key is not a property")
        } else {
            return value
        }
    }

    fun asMap() = propertyMap

    fun builder() = PersistencePropertiesBuilder(propertyMap)
}

class PersistencePropertiesBuilder constructor() {

    private val mapBuilder = HashMap<String, Comparable<Any>>()

    constructor(seedMap: Map<String, Comparable<Any>>) : this() {
        mapBuilder.putAll(seedMap)
    }

    fun setString(key: String, value: String) = this.setValue(key, value as Comparable<Any>)

    fun setInt(key: String, value: Int) = this.setValue(key, value as Comparable<Any>)

    fun setLong(key: String, value: Long) = this.setValue(key, value as Comparable<Any>)

    fun setBool(key: String, value: Boolean) = this.setValue(key, value as Comparable<Any>)

    fun setFloat(key: String, value: Float) = this.setValue(key, value as Comparable<Any>)

    fun setDouble(key: String, value: Double) = this.setValue(key, value as Comparable<Any>)

    private fun setValue(key: String, value: Comparable<Any>): PersistencePropertiesBuilder {
        mapBuilder.put(key, value)
        return this
    }

    fun build(): PersistenceProperties {
        return PersistenceProperties(ImmutableMap.copyOf(mapBuilder))
    }
}

fun PersistenceProperties.getUuid(key: String) = UUID.fromString(this.getString(key))

fun PersistencePropertiesBuilder.setUuid(key: String, value: UUID): PersistencePropertiesBuilder {
    this.setString(key, value.toString())
    return this
}

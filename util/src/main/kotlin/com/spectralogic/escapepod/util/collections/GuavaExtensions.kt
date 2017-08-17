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

package com.spectralogic.escapepod.util.collections

import com.google.common.base.Supplier
import com.google.common.collect.ImmutableList
import java.util.function.BiConsumer
import java.util.function.BinaryOperator
import java.util.stream.Collector

/**
 * public static <T> Collector<T, ImmutableList.Builder<T>, ImmutableList<T>> immutableList() {
    return Collector.of(ImmutableList.Builder::new, ImmutableList.Builder::add,
        (l, r) -> l.addAll(r.build()), ImmutableList.Builder<T>::build);
  }
 */

fun <T> immutableListCollector(): Collector<T, ImmutableList.Builder<T>, ImmutableList<T>> {

    return Collector.of(
            Supplier<ImmutableList.Builder<T>>{ImmutableList.builder<T>()},
            BiConsumer<ImmutableList.Builder<T>, T> {builder: ImmutableList.Builder<T>, value: T -> builder.add(value)},
            BinaryOperator<ImmutableList.Builder<T>> { t, u ->
                t.addAll(u.build())
            },
            com.google.common.base.Function<ImmutableList.Builder<T>, ImmutableList<T>> {
                if (it != null) {
                    it.build()
                } else {
                    ImmutableList.of()
                }
            }


    )
}
package com.spectralogic.escapepod.util.collections

import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableList.builder

fun <T> Sequence<T>.toImmutableList() : ImmutableList<T> {
    val builder = builder<T>()
    this.forEach{ builder.add(it)}
    return builder.build()
}
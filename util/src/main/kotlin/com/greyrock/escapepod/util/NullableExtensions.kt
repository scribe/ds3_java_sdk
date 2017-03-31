package com.greyrock.escapepod.util

fun <T> T?.ifNotNull(action : (T) -> Unit) {
    if (this != null) {
        action.invoke(this)
    }
}

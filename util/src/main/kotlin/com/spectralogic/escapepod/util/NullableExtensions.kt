package com.spectralogic.escapepod.util

fun <T> T?.ifNotNull(action : (T) -> Unit) {
    if (this != null) {
        action(this)
    }
}

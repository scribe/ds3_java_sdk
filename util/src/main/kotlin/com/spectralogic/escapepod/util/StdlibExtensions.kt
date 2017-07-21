package com.spectralogic.escapepod.util

fun AutoCloseable.use(action : () -> Unit) {
    try {
        action.invoke()
    } finally {
        this.close()
    }
}
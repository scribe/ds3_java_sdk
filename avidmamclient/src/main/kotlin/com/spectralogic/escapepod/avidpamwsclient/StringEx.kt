package com.spectralogic.escapepod.avidpamwsclient

fun String.mobid(): String = this.substring(this.indexOf("=") + 1)
fun String.jobId(): String = this.substring(this.indexOf("=") + 1)
fun String?.isNull(): Boolean = this == null
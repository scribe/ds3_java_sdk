package com.spectralogic.escapepod.avidpamwsclient

fun String.mobid(): String = this.substring(this.indexOf("=") + 1)
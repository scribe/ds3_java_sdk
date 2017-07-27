package com.spectralogic.escapepod.util

import java.security.SecureRandom


fun Int.Companion.randomInt() : Int = SecureRandom.getInstanceStrong().nextInt()

package com.spectralogic.escapepod.util

import org.apache.commons.lang3.StringUtils

fun String.ordinalIndexOf(searchString: String, ordinal: Int) = StringUtils.ordinalIndexOf(this, searchString, ordinal)

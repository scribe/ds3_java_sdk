package com.spectralogic.escapepod.api

import io.reactivex.Completable

interface Shutdownable {
    fun shutdown() : Completable
}

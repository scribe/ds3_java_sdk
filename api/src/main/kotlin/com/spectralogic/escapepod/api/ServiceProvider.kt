package com.spectralogic.escapepod.api

import io.reactivex.Completable

interface ServiceProvider<out T> : Shutdownable {
    fun startService() : Completable
    fun getService() : T
}

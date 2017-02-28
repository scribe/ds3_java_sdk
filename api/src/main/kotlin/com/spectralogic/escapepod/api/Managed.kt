package com.spectralogic.escapepod.api

interface Managed {
    /**
     * Starts the managed resource
     */
    fun start()

    /**
     * Stops the managed resource
     */
    fun stop()
}

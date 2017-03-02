package com.spectralogic.escapepod.scheduler

import com.spectralogic.escapepod.api.EscapePodConfiguration
import com.spectralogic.escapepod.api.Scheduler

internal class EscapePodScheduler : Scheduler {

    var config : EscapePodConfiguration? = null
    override var configuration: EscapePodConfiguration?
        get() = config
        set(value) {config = value}

    override fun start() {
        println("EscapePodScheduler [start]")
    }

    override fun stop() {
        println("EscapePodScheduler [stop]")
    }

    override fun migrate(tapeGroupName: String) {
        println("EscapePodScheduler [migrate] " + tapeGroupName)
    }

}

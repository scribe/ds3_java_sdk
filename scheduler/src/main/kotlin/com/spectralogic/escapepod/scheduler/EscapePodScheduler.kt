package com.spectralogic.escapepod.scheduler

import com.spectralogic.escapepod.api.EscapePodConfiguration
import com.spectralogic.escapepod.api.MigrationPlanner
import com.spectralogic.escapepod.api.Scheduler
import javax.inject.Inject

internal class EscapePodScheduler @Inject constructor(val planner : MigrationPlanner) : Scheduler {

    var config : EscapePodConfiguration? = null
    override var configuration: EscapePodConfiguration?
        get() = config
        set(value) {config = value}

    override fun start() {
        println("EscapePodScheduler [start]")




        //future.suspend()
    }

    override fun stop() {
        println("EscapePodScheduler [stop]")
    }

}

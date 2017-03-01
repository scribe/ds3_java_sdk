package com.spectralogic.escapepod.scheduler

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.Scheduler

class SchedulerModule : AbstractModule() {
    override fun configure() {
        bind(Scheduler::class.java).to(EscapePodScheduler::class.java)
    }
}

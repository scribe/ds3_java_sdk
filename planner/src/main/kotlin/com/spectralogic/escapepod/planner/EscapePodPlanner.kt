package com.spectralogic.escapepod.planner

import com.google.common.collect.ImmutableList
import com.spectralogic.escapepod.api.MigrationJob
import com.spectralogic.escapepod.api.MigrationPlanner
import java.util.concurrent.Callable
import java.util.concurrent.Future
import java.util.concurrent.FutureTask

class EscapePodPlanner : MigrationPlanner {

    private val pendingTasks : List<Future<MigrationJob>> = ArrayList()

    override fun getMigrationTasks(): Sequence<Future<MigrationJob>> {
        // create a task
        // then return sequence to scheduler

        val builder = ImmutableList.builder<Future<MigrationJob>>()

        val future = FutureTask<MigrationJob>( Callable {
            // do some calculation
            MigrationJob()
        })

        return builder.build().asSequence()
    }

}

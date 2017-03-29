package com.spectralogic.escapepod.api

import java.util.concurrent.Future

interface MigrationPlanner {
    fun getMigrationTasks() : Sequence<Future<MigrationJob>>
}

class MigrationJob {

}

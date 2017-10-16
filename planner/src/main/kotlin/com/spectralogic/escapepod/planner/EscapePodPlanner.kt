/*
 * *****************************************************************************
 *    Copyright 2014-2017 Spectra Logic Corporation. All Rights Reserved.
 *    Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *    this file except in compliance with the License. A copy of the License is located at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *    or in the "license" file accompanying this file.
 *    This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *    CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *    specific language governing permissions and limitations under the License.
 *  ****************************************************************************
 */

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

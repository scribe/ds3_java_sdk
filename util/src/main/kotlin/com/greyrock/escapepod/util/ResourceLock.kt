/*
 * *****************************************************************************
 *   Copyright 2016 Spectra Logic Corporation. All Rights Reserved.
 *   Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *   this file except in compliance with the License. A copy of the License is located at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   or in the "license" file accompanying this file.
 *   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *   CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *   specific language governing permissions and limitations under the License.
 * ***************************************************************************
 */

package com.greyrock.escapepod.util

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantReadWriteLock

class ResourceLock {
    private val lock = ReentrantReadWriteLock(true)

    fun readLock(lockedFunction: () -> Unit) {
        runLock(lock.readLock(), lockedFunction)
    }

    fun <T> readLock(callable: () -> T): T {
        return runCallableLock(lock.readLock(), callable)
    }

    fun writeLock(lockedFunction: () -> Unit) {
        runLock(lock.writeLock(), lockedFunction)
    }

    fun <T> writeLock(callable : () -> T): T {
        return runCallableLock(lock.writeLock(), callable)
    }

    private fun runLock(lock: Lock, lockedFunction: () -> Unit) {
        try {
            lock.lock()
            lockedFunction.invoke()
        } finally {
            lock.unlock()
        }
    }

    private fun <T> runCallableLock(lock: Lock, callable : () -> T): T {
        try {
            lock.lock()
            return callable.invoke()
        } finally {
            lock.unlock()
        }
    }
}

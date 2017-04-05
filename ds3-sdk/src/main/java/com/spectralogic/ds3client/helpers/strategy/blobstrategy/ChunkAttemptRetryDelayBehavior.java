/*
 * ****************************************************************************
 *    Copyright 2014-2016 Spectra Logic Corporation. All Rights Reserved.
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

package com.spectralogic.ds3client.helpers.strategy.blobstrategy;

/**
 * An interface whose concrete subclasses determine the delay between retries when a
 * chunk operation does not complete.
 */
public interface ChunkAttemptRetryDelayBehavior {
    /**
     * @param delayIntervalInSeconds The delay in seconds, between chunk operation retry attempts, that comes from a Black Pearl payload returned
     *                               when a chunk operation does not complete.
     * @throws InterruptedException
     */
    void delay(final int delayIntervalInSeconds) throws InterruptedException;
}

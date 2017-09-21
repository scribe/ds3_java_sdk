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

package com.spectralogic.escapepod.deviceregistry

import com.spectralogic.escapepod.api.DeviceRegistryService
import com.spectralogic.escapepod.api.DeviceRegistryServiceProvider
import com.spectralogic.escapepod.api.PersistenceServiceProvider
import com.spectralogic.escapepod.api.RequestContext
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

internal class DeviceRegistryServiceProviderImpl
@Inject constructor(private val persistenceServiceProvider: PersistenceServiceProvider): DeviceRegistryServiceProvider {
    override fun startService(): Completable {
        return Completable.complete()
    }

    override fun getService(requestContext: RequestContext): Single<out DeviceRegistryService> {
        return Single.just(DeviceRegistryServiceImpl(persistenceServiceProvider, requestContext))
    }

    override fun shutdown(): Completable {
        return Completable.complete()
    }

}
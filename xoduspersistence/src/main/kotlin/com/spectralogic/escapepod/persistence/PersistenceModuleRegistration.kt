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

package com.spectralogic.escapepod.persistence

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.ClusterServiceProvider
import com.spectralogic.escapepod.api.ModuleRegistration
import com.spectralogic.escapepod.api.Module
import io.reactivex.Completable
import javax.inject.Inject

class PersistenceModuleRegistration : ModuleRegistration<PersistenceModule> {
    override fun module(): Class<PersistenceModule> = PersistenceModule::class.java

    override fun guiceModule(): AbstractModule = XodusPersistenceGuiceModule()
}

class PersistenceModule @Inject internal constructor(private val clusterServiceProvider: ClusterServiceProvider, private val persistenceServiceProvider: XodusPersistenceProvider) : Module {

    override val name: String = "Persistence"

    override fun loadModule(): Completable {
        return Completable.create { emitter ->

            clusterServiceProvider.clusterLifecycleEvents().subscribe(persistenceServiceProvider::clusterHandler)

            emitter.onComplete()
        }
    }

    override fun startModule(): Completable = persistenceServiceProvider.startService()

    override fun shutdownModule(): Completable = persistenceServiceProvider.shutdown()

}
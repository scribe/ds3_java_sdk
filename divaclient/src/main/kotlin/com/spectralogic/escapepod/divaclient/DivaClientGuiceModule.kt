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

package com.spectralogic.escapepod.divaclient

import com.google.inject.AbstractModule
import com.google.inject.assistedinject.FactoryModuleBuilder
import com.spectralogic.escapepod.api.DivaClient
import com.spectralogic.escapepod.api.DivaClientFactory
import com.spectralogic.escapepod.restclientutils.RetrofitClientFactory
import com.spectralogic.escapepod.restclientutils.RetrofitClientFactoryImpl
import com.spectralogic.escapepod.divaclient.session.DivaSessionFactory
import com.spectralogic.escapepod.divaclient.session.DivaSessionFactoryImpl

class DivaClientGuiceModule : AbstractModule() {
    override fun configure() {
        bind(RetrofitClientFactory::class.java).to(RetrofitClientFactoryImpl::class.java)
        bind(DivaSessionFactory::class.java).to(DivaSessionFactoryImpl::class.java)
        install(FactoryModuleBuilder().implement(DivaClient::class.java, DivaClientImpl::class.java).build(DivaClientFactory::class.java))
    }
}

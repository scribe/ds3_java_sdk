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

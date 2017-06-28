package com.spectralogic.escapepod.divaclient

import com.google.inject.AbstractModule
import com.google.inject.assistedinject.FactoryModuleBuilder
import com.spectralogic.escapepod.api.DivaClientFactory
import com.spectralogic.escapepod.divaclient.retrofit.DivaRetrofitClientFactory
import com.spectralogic.escapepod.divaclient.retrofit.DivaRetrofitClientFactoryImpl
import com.spectralogic.escapepod.divaclient.session.DivaSessionFactory
import com.spectralogic.escapepod.divaclient.session.DivaSessionFactoryImpl

class DivaClientGuiceModule : AbstractModule() {
    override fun configure() {
        bind(DivaRetrofitClientFactory::class.java).to(DivaRetrofitClientFactoryImpl::class.java)
        bind(DivaSessionFactory::class.java).to(DivaSessionFactoryImpl::class.java)
        install(FactoryModuleBuilder().build(DivaClientFactory::class.java))
    }
}

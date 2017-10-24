package com.spectralogic.escapepod.pammigrate

import com.google.inject.AbstractModule

class PamMigrateGuiceModule : AbstractModule() {
    override fun configure() {
        bind(PamMigrateHandlers::class.java)
        bind(PamMigrateModuleRegistration::class.java)
    }

}
package com.spectra.escapepod.http

import ratpack.handling.Context
import ratpack.handling.Handler

internal class ModuleHandler() : Handler {
    override fun handle(ctx: Context) {
        ctx.render("All registered modules: <module list>")
    }

}

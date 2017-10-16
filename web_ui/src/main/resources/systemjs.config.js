System.config({
    transpiler: 'typescript',
    typescriptOptions: {
        emitDecoratorMetadata: true,
        experimentalDecorators: true,
        target: "ES5",
        module: "commonjs"},
    map: {
        '@angular': 'node_modules/@angular',
        'rxjs'    : 'node_modules/rxjs',
        'angular2-in-memory-web-api': 'node_modules/angular2-in-memory-web-api',
        '@angular2-material/core': 'node_modules/@angular2-material/core',
        '@angular2-material/button': 'node_modules/@angular2-material/button',
        '@angular2-material/card': 'node_modules/@angular2-material/card',
        '@angular2-material/slide-toggle': 'node_modules/@angular2-material/slide-toggle',
        '@angular2-material/toolbar': 'node_modules/@angular2-material/toolbar',
        '@angular2-material/icon': 'node_modules/@angular2-material/icon',
        '@angular2-material/sidenav': 'node_modules/@angular2-material/sidenav'
    },
    paths: {
        'node_modules/@angular/*': 'node_modules/@angular/*/bundles'
    },
    meta: {
        '@angular/*': {'format': 'cjs'},
        'app/mediator/stock.ts': {
            format: 'es6'
        }
    },
    packages: {
        'app'                              : {main: 'main', defaultExtension: 'ts'},
        'rxjs'                             : {main: 'Rx'},
        '@angular/core'                    : {main: 'core.umd.min.js'},
        '@angular/common'                  : {main: 'common.umd.min.js'},
        '@angular/compiler'                : {main: 'compiler.umd.min.js'},
        '@angular/router'                  : {main: 'router.umd.min.js'},
        '@angular/forms'                   : {main: 'forms.umd.min.js'},
        '@angular/http'                    : {main: 'http.umd.min.js'},
        '@angular/platform-browser'        : {main: 'platform-browser.umd.min.js'},
        '@angular/platform-browser-dynamic': {main: 'platform-browser-dynamic.umd.min.js'},
        'angular2-in-memory-web-api': {
            main: 'index.js',
            defaultExtension: 'js'
        },
        '@angular2-material/core': {
            main: 'core.js'
        },
        '@angular2-material/card': {
            main: 'card.js'
        },
        '@angular2-material/button': {
            main: 'button.js'
        },
        '@angular2-material/toolbar': {
            main: 'toolbar.js'
        },
        '@angular2-material/slide-toggle': {
            main: 'slide-toggle.js'
        },
        '@angular2-material/icon': {
            main: 'icon.js'
        },
        '@angular2-material/sidenav': {
            main: 'sidenav.js'
        }
    }
});

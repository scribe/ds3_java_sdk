import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent} from "./app.component";

import { HttpModule } from "@angular/http";
import { MdIconModule } from "@angular2-material/icon";
import { MdButtonModule } from "@angular2-material/button";
import { MdCardModule } from "@angular2-material/card";
import { MdIconRegistry } from "@angular2-material/icon";
import { MdSidenavModule } from '@angular2-material/sidenav';
import { MdToolbarModule } from '@angular2-material/toolbar';

import { ModuleService } from "./module-service/module-service";

import { routing } from "./app.routing";

@NgModule({
    imports: [
        BrowserModule,
        HttpModule,
        MdIconModule,
        MdButtonModule,
        MdCardModule,
        MdSidenavModule,
        MdToolbarModule,
        routing
    ],
    declarations: [
        AppComponent
    ],
    providers: [
        ModuleService,
        MdIconRegistry
    ],
    bootstrap: [
        AppComponent
    ]
})
export class AppModule { }


/**
 * This is the component that defines the application -- the landing page.  It populates a navigation
 * menu by contacting a web servoce that tells us which modules to load, where a module consists of a
 * name used for a displayed link and a url in the routing table that corresponds to the component used
 * as the presentation for a named module.
 */

import { Component } from "@angular/core";
import { ModuleService } from "./module-service/module-service";

@Component({
    selector: 'app-root',
    styleUrls: ['./app/app.component.css'],
    templateUrl: './app/app.component.html'
})
export class AppComponent {
    title = 'Escape Pod';

    /**
     * When we wake up, we talk to the web server that started us to get a list of modules configured
     * for that instance of the service.  A module descriptor is a json payload that has the name you
     * want displayed in the navigation menu and a router URL that holds the content for a named module.
     */
    modules: Array<string>;

    constructor(private moduleService : ModuleService) {
        this.getModuleDescriptors();
    }

    getModuleDescriptors() {
        this.moduleService.getModules().subscribe(
            modules => {
                this.modules = modules;
            },
            err => {
                console.log("Can't get module list.  Error code: %s, URL: %s", err.status, err.url);
            },
            () => {
                console.log("Got module list.");
            }
        );
    }
}

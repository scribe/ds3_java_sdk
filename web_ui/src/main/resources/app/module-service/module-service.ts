/**
 * Build a collection of descriptors that can be used to build a navigation menu.
 */

import { Injectable } from "@angular/core";
import { Observable } from "rxjs/Observable";
import { Router } from "@angular/router";

@Injectable()
export class ModuleService {
    private moduleDescriptors: Array< { name: string, url: string } > = [];

    constructor(private router: Router) {
        router.config.forEach(route => {
            this.moduleDescriptors.push( { name: this.routerPathToNavigationString(route.path), url: route.path } );
        });
    }

    private routerPathToNavigationString(routerPath: string) : string {
        return routerPath.charAt(0).toUpperCase() + routerPath.slice(1);
    }

    getModules() : Observable<Array< { name: any, url: string} >> {
        return Observable.of(this.moduleDescriptors);
    }
}

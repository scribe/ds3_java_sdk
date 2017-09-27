/**
 * Build a collection of descriptors that can be used to build a navigation menu.
 */

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';
import { ModuleDescriptor } from './module-descriptor'

@Injectable()
export class ModuleService {
    private moduleDescriptors: Array<ModuleDescriptor> = [];

    constructor(private router: Router) {
        router.config.forEach(route => {
            this.moduleDescriptors.push(new ModuleDescriptor(this.routerPathToNavigationString(route.path), route.path));
        });
    }

    private routerPathToNavigationString(routerPath: string) : string {
        return routerPath.charAt(0).toUpperCase() + routerPath.slice(1);
    }

    getModules() : Observable<Array<ModuleDescriptor>> {
        return Observable.of(this.moduleDescriptors);
    }
}

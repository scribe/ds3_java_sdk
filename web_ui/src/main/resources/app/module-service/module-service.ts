/**
 * Talk to the web server from whence we got served and return a list of module descriptors used
 * to populate a navigation menu.
 */

import { Http } from "@angular/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs/Observable";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/mergeMap';
import 'rxjs/add/operator/toArray';

@Injectable()
export class ModuleService {
    constructor(private http : Http) { }

    /**
     * Return an observable array used to map a string we will display in a navigation menu to the
     * corresponding router link by making an http request to the server which served up the landing
     * page.
     * @returns {Observable<Array<{name: any; url: string}>>}
     */
    getModules() : Observable<Array< { name: any, url: string} >> {
        return this.http.get('/modules')
            .flatMap(httpResponse => httpResponse.json())
            .map(httpResponseJson => { return { name: httpResponseJson.name, url: this.routerLinkFromModuleName(httpResponseJson.name) } })
            .toArray()
    }

    private routerLinkFromModuleName(moduleName: string) : string {
        return moduleName.toLowerCase();
    }
}

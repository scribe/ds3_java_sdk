/**
 * Talk to the web server from whence we got served and return a list of module descriptors used
 * to populate a navigation menu.
 */

import { Http } from "@angular/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs/Observable";
import 'rxjs/add/operator/map';

@Injectable()
export class ModuleService {
    constructor(private http : Http) { }

    getModules() : Observable<Array<string>> {
        return this.http.get('/modules')
            .map(httpResponse => httpResponse.json());
    }
}

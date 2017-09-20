import { SearchComponent } from "./search.component";
import { NgModule } from "@angular/core";

import { routing } from "./search.routing";

@NgModule({
    declarations: [
        SearchComponent
    ],
    imports: [
        routing
    ],
    exports: [
        SearchComponent
    ]
})
export default class SearchModule { }
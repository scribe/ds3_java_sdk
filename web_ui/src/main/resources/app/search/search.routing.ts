import { ModuleWithProviders } from "@angular/core";
import { RouterModule } from "@angular/router";
import { Routes } from "@angular/router";

import { SearchComponent } from "./search.component";

const routes: Routes = [
    { path: '', component: SearchComponent}
];

export const routing: ModuleWithProviders = RouterModule.forChild(routes);


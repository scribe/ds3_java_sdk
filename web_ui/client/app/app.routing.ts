import { ModuleWithProviders } from "@angular/core";
import { RouterModule } from "@angular/router";
import { Routes } from "@angular/router";

const routes: Routes = [
    { path: 'search', loadChildren: 'app/search/search.module#SearchModule'}
];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes);

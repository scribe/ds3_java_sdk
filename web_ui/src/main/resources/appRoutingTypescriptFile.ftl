import { ModuleWithProviders } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Routes } from '@angular/router';

const routes: Routes = [
    <#list pathInfoList as pathInfo>

    { path: '${pathInfo.linkText}', loadChildren: '${pathInfo.routeUrl}' },

    </#list>
];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes);

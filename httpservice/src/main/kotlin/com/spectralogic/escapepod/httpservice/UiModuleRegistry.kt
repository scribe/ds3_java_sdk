/*
 * *****************************************************************************
 *    Copyright 2014-2017 Spectra Logic Corporation. All Rights Reserved.
 *    Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *    this file except in compliance with the License. A copy of the License is located at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *    or in the "license" file accompanying this file.
 *    This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *    CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *    specific language governing permissions and limitations under the License.
 *  ****************************************************************************
 */

package com.spectralogic.escapepod.httpservice

import ratpack.func.Action
import ratpack.handling.Chain

interface UiModuleRegistry {
    fun registerUiModule(uiModuleRegistration: UiModuleRegistration)
    fun routeNames() : Sequence<String>
}

/**
 * The UI Module Registration is how Escape Pod modules can register their own UI components into the standard UI.
 *
 * The name is used not only for displaying the module in the UI, but also for resolving paths in the UI.
 * For example, with a module name of 'search' the path use to resolve the modules root component would be:
 * 'app/search/search.module#SearchModule'
 *
 * The resourceResolver tells the UI where to get it's own resources.  This allows a module implementer to
 * implement their UI logic however they want without the UI having to know how/where resources are retrieved.
 */
data class UiModuleRegistration(val name: String, val resourceResolver: Action<Chain>)

/*

import { ModuleWithProviders } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Routes } from '@angular/router';

const routeNames: Routes = [
    { path: 'search', loadChildren: 'app/search/search.module#SearchModule'}
];

export const routing: ModuleWithProviders = RouterModule.forRoot(routeNames);

 */

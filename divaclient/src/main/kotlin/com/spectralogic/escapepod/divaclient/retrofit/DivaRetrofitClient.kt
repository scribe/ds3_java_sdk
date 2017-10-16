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

package com.spectralogic.escapepod.divaclient.retrofit

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

internal interface DivaRetrofitClient {

    @POST("registerClient")
    fun registerClient(@Body client: RegisterClient) : Single<RegisterClientResponse>

    @POST("getGroupsList")
    fun getTapeGroups(@Body getTapeGroup: GetGroupsList) : Single<GetGroupsListResponse>

    @POST("getSourceDestinationList")
    fun getSourceDestinationList(@Body getSourceDestinationList: GetSourceDestinationList) : Single<GetSourceDestinationListResponse>

    @POST("getRequestInfo")
    fun getRequestInfo(@Body getRequestInfo: GetRequestInfo) : Single<GetRequestInfoResponse>

    @POST("getObjectInfo")
    fun getObjectInfo(@Body getObjectInfo: GetObjectInfo) : Single<GetObjectInfoResponse>

    @POST("restoreObject")
    fun restoreObject(@Body restoreObject: RestoreObject) : Single<RestoreObjectResponse>
}

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

package com.spectralogic.escapepod.avidmamclient

import io.reactivex.Single
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text
import retrofit2.http.GET
import retrofit2.http.Query

// Need to add SSL support for MAM 6.0 in the fall
interface AvidMamRetrofitClient {
    @GET("/UserManagementWS/UM.asmx/Login")
    fun login(@Query("user") username : String, @Query("pwd") password : String) : Single<UserLoginResponse>

    @GET("/ControlCenter/ConfigurationService/Config.asmx/GetKey")
    fun getKey(@Query("profile") profile : String, @Query("key") key : String) : Single<GetKeyResponse>

    @GET("/WorkflowLibraryWS/WorkflowLibrary.asmx/FileCopyAsync")
    fun fileCopyAsync(@Query("source") source : String, @Query("dest") dest : String, @Query("overwrite") overwrite: String) : Single<FileCopyAsyncResponse>

}

@Root(name = "string")
class UserLoginResponse {
    @field:Namespace(reference = "http://www.blue-order.com/ma/usermanagementws/um")
    @field:Text
    var session : String = ""
}

@Root(name = "string")
class GetKeyResponse {
    @field:Namespace(reference = "http://www.blue-order.com/ma/configurationservicews/config")
    @field:Text
    var value : String = ""
}

@Root(name = "string")
class FileCopyAsyncResponse {
    @field:Namespace(reference = "http://www.blue-order.com/ma/workflowlibraryws/workflowlibrary")
    @field:Text
    var value : String = ""
}

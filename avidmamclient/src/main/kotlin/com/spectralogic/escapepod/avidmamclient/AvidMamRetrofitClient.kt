package com.spectralogic.escapepod.avidmamclient

import io.reactivex.Single
import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text
import retrofit2.http.GET
import retrofit2.http.Query

// Need to add SSL support for MAM 6.0 in the fall
interface AvidMamRetrofitClient {
    /**
     * For MAM 5.9 the port needs to be 9900
     * For MAM 6.0 the port needs to be 9901
     */
    @GET("/UserManagementWS/UM.asmx/Login")
    fun login(@Query("user") username : String, @Query("pwd") password : String) : Single<UserLoginResponse>

    /**
     * For MAM 5.9 the port needs to be 9910
     * For MAM 6.0 the port needs to be 9911
     *
     */
    @GET("/ControlCenter/ConfigurationService/Config.asmx/GetKey")
    fun getKey(@Query("profile") profile : String, @Query("key") key : String) : Single<GetKeyResponse>

    /**
     * For MAM 5.9 the port needs to be 9900
     * For MAM 6.0 the port needs to be 9901
     */
    @GET("/WorkflowLibraryWS/WorkflowLibrary.asmx/FileCopyAsync")
    fun fileCopyAsync(@Query("source") source : String, @Query("dest") dest : String, @Query("overwrite") overwrite: String) : Single<CopyAsyncResponse>
    /**
     * For MAM 5.9 the port needs to be 9900
     * For MAM 6.0 the port needs to be 9901
     */
    @GET("/WorkflowLibraryWS/WorkflowLibrary.asmx/FileCopyAsync")
    fun directoryCopyAsync(@Query("source") source : String, @Query("dest") dest : String, @Query("overwrite") overwrite: String) : Single<CopyAsyncResponse>

    @GET("/WorkflowLibraryWS/WorkflowLibrary.asmx/GetJobStatus")
    fun getJobStatus(@Query("jobId") jobId : String) : Single<MamJobStatus>

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
class CopyAsyncResponse {
    @field:Namespace(reference = "http://www.blue-order.com/ma/workflowlibraryws/workflowlibrary")
    @field:Text
    var value : String = ""
}

@Root(name = "JobStatus")
@Namespace(reference = "http://www.blue-order.com/ma/workflowlibraryws/workflowlibrary")
class MamJobStatus {
    @field:Element
    var jobId : String = ""

    @field:Element
    var percent : Float = 0.0F

    @field:Element
    var msg : String = ""

    @field:Element
    var error : Boolean = false

    @field:Element
    var output : String = ""
}

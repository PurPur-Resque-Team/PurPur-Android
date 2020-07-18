package com.bibim.purpur.data.remote.retrofit

import com.bibim.purpur.data.model.SignUpResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface NetworkService {

    @GET("/users/signup")
    fun signUp(
        @Path("userName") userName: String
    ): Call<SignUpResponse>
}
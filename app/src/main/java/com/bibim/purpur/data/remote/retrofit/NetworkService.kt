package com.bibim.purpur.data.remote.retrofit

import com.bibim.purpur.data.model.SignUpResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface NetworkService {

    @POST("/users/signup")
    fun signUp(
        @Body userName: JsonObject
    ): Call<SignUpResponse>
}
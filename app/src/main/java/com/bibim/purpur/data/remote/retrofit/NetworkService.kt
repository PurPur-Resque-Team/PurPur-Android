package com.bibim.purpur.data.remote.retrofit

import com.bibim.purpur.data.model.IslandInfoResponse
import com.bibim.purpur.data.model.IslandListResponse
import com.bibim.purpur.data.model.SignUpResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface NetworkService {

    @POST("/users/signup")
    fun signUp(
        @Body userName: JsonObject
    ): Call<SignUpResponse>

    @GET("/islands")
    fun getIslandInfo(
        @Query("islandIdx") islandIdx: Int
    ): Call<IslandInfoResponse>

    @GET("/islands")
    fun getIslandList() : Call<IslandListResponse>
}
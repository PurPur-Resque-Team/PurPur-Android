package com.bibim.purpur.data.remote.retrofit

import com.bibim.purpur.data.model.*
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*


interface NetworkService {

    @POST("/users/signup")
    fun signUp(
        @Body userName: JsonObject
    ): Call<SignUpResponse>

    @GET("/animals")
    fun getMissionsAndAnimal(
        @Query("animalIdx") animalIdx: Int
    ): Call<MissionAndAnimalResponse>

    @POST("/animals")
    fun clearMission(
        @Query("animalIdx") animalIdx: Int,
        @Body missionIdx: JsonObject
    ): Call<MissionClearResponse>

    @GET("/islands")
    fun getIslandInfo(
        @Query("islandIdx") islandIdx: Int
    ): Call<IslandInfoResponse>

    @GET("/islands")
    fun getIslandList(): Call<IslandListResponse>

    @PUT("/users/setUserName")
    fun putUserName(): Call<NameResponse>
}
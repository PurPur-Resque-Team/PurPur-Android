package com.bibim.purpur.data.remote

import android.util.Log
import com.bibim.purpur.data.model.*
import com.bibim.purpur.data.remote.retrofit.NetworkServiceImpl
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSourceImpl : RemoteDataSource {
    private val api = NetworkServiceImpl.SERVICE
    override fun signUp(
        userName: JsonObject,
        success: (SignUpResponse) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        api.signUp(userName).enqueue(object : Callback<SignUpResponse> {
            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                fail(t)
            }
            override fun onResponse(
                call: Call<SignUpResponse>,
                response: Response<SignUpResponse>
            ) {
                success(response.body()!!)
            }
        })
    }

    override fun clearMission(
        animalIdx: Int,
        missionIdx: JsonObject,
        success: (MissionClearResponse) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        api.clearMission(animalIdx, missionIdx).enqueue(object : Callback<MissionClearResponse> {
            override fun onFailure(call: Call<MissionClearResponse>, t: Throwable) {
                fail(t)
            }

            override fun onResponse(
                call: Call<MissionClearResponse>,
                response: Response<MissionClearResponse>
            ) {
                success(response.body()!!)
            }
        })
    }

    override fun getMissionsAndAnimal(
        animalIdx: Int,
        success: (MissionAndAnimalResponse) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        api.getMissionsAndAnimal(animalIdx).enqueue(object : Callback<MissionAndAnimalResponse> {
            override fun onFailure(call: Call<MissionAndAnimalResponse>, t: Throwable) {
                fail(t)
            }

            override fun onResponse(
                call: Call<MissionAndAnimalResponse>,
                response: Response<MissionAndAnimalResponse>
            ) {
                success(response.body()!!)
            }
        })
    }

    override fun getIslandInfo(
        islandIdx: Int,
        success: (IslandInfoResponse) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        api.getIslandInfo(islandIdx).enqueue(object : Callback<IslandInfoResponse> {
            override fun onFailure(call: Call<IslandInfoResponse>, t: Throwable) {
                fail(t)
            }

            override fun onResponse(
                call: Call<IslandInfoResponse>,
                response: Response<IslandInfoResponse>
            ) {
                Log.e("onRes", response.body().toString())
                success(response.body()!!)
            }
        })
    }

    override fun getIslandList(success: (IslandListResponse) -> Unit, fail: (Throwable) -> Unit) {
        api.getIslandList().enqueue(object : Callback<IslandListResponse> {
            override fun onFailure(call: Call<IslandListResponse>, t: Throwable) {
                fail(t)
            }

            override fun onResponse(
                call: Call<IslandListResponse>,
                response: Response<IslandListResponse>
            ) {
                success(response.body()!!)
            }

        })
    }

    override fun putUserName(
        userName: JsonObject,
        success: (NameResponse) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        api.putUserName(userName).enqueue(object: Callback<NameResponse>{
            override fun onFailure(call: Call<NameResponse>, t: Throwable) {
                fail(t)
            }
            override fun onResponse(call: Call<NameResponse>, response: Response<NameResponse>) {
                success(response.body()!!)
            }

        })
    }

}
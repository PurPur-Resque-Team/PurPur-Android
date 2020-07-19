package com.bibim.purpur.data.remote

import com.bibim.purpur.data.model.MissionAndAnimalResponse
import com.bibim.purpur.data.model.MissionClearResponse
import com.bibim.purpur.data.model.SignUpResponse
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


}
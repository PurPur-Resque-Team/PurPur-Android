package com.bibim.purpur.data.remote

import android.util.Log
import com.bibim.purpur.data.model.IslandInfoResponse
import com.bibim.purpur.data.model.IslandListResponse
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

    override fun getIslandInfo(
        islandIdx: Int,
        success: (IslandInfoResponse) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        api.getIslandInfo(islandIdx).enqueue(object : Callback<IslandInfoResponse>{
            override fun onFailure(call: Call<IslandInfoResponse>, t: Throwable) {
                fail(t)
            }

            override fun onResponse(
                call: Call<IslandInfoResponse>,
                response: Response<IslandInfoResponse>
            ) {
                Log.e("onRes", response.toString())
                success(response.body()!!)
            }
        })
    }

    override fun getIslandList(success: (IslandListResponse) -> Unit, fail: (Throwable) -> Unit) {
        api.getIslandList().enqueue(object : Callback<IslandListResponse>{
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

}
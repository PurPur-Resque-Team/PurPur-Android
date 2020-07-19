package com.bibim.purpur.data.remote

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


}
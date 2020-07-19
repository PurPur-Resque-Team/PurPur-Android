package com.bibim.purpur.data.remote

import com.bibim.purpur.data.model.IslandInfoResponse
import com.bibim.purpur.data.model.IslandListResponse
import com.bibim.purpur.data.model.SignUpResponse
import com.google.gson.JsonObject
import retrofit2.Call


interface RemoteDataSource {

    fun signUp(
        userName: JsonObject,
        success: (SignUpResponse) -> Unit,
        fail: (Throwable) -> Unit
    )

    fun getIslandInfo(
        islandIdx: Int,
        success: (IslandInfoResponse) -> Unit,
        fail: (Throwable) -> Unit)

    fun getIslandList(
        success: (IslandListResponse) -> Unit,
        fail: (Throwable) -> Unit)
}
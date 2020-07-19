package com.bibim.purpur.data.remote

import com.bibim.purpur.data.model.SignUpResponse
import com.google.gson.JsonObject


interface RemoteDataSource {

    fun signUp(
        userName: JsonObject,
        success: (SignUpResponse) -> Unit,
        fail: (Throwable) -> Unit
    )
}
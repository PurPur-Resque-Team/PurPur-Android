package com.bibim.purpur.data.repository

import com.bibim.purpur.data.model.SignUpResponse
import com.bibim.purpur.data.remote.RemoteDataSource
import com.google.gson.JsonObject

class NameRepository(private val remoteDataSource: RemoteDataSource) {

    fun signUp(userName: JsonObject, success: (SignUpResponse) -> Unit, fail: (Throwable) -> Unit) =
        remoteDataSource.signUp(userName, success, fail)
}
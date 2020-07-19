package com.bibim.purpur.data.repository

import com.bibim.purpur.data.model.IslandListResponse
import com.bibim.purpur.data.remote.RemoteDataSource

class IslandListRepository (private val remoteDataSource: RemoteDataSource){

    fun getIslandList(success: (IslandListResponse) -> Unit, fail: (Throwable) -> Unit) =
        remoteDataSource.getIslandList(success, fail)
}
package com.bibim.purpur.data.repository

import com.bibim.purpur.data.model.IslandInfoResponse
import com.bibim.purpur.data.remote.RemoteDataSource

class IslandRepository (private val remoteDataSource: RemoteDataSource){

    fun getIslandInfo(islandIdx: Int, success: (IslandInfoResponse) -> Unit, fail: (Throwable) -> Unit) =
        remoteDataSource.getIslandInfo(islandIdx, success, fail)
}
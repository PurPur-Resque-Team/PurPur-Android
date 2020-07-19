package com.bibim.purpur.data.repository

import com.bibim.purpur.data.model.MissionAndAnimalResponse
import com.bibim.purpur.data.model.MissionClearResponse
import com.bibim.purpur.data.remote.RemoteDataSource
import com.google.gson.JsonObject

class DetailRepository(private val remoteDataSource: RemoteDataSource) {

    fun getMissionsAndAnimal(
        animalIdx: Int,
        success: (MissionAndAnimalResponse) -> Unit,
        fail: (Throwable) -> Unit
    ) = remoteDataSource.getMissionsAndAnimal(animalIdx, success, fail)


    fun clearMission(
        animalIdx: Int,
        missionIdx: JsonObject,
        success: (MissionClearResponse) -> Unit,
        fail: (Throwable) -> Unit
    ) = remoteDataSource.clearMission(animalIdx, missionIdx, success, fail)
}
package com.bibim.purpur.data.remote

import com.bibim.purpur.data.model.*
import com.google.gson.JsonObject


interface RemoteDataSource {

    fun signUp(
        userName: JsonObject,
        success: (SignUpResponse) -> Unit,
        fail: (Throwable) -> Unit
    )

    fun clearMission(
        animalIdx: Int,
        missionIdx: JsonObject,
        success: (MissionClearResponse) -> Unit,
        fail: (Throwable) -> Unit
    )

    fun getMissionsAndAnimal(
        animalIdx: Int,
        success: (MissionAndAnimalResponse) -> Unit,
        fail: (Throwable) -> Unit
    )

    fun getIslandInfo(
        islandIdx: Int,
        success: (IslandInfoResponse) -> Unit,
        fail: (Throwable) -> Unit
    )

    fun getIslandList(
        success: (IslandListResponse) -> Unit,
        fail: (Throwable) -> Unit
    )
}
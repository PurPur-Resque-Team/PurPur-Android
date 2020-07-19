package com.bibim.purpur.data.model

data class MissionClearResponse(
    val status: Int,
    val message: String,
    val data: ClearMisson
)

data class ClearMisson(
    val clearedMissionIdx: Int,
    val afterAnimalInfo: AfterAnimalInfo
)

data class AfterAnimalInfo(
    val animalStatus: Int,
    val animalProgress: Int
)
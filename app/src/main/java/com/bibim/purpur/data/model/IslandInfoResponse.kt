package com.bibim.purpur.data.model

data class IslandInfoResponse(
    val status: Int,
    val message: String,
    val data: IslandInfo
)

data class IslandInfo(
    val islandIdx: Int,
    val islandName: String,
    val islandProgress: Int,
    val isOpened: Int,
    val islandStatus: Int,
    val animals: ArrayList<AnimalInfo>
)

data class AnimalInfo(
    val animalIdx: Int,
    val animalName: String,
    val animalVerify:Int,
    val animalMissionCount: Int,
    val lastMissionClear: String,
    val animalStatus: Int,
    val animalProgress: Int,
    val createdAt: String,
    val updatedAt: String,
    val animalVerify: Int
)
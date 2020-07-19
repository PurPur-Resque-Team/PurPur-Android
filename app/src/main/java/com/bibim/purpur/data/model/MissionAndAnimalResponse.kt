package com.bibim.purpur.data.model

data class MissionAndAnimalResponse(
    val status: Int,
    val message: String,
    val data: AnimalAndMission
)

data class AnimalAndMission(
    val animalInfo: AnimalInfo,
    val missions: ArrayList<Mission>
)

data class AnimalInfo(
    val animalIdx: Int,
    val animalName: String,
    val animalMissionCount: Int,
    val lastMissionClear: String,
    val animalStatus: Int,
    val animalProgress: Int,
    val createdAt: String,
    val updatedAt: String
)

data class Mission(
    val missionIdx: Int,
    val fk_animalIdx: Int,
    val isCleared: Int,
    val missionContent: String,
    val createdAt: String,
    val updatedAt: String
)
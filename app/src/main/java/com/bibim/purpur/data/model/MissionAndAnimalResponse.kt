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

data class Mission(
    val missionIdx: Int,
    val fk_animalIdx: Int,
    val isCleared: Int,
    val missionContent: String,
    val createdAt: String,
    val updatedAt: String
)
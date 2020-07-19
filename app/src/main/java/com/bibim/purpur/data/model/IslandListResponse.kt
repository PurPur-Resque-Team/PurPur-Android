package com.bibim.purpur.data.model

data class IslandListResponse(
    val status: Int,
    val message: String,
    val data: IslandList
)

data class IslandList(
    val islandIdx: Int,
    val islandName: String,
    val islandProgress: Int,
    val isOpened: Int
)
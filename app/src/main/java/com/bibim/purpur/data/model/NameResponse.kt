package com.bibim.purpur.data.model

data class NameResponse(
    val status: Int,
    val message: String,
    val data: UserIdx
)

data class UserIdx(
    val userIdx: Int
)
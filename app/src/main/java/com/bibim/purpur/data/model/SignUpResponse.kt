package com.bibim.purpur.data.model

data class SignUpResponse(
    val status: Int,
    val message: String,
    val data: User
)

data class User(
    val username: String,
    val token: String
)
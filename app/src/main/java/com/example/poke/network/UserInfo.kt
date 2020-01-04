package com.example.poke.network

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json


data class UserInfo(
    @field:Json(name = "email")
    val email: String,
    @field:Json(name = "firstname")
    val firstName: String,
    @field:Json(name = "lastname")
    val lastName: String
)


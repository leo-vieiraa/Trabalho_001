package com.example.trabalho_001.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token")
    val token: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("msg")
    val msg: String?
) {
    fun isError() : Boolean {
        return token == null || token.isEmpty()
    }
}

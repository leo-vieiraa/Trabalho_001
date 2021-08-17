package com.example.trabalho_001.model

import com.google.gson.annotations.SerializedName

data class Credentials(
    @SerializedName("username")
    val email: String,
    val password: String
) {

    fun checkUserName(): Boolean {
        return email.isNotEmpty()
    }

    fun checkPassword(): Boolean {
        return password.isNotEmpty()
    }

}

package com.example.trabalho_001.service

import com.example.trabalho_001.model.Credentials
import com.example.trabalho_001.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationService {

    @POST("/auth/login")
    fun login(@Body credentials: Credentials): Call<LoginResponse>

}
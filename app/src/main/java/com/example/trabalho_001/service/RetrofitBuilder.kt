package com.example.trabalho_001.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofitFake = Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getAuthenticationServices(): AuthenticationService {
        return retrofitFake.create(AuthenticationService::class.java)
    }

    fun getProductServices(): ProductService {
        return retrofitFake.create(ProductService::class.java)
    }


}
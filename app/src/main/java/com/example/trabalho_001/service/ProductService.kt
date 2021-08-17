package com.example.trabalho_001.service

import com.example.trabalho_001.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {

    @GET("/products")
    fun getProducts(): Call<List<Product>>

}
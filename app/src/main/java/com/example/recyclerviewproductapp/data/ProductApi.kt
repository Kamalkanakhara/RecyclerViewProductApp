package com.example.recyclerviewproductapp

import com.example.recyclerviewproductapp.*
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    suspend fun getProducts(): List<Product>
}
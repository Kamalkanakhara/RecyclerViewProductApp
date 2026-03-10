package com.example.recyclerviewproductapp.data

import com.example.recyclerviewproductapp.ProductApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RetrofitClient @Inject constructor() {

    private  val BASE_URL = "https://fakestoreapi.com/"

    val api: ProductApi by lazy{

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApi::class.java)
    }
}

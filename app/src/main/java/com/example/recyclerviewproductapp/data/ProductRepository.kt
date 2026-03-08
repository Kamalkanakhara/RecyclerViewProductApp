package com.example.recyclerviewproductapp.data

import com.example.recyclerviewproductapp.Product

class ProductRepository {

    suspend fun getProducts(): List<Product> {

        return RetrofitClient.api.getProducts()

    }

}
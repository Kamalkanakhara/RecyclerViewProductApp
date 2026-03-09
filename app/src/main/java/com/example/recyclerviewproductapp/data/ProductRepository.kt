package com.example.recyclerviewproductapp.data

import com.example.recyclerviewproductapp.Product
import com.example.recyclerviewproductapp.data.RetrofitClient.api
import com.example.recyclerviewproductapp.viewmodel.UiState

class ProductRepository {

    suspend fun getProducts(): UiState<List<Product>> {

        return try {

            val response = api.getProducts()
            UiState.Success(response)

        } catch (e: Exception) {

            UiState.Error(e.message ?: "Something went wrong")
        }

    }

}
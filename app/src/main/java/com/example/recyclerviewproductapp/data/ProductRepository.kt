package com.example.recyclerviewproductapp.data

import com.example.recyclerviewproductapp.Product
import com.example.recyclerviewproductapp.viewmodel.UiState
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val retrofitClient: RetrofitClient
) {

    suspend fun getProducts(): UiState<List<Product>> {

        return try {

            val response = retrofitClient.api.getProducts()
            UiState.Success(response)

        } catch (e: Exception) {

            UiState.Error(e.message ?: "Something went wrong")
        }

    }

}
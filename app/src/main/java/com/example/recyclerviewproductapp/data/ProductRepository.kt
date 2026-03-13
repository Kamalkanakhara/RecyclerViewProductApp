package com.example.recyclerviewproductapp.data

import com.example.recyclerviewproductapp.Product
import com.example.recyclerviewproductapp.ProductApi
import com.example.recyclerviewproductapp.viewmodel.UiState

class ProductRepository (
    private val api: ProductApi,
    private val dao: ProductDao
) {

    fun getCachedProducts() = dao.getProducts()

    suspend fun fetchProducts() {

        try {

            val products = api.getProducts()

            val entities = products.map {
                ProductEntity(
                    id = it.id,
                    title = it.title,
                    price = it.price,
                    image = it.image
                )
            }

            dao.insertProducts(entities)

        } catch (e: Exception) {
        }
    }
}
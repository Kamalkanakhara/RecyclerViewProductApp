package com.example.recyclerviewproductapp.data

import com.example.recyclerviewproductapp.Product
import com.example.recyclerviewproductapp.ProductApi
import com.example.recyclerviewproductapp.viewmodel.UiState
import retrofit2.HttpException
import java.io.IOException

class ProductRepository (
    private val api: ProductApi,
    private val dao: ProductDao
) {

    fun getCachedProducts() = dao.getProducts()

    suspend fun fetchProducts(): UiState<List<ProductEntity>> {

         return try {

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
            UiState.Success(entities)

        } catch (e: IOException) {
            UiState.Error("No Internet Connection")
        } catch (e: HttpException) {
            UiState.Error("Server Error: ${e.code()}")
        } catch (e: Exception) {
            UiState.Error("Something went wrong")
        }
    }
}
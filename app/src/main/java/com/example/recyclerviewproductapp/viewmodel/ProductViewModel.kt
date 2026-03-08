package com.example.recyclerviewproductapp.viewmodel

import androidx.lifecycle.*
import com.example.recyclerviewproductapp.Product
import com.example.recyclerviewproductapp.data.ProductRepository
import kotlinx.coroutines.*

class ProductViewModel : ViewModel() {

    private val repository = ProductRepository()

    val products = MutableLiveData<List<Product>>()
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()

    fun fetchProducts() {

        viewModelScope.launch {

            loading.value = true

            try {

                val result = repository.getProducts()

                products.value = result

            } catch (e: Exception) {

                error.value = "No Internet Connection or API Error"

            } finally {

                loading.value = false

            }
        }
    }
        fun openProductDetail(product: Product, onNavigate: (Product) -> Unit) {

            viewModelScope.launch {

                loading.value = true

                delay(2000) // simulate API delay

                loading.value = false

                onNavigate(product)
            }
        }
    }

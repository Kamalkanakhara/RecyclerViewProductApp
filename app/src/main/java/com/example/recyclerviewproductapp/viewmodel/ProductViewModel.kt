package com.example.recyclerviewproductapp.viewmodel

import androidx.lifecycle.*
import com.example.recyclerviewproductapp.Product
import com.example.recyclerviewproductapp.data.ProductRepository
import kotlinx.coroutines.*

class ProductViewModel : ViewModel() {

    private val repository = ProductRepository()

    val products = MutableLiveData<List<Product>>()
    private val _uiState = MutableLiveData<UiState<List<Product>>>()
    val uiState: LiveData<UiState<List<Product>>> = _uiState

    fun fetchProducts() {

        viewModelScope.launch {

            _uiState.value = UiState.Loading

            try {

                val result = repository.getProducts()

                _uiState.value = result

            } catch (e: Exception) {
                _uiState.value = UiState.Error("Failed to load products")

            }
        }
    }
    }

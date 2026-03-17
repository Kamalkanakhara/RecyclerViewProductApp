package com.example.recyclerviewproductapp.viewmodel

import androidx.lifecycle.*
import com.example.recyclerviewproductapp.Product
import com.example.recyclerviewproductapp.data.ProductEntity
import com.example.recyclerviewproductapp.data.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
        private val repository: ProductRepository
) : ViewModel() {

    val products =  repository.getCachedProducts()
        .map { entityList ->
            entityList.map { entity ->
                Product(
                    id = entity.id,
                    title = entity.title,
                    price = entity.price,
                    image = entity.image
                )
            }
        }
        .asLiveData()
    private val _uiState = MutableLiveData<UiState<List<ProductEntity>>>()
    val uiState: LiveData<UiState<List<ProductEntity>>> = _uiState

    fun fetchProducts() {

        viewModelScope.launch {
            _uiState.value = UiState.Loading
            val result = repository.fetchProducts()

            _uiState.value = result
        }
    }
    }

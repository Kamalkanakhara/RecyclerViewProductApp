package com.example.recyclerviewproductapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.recyclerviewproductapp.Product
import com.example.recyclerviewproductapp.data.ProductRepository

class ProductViewModel : ViewModel() {

    private val repository = ProductRepository()

    fun getProducts(): List<Product> {
        return repository.getProducts()
    }

}
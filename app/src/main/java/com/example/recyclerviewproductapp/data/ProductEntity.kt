package com.example.recyclerviewproductapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(

    @PrimaryKey
    val id: Int,

    val title: String,
    val price: Double,
    val image: String
)
package com.example.recyclerviewproductapp.data

import com.example.recyclerviewproductapp.Product

class ProductRepository {

    fun getProducts(): List<Product> {

        return listOf(
            Product(1,"Laptop",55000.0),
            Product(2,"Smartphone",20000.0),
            Product(3,"Headphones",2000.0),
            Product(4,"Smart Watch",3500.0),
            Product(5,"Bluetooth Speaker",1800.0),
            Product(6,"Gaming Mouse",1200.0),
            Product(7,"Mechanical Keyboard",4500.0),
            Product(8,"Monitor 24 inch",12000.0),
            Product(9,"Power Bank",1500.0)
        )

    }

}
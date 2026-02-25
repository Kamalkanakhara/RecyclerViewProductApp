package com.example.recyclerviewproductapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewproductapp.adapter.ProductAdapter
import com.example.recyclerviewproductapp.databinding.ActivityMainBinding
import com.example.recyclerviewproductapp.Product

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ProductAdapter { product ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", product.name)
            intent.putExtra("price", product.price)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        val productList = listOf(
            Product(1, "Laptop", 55000.0),
            Product(2, "Smartphone", 20000.0),
            Product(3, "Headphones", 2000.0),
            Product(4, "Smart Watch", 3500.0),
            Product(5, "Bluetooth Speaker", 1800.0),
            Product(6, "Gaming Mouse", 1200.0),
            Product(7, "Mechanical Keyboard", 4500.0),
            Product(8, "Monitor 24 inch", 12000.0),
            Product(9, "Power Bank", 1500.0),
            Product(10, "External Hard Disk 1TB", 5200.0)
        )

        adapter.submitList(productList)
    }
}
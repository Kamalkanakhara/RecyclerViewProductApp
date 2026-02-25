package com.example.recyclerviewproductapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerviewproductapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val price = intent.getDoubleExtra("price", 0.0)

        binding.tvName.text = name
        binding.tvPrice.text = "₹$price"
    }
}
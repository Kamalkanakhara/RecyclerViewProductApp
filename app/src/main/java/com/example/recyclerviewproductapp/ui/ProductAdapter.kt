package com.example.recyclerviewproductapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewproductapp.databinding.ItemProductBinding
import com.example.recyclerviewproductapp.Product
import com.bumptech.glide.Glide

class ProductAdapter(
    private val onClick: (Product) -> Unit,
    private val onAddToCartClick: (Product)-> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var productList = listOf<Product>()

    fun submitList(list: List<Product>) {
        productList = list
        notifyDataSetChanged()
    }

    inner class ProductViewHolder(val binding: ItemProductBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductViewHolder(binding)
    }

    override fun getItemCount() = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val product = productList[position]

        holder.binding.tvProductName.text = product.title
        holder.binding.tvProductPrice.text = "Rs${product.price}"
        Glide.with(holder.itemView.context)
            .load(product.image)
            .into(holder.binding.ProductImage)

        holder.itemView.setOnClickListener {
            onClick(product)
        }
        holder.binding.btnAddToCart.setOnClickListener {
            onAddToCartClick(product)
        }
    }
}
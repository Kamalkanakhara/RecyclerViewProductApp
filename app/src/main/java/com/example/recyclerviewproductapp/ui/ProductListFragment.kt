package com.example.recyclerviewproductapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewproductapp.adapter.ProductAdapter
import com.example.recyclerviewproductapp.databinding.FragmentProductListBinding
import com.example.recyclerviewproductapp.viewmodel.ProductViewModel
import com.example.recyclerviewproductapp.viewmodel.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() {

    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProductViewModel by viewModels()
    private lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProductListBinding.inflate(inflater, container, false)

        adapter = ProductAdapter (
            onClick = { product ->

                val action =
                    ProductListFragmentDirections
                        .actionListToDetail(
                            product.id,
                            product.title,
                            product.price.toFloat(),
                            product.image
                        )
                findNavController().navigate(action)
        },
            onAddToCartClick = { product ->
                Toast.makeText(
                    requireContext(),
                    "${product.title} Added to cart",
                    Toast.LENGTH_LONG
                ).show()
            }
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        if (savedInstanceState == null) {
            viewModel.fetchProducts()
        }

        viewModel.products.observe(viewLifecycleOwner) { list ->
            if (list.isEmpty()) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
            adapter.submitList(list)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
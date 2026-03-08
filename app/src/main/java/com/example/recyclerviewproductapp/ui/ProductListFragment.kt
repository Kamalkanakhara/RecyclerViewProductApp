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

        adapter = ProductAdapter { product ->
            viewModel.openProductDetail(product) {
                val action =
                    ProductListFragmentDirections
                        .actionListToDetail(
                            product.id,
                            product.title,
                            product.price.toFloat()
                        )

                findNavController().navigate(action)
            }

        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        viewModel.fetchProducts()

        viewModel.products.observe(viewLifecycleOwner) {

            adapter.submitList(it)

        }

        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->

            binding.progressBar.visibility =
                if (isLoading) View.VISIBLE else View.GONE
        }

        viewModel.error.observe(viewLifecycleOwner) {

            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()

        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
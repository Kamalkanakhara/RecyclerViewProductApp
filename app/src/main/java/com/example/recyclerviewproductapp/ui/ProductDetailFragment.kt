package com.example.recyclerviewproductapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.recyclerviewproductapp.databinding.FragmentProductDetailBinding
import com.bumptech.glide.Glide

class ProductDetailFragment : Fragment() {

    private var _binding: FragmentProductDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)

        val args = ProductDetailFragmentArgs.fromBundle(requireArguments())
        val name = args.productName
        val price = args.productPrice

        binding.tvDetail.text = "$name"
        binding.tvProductPrice.text="Rs$price"
        Glide.with(requireContext())
            .load(args.productImage)
            .into(binding.productImage)
        binding.backbutton.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
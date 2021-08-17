package com.example.trabalho_001.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.trabalho_001.R
import com.example.trabalho_001.databinding.FragmentProductDetailsBinding
import com.example.trabalho_001.interfaces.ClickableItem
import com.example.trabalho_001.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductDetailsFragment() : Fragment(R.layout.fragment_product_details) {

    private lateinit var binding : FragmentProductDetailsBinding

    companion object {
        fun newInstance() = ProductDetailsFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProductDetailsBinding.bind(view)

        val arguments = arguments?.getSerializable("idProduto") as Product

        loadProductInfo(arguments)

    }

    private fun loadProductInfo(product: Product) {

        binding.logoproductImageView.apply {
            Glide.with(context)
                .load(product.image)
                .into(this)
        }

        binding.tituloTextView.apply {
            text = product.title
        }

        binding.precoTextView.apply {
            text = product.price.toString()
        }

        binding.subtituloTextView.apply {
            text = product.category
        }

        binding.descricaoTextView.apply {
            text = product.description
        }

    }

}
package com.example.trabalho_001.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trabalho_001.R
import com.example.trabalho_001.adapter.ProductAdapter
import com.example.trabalho_001.interfaces.ClickableItem
import com.example.trabalho_001.model.Product
import com.example.trabalho_001.service.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductFragment : Fragment(R.layout.fragment_list_products), Callback<List<Product>>, ClickableItem {

    private lateinit var recyclerView: RecyclerView
    private val adapter = ProductAdapter(this)
    private val productsCall by lazy {
        RetrofitBuilder.getProductServices().getProducts()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.productsRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)
        recyclerView.adapter = adapter

    }

    private fun fetchProducts() {
        productsCall.clone().enqueue(this)
    }

    override fun onResume() {
        super.onResume()
        fetchProducts()
    }

    override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
        response.body()?.apply {
            adapter.update(this)
        }
    }

    override fun onFailure(call: Call<List<Product>>, t: Throwable) {
        TODO("Not yet implemented")
    }

    override fun onClickGoToDetail(product: Product) {

        val bundle = Bundle()

        bundle.putSerializable("idProduto", product)

        val fragment = ProductDetailsFragment.newInstance()

        fragment.arguments = bundle

        requireActivity()
            .supportFragmentManager
            .beginTransaction()
            .hide(this)
            .add(R.id.containerFrame, fragment)
            .addToBackStack(null)
            .commit()

    }


}
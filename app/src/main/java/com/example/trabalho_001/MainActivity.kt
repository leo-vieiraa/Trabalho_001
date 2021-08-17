package com.example.trabalho_001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trabalho_001.adapter.ProductAdapter
import com.example.trabalho_001.databinding.ActivityMainBinding
import com.example.trabalho_001.databinding.ActivityMainBinding.*
import com.example.trabalho_001.fragments.ProductFragment
import com.example.trabalho_001.model.Product
import com.example.trabalho_001.service.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = inflate(layoutInflater)

        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFrame, ProductFragment())
            .commitNow()

    }


}
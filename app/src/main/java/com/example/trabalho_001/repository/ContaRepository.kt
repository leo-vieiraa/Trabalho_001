package com.example.trabalho_001.repository

import com.example.trabalho_001.model.Conta
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.FirebaseFirestore

class ContaRepository {

//    private val dataBase = Firebase.firestore
    private val dataBase = FirebaseFirestore.getInstance()

//    private val dataBase = FirebaseFirestore.getInstance()

    fun fetchContas(callback: (List<Conta>?, String?) -> Unit) {
        dataBase.collection("contas")
            .get()
            .addOnSuccessListener { result ->

                val listOf = arrayListOf<Conta>()
                result.forEach {
                    val conta = Conta.fromData(it)
                    listOf.add(conta)
                }
                callback(listOf, null)

            }
            .addOnFailureListener { exception ->
                callback(null, exception.message)
            }
    }


}
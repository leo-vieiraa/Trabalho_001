package com.example.trabalho_001.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trabalho_001.repository.AuthenticationRepository
import com.google.firebase.auth.FirebaseUser

class MainViewModel : ViewModel() {

    private val _user = MutableLiveData<FirebaseUser?>()
    var user: LiveData<FirebaseUser?> = _user

    private val repository = AuthenticationRepository()

    fun createNewAccount(email: String, password: String) {
        repository.createAccountWithEmailPassword(email, password) { firebaseUser, error ->
            _user.value = firebaseUser
        }

    }

}
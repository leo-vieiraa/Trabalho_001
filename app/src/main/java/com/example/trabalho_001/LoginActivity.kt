package com.example.trabalho_001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.trabalho_001.model.Credentials
import com.example.trabalho_001.model.LoginResponse
import com.example.trabalho_001.service.RetrofitBuilder
import com.example.trabalho_001.utils.snackBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity(), Callback<LoginResponse> {

    private lateinit var inputEmail: EditText
    private lateinit var inputSenha: EditText
    private lateinit var buttonEntrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loadComponents()
        loadEvents()

    }

    private fun loadComponents() {
        inputEmail = findViewById(R.id.inputEmail)
        inputSenha = findViewById(R.id.inputPassword)
        buttonEntrar = findViewById(R.id.buttonEntrar)
    }

    private fun loadEvents() {
        // Add evento de click no botao de entrar
        buttonEntrar.setOnClickListener {
            fazerLogin()
        }
    }

    private fun fazerLogin() {

        val email = inputEmail.text.toString()
        val senha = inputSenha.text.toString()

        val credentials = Credentials(email, senha)
        if (credentials.checkPassword() && credentials.checkUserName()) {
            dispararRequestLogin(credentials)
        } else {
            snackBar(inputEmail, R.string.usuario_invalido)
        }
    }

    private fun dispararRequestLogin(credentials: Credentials) {
        val interfaceDeAuthImplementada = RetrofitBuilder.getAuthenticationServices()
        val call = interfaceDeAuthImplementada.login(credentials)
        call.clone().enqueue(this)
    }

    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
        if (response.body() != null) {
            val loginResponse = response.body()!!
            if (loginResponse.isError()) {
                snackBar(inputEmail, R.string.usuario_invalido)
            } else {
                Intent(this, MainActivity::class.java).apply {
                    startActivity(this)
                }
            }
        } else {
            snackBar(inputEmail, R.string.usuario_invalido)
        }
    }

    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
        snackBar(inputEmail, R.string.usuario_invalido)
    }


}
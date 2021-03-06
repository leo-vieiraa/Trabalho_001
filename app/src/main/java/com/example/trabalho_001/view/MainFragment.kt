package com.example.trabalho_001.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.trabalho_001.MainActivity
import com.example.trabalho_001.R
import com.example.trabalho_001.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseUser

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private val observerNewUser = Observer<FirebaseUser?> {
        Snackbar.make(requireView(), "Usuário criado com sucesso!!!!", Snackbar.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        /**
         * Add observers
         */
        viewModel.user.observe(viewLifecycleOwner, observerNewUser)

        /**
         * Add eventos nos componentes da tela
         */
        view.findViewById<Button>(R.id.saveButton).setOnClickListener {
            val inputEmail = view.findViewById<EditText>(R.id.inputEmailEditText)
            val inputPassword = view.findViewById<EditText>(R.id.inputPasswordEditText)
            if (!inputEmail.text.isNullOrEmpty() && !inputPassword.text.isNullOrEmpty()) {
                viewModel.createNewAccount(
                    inputEmail.text.toString(),
                    inputPassword.text.toString()
                )
            }
        }

        view.findViewById<View>(R.id.backButton).setOnClickListener {
            (requireActivity() as? MainActivity)?.replaceView(SignInFragment.newInstance())
        }
    }
}
package com.example.houzzii

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class LoginActivity : AppCompatActivity() {
    private lateinit var firebase : FirebaseAuth
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etEmail = findViewById(R.id.email_login)
        firebase = FirebaseAuth.getInstance()
        etPassword = findViewById(R.id.password_login)

        var btnIntentTiga = findViewById(R.id.register_button) as Button
        btnIntentTiga.setOnClickListener {
            Log.e("test","terklik")
            val toRegister = Intent(this,RegisterActivity::class.java)
            startActivity(toRegister)
        }

        var btnIntentDua = findViewById(R.id.submit_text) as Button
        btnIntentDua.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            loginFirebase(email,password)



        }
    }

    fun loginFirebase(email: String,password: String)  {
        firebase.signInWithEmailAndPassword(email,password).addOnSuccessListener{
            val toHome = Intent(this,MenuPesan::class.java)
            startActivity(toHome)
        }

    }
}
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

class RegisterActivity : AppCompatActivity() {
    private lateinit var firebase: FirebaseAuth
    private lateinit var etNama: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var firestore: FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        firebase = FirebaseAuth.getInstance()
        etEmail = findViewById(R.id.full_email)
        etNama = findViewById(R.id.full_name)
        firestore = FirebaseFirestore.getInstance()
        etPassword = findViewById(R.id.full_password)

        var btnIntentdaftar = findViewById(R.id.register) as Button
        var btnIntentLogin = findViewById(R.id.login_kembali) as Button

        btnIntentdaftar.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val nama = etNama.text.toString()
            registerFirebase(email,password,nama)
        }
        btnIntentLogin.setOnClickListener {
            val toLoginActivity = Intent(this,LoginActivity::class.java)
            startActivity(toLoginActivity)
        }
    }
    fun registerFirebase(email: String,password: String,nama: String){
        firebase.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
            val data = hashMapOf(
                "nama" to nama,
                "email" to email,
            )
            firestore.collection("user").add(data).addOnSuccessListener {
                startActivity(Intent(this, LoginActivity::class.java))
                Toast.makeText(this, "Register Berhasil", Toast.LENGTH_LONG).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Gagal Daftar", Toast.LENGTH_SHORT).show()
        }

    }
}
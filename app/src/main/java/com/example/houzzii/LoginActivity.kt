package com.example.houzzii

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var btnIntentDua = findViewById(R.id.masuk) as Button
        var btnIntentTiga = findViewById(R.id.ke_daftar) as Button

        btnIntentDua.setOnClickListener {
            startActivity(Intent(this, MenuPesan::class.java))
            Toast.makeText(this, "Happy Holiday", Toast.LENGTH_LONG).show()

        btnIntentTiga.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        }
    }
}
package com.example.houzzii

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PemesananHotel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemesanan_hotel)

        var btnIntent = findViewById(R.id.PesanHotel) as Button
        btnIntent.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            Toast.makeText(this, "Berhasil Booking Hotel", Toast.LENGTH_SHORT).show()
        }
    }
}
package com.example.houzzii
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MenuPesan : AppCompatActivity(){
    override fun onCreate (savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_pesan)

        var imgProfil = findViewById(R.id.imgProfil) as ImageView

        imgProfil.setOnClickListener {
            startActivity(Intent(this, Profile::class.java))
        }

        var imgHistory = findViewById(R.id.imgHistory) as ImageView

        imgHistory.setOnClickListener {
            startActivity(Intent(this, Riwayat::class.java))
        }

        var imgPHotel = findViewById(R.id.imgHotel) as ImageView

        imgPHotel.setOnClickListener {
            startActivity(Intent(this, PemesananHotel::class.java))
        }

        var btnSignOut = findViewById(R.id.sign_out) as Button

        btnSignOut.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            Toast.makeText(this@MenuPesan,"Sign Out Berhasil", Toast.LENGTH_LONG).show()
        }
    }
}
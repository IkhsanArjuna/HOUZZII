package com.example.houzzii

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PemesananHotel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemesanan_hotel)

        val actionBar = supportActionBar

        actionBar!!.title = "hotel"

        actionBar.setDisplayHomeAsUpEnabled(true)

        val spinners = findViewById(R.id.spKamar) as Spinner
        val spinner1 = findViewById(R.id.spJenisKamar) as Spinner
        val nama = findViewById(R.id.txtNama) as EditText
        val checkin = findViewById(R.id.idCheckIn) as EditText
        val checkout = findViewById(R.id.idCheckOut) as EditText

        ArrayAdapter.createFromResource(
            this, R.array.spKamar, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinners.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            this, R.array.spJenisKamar, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner1.adapter = adapter
        }

        val btnIntent = findViewById(R.id.PesanHotel) as Button
        btnIntent.setOnClickListener{
            val nama = nama.text.toString()
            val spinners = spinners.selectedItem.toString()
            val checkin = checkin.text.toString()
            val checkout = checkout.text.toString()
            val spinner1 = spinner1.selectedItem.toString()

            val intent = Intent(this, Riwayat::class.java)
            intent.putExtra("nama", nama)
            intent.putExtra("jumlah kamar", spinners)
            intent.putExtra("checkin", checkin)
            intent.putExtra("checkout", checkout)
            intent.putExtra("jenis kamar", spinner1)

            startActivity(Intent(this, Riwayat::class.java))
            Toast.makeText(this, "Berhasil Booking Hotel", Toast.LENGTH_SHORT).show()
        }
    }
}
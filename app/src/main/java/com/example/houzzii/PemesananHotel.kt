package com.example.houzzii

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class PemesananHotel : AppCompatActivity() {
    lateinit var firebase : FirebaseFirestore
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemesanan_hotel)
        firebase = FirebaseFirestore.getInstance()
        firebaseAuth = FirebaseAuth.getInstance()

        val actionBar = supportActionBar

        actionBar!!.title = "hotel"

        actionBar.setDisplayHomeAsUpEnabled(true)

        val spinners = findViewById(R.id.spKamar) as Spinner
        val spinner1 = findViewById(R.id.tvJenisKamar) as Spinner
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

        val btnIntent = findViewById<Button>(R.id.PesanHotel)
        btnIntent.setOnClickListener{
            val nama = nama.text.toString()
            val spinners = spinners.selectedItem.toString().toInt()
            val checkin = checkin.text.toString()
            val checkout = checkout.text.toString()
            val spinner1 = spinner1.selectedItem.toString()
            val data = hashMapOf(
                "email" to firebaseAuth.currentUser!!.email,
                "idChekin" to checkin,
                "idChekout" to checkout,
                "spJenisKamar" to spinner1,
                "spKamar" to spinners,
                "txtNama" to nama


            )
            firebase.collection("pesan_kamar").add(
                data).addOnSuccessListener {

                Toast.makeText(this, "Berhasil Booking Hotel", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, Riwayat::class.java))

            }.addOnFailureListener {
                Toast.makeText(this, "Gagal Booking", Toast.LENGTH_SHORT).show()
            }



        }
    }
}
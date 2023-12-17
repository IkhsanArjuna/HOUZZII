package com.example.houzzii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class Riwayat : AppCompatActivity() {
    private lateinit var revylerData: RecyclerView
    private lateinit var firestore: FirebaseFirestore
    private lateinit var viewModel: RiwayatViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_riwayat)
        viewModel = ViewModelProvider(this)[RiwayatViewModel::class.java]
        revylerData = findViewById(R.id.recyclerViewRiwayat)
        firestore = FirebaseFirestore.getInstance()

        GlobalScope.launch { getDataFromFirestore() }

        viewModel.listReview.observe(this){newValue ->
            revylerData.layoutManager = LinearLayoutManager(this)
            revylerData.adapter = AdapterRiwayat(newValue)
        }





    }
    suspend fun getDataFromFirestore(){
        val data = firestore.collection("pesan_kamar").get().await()
        withContext(Dispatchers.IO){
            data?.let { document ->
                val listKamar = document.map { doc ->
                    RiwayatModel(
                        doc.getString("txtNama")?: "",
                        (doc["spKamar"] as? Number)?.toInt()?: 0,
                        doc.getString("idChekin")?: "",
                        doc.getString("idChekout")?:"",
                        doc.getString("spJenisKamar")?:""

                    )
                }
                viewModel._listRiwayat.postValue(listKamar.toMutableList())
            }
        }
    }
}
package com.example.houzzii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


class Profile : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var firestore: FirebaseFirestore
    lateinit var viewModel: ProfileViewModel
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        recyclerView = findViewById(R.id.recycler_profil)
        firestore = FirebaseFirestore.getInstance()
        firebaseAuth = FirebaseAuth.getInstance()

        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        GlobalScope.launch {CreateData()
        }
        viewModel.listViewProfile.observe(this){newValue ->
            recyclerView.layoutManager=LinearLayoutManager(
                this
            )
            recyclerView.adapter=AdapterProfile(newValue)
        }


    }
    suspend fun CreateData(){
        val data = firestore.collection("user").whereEqualTo("email",firebaseAuth.currentUser!!.email).get().await()
        withContext(Dispatchers.IO){
            data?.let { document ->
                val listuser= document.map { doc->
                    ProfileModel(
                        doc.getString("nama")?:"",
                        doc.getString("email")?:""

                    )
                }
                viewModel._listProfile.postValue(listuser.toMutableList())
            }
        }
    }
}

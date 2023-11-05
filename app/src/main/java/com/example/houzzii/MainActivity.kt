package com.example.houzzii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var recyclerView : RecyclerView? = null
    private var recyclerViewAdapter : RecyclerViewAdapter? = null
    private var kamarList = mutableListOf<DataKamar>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kamarList = ArrayList()

        recyclerView = findViewById<View>(R.id.rvkamar) as RecyclerView
        recyclerViewAdapter = RecyclerViewAdapter(this@MainActivity, kamarList)
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = recyclerViewAdapter

        prepareKamarListData()
    }

    private fun prepareKamarListData() {
        var kamar = DataKamar("Single Room", R.drawable.single_room)
        kamarList.add(kamar)
        kamar = DataKamar("Twin Room", R.drawable.single_room)
        kamarList.add(kamar)
        kamar = DataKamar("Twin Room", R.drawable.single_room)
        kamarList.add(kamar)
        kamar = DataKamar("Twin Room", R.drawable.single_room)
        kamarList.add(kamar)
        kamar = DataKamar("Twin Room", R.drawable.single_room)
        kamarList.add(kamar)
        kamar = DataKamar("Twin Room", R.drawable.single_room)
        kamarList.add(kamar)
        kamar = DataKamar("Twin Room", R.drawable.single_room)
        kamarList.add(kamar)
        kamar = DataKamar("Twin Room", R.drawable.single_room)
        kamarList.add(kamar)
        kamar = DataKamar("Twin Room", R.drawable.single_room)
        kamarList.add(kamar)
        kamar = DataKamar("Twin Room", R.drawable.single_room)
        kamarList.add(kamar)

        recyclerViewAdapter!!.notifyDataSetChanged()

    }
}
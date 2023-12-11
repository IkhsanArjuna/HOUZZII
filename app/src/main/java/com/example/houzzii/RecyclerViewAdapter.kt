package com.example.houzzii

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter constructor(private val getActivity: MainActivity, private val kamarList :
    List<DataKamar>) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_recyclerview, parent, false)
        return MyViewHolder(view)
    }
    override fun getItemCount(): Int {
        return kamarList.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvKamar.text = kamarList[position].title
        holder.ivKamar.setImageResource(kamarList[position].image)
        holder.cardView.setOnClickListener {
            Toast.makeText(getActivity, kamarList[position].title, Toast.LENGTH_LONG).show()
        }
    }
    class MyViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        val tvKamar : TextView = itemView.findViewById(R.id.tvKamar)
        val ivKamar : ImageView = itemView.findViewById(R.id.ivKamar)
        val cardView : CardView = itemView.findViewById(R.id.cardView)
    }
}
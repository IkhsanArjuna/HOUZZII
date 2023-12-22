package com.example.houzzii

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterProfile(val list: List<ProfileModel>) : RecyclerView.Adapter<AdapterProfile.ViewHolder>() {

    class ViewHolder(baris: View): RecyclerView.ViewHolder(baris){
        val profileNama = baris.findViewById<TextView>(R.id.profile_nama)
        val profileEmail =baris.findViewById<TextView>(R.id.profile_email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.profile,parent,false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = list[position]
        holder.profileNama.text=binding.nama
        holder.profileEmail.text=binding.email

    }

}
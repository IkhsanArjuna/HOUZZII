package com.example.houzzii

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterRiwayat(val list: List<RiwayatModel>): RecyclerView.Adapter<AdapterRiwayat.RiwayatViewHolder>() {

    class RiwayatViewHolder(baris: View):RecyclerView.ViewHolder(baris){
        val tvNama = baris.findViewById<TextView>(R.id.tvNama)
        val tvJumlahKamar = baris.findViewById<TextView>(R.id.tvJumlahKamar)
        val tvCheckIn = baris.findViewById<TextView>(R.id.tvCheckIn)
        val tvCheckOut = baris.findViewById<TextView>(R.id.tvCheckOut)
        val tvJenisKamar = baris.findViewById<TextView>(R.id.tvJenisKamar)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiwayatViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.activity_riwayat,parent,false)
        return  RiwayatViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RiwayatViewHolder, position: Int) {
        val bind = list[position]
        holder.tvCheckIn.text = bind.checkIn
        holder.tvCheckOut.text = bind.checkOut
        holder.tvJenisKamar.text = bind.jenisKamar
        holder.tvJumlahKamar.text = bind.jumlahhKamar.toString()
        holder.tvNama.text = bind.nama
    }

}
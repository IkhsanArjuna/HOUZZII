package com.example.houzzii

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// kelas AdapterRiwayat. Kelas ini menerima sebuah List dari RiwayatModel sebagai parameter konstruktor dan
// merupakan subclass dari RecyclerView.
class AdapterRiwayat(val list: List<RiwayatModel>): RecyclerView.Adapter<AdapterRiwayat.RiwayatViewHolder>() {

    //Mendefinisikan kelas RiwayatViewHolder sebagai subclass dari RecyclerView.ViewHolder.
    // Kelas ini  untuk menyimpan elemen-elemen tampilan yang akan ditampilkan dalam setiap baris item dalam tampilan riwayat.
    class RiwayatViewHolder(baris: View):RecyclerView.ViewHolder(baris){
        val tvNama = baris.findViewById<TextView>(R.id.tvNama)
        val tvJumlahKamar = baris.findViewById<TextView>(R.id.tvJumlahKamar)
        val tvCheckIn = baris.findViewById<TextView>(R.id.tvCheckIn)
        val tvCheckOut = baris.findViewById<TextView>(R.id.tvCheckOut)
        val tvJenisKamar = baris.findViewById<TextView>(R.id.tvJenisKamar)

    }
// Metode ini bertanggung jawab untuk membuat dan menginisialisasi ViewHolder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiwayatViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.activity_riwayat,parent,false)
        return  RiwayatViewHolder(layout)
    }

    // Method ini mengembalikan jumlah total item yang akan ditampilkan, yaitu ukuran dari list.
    override fun getItemCount(): Int {
        return list.size
    }
//Method ini dipanggil untuk menampilkan data pada posisi tertentu.
// Method ini mengikat data dari RiwayatModel ke RiwayatViewHolder pada posisi tertentu dalam RecyclerView.
// Data dari RiwayatModel diambil berdasarkan posisi, kemudian diatur ke masing-masing elemen TextView dalam RiwayatViewHolder.
    override fun onBindViewHolder(holder: RiwayatViewHolder, position: Int) {
        val bind = list[position]
        holder.tvCheckIn.text = bind.checkIn
        holder.tvCheckOut.text = bind.checkOut
        holder.tvJenisKamar.text = bind.jenisKamar
        holder.tvJumlahKamar.text = bind.jumlahhKamar.toString()
        holder.tvNama.text = bind.nama
    }

}
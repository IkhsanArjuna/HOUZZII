package com.example.houzzii

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RiwayatViewModel : ViewModel() {
    var _listRiwayat: MutableLiveData<MutableList<RiwayatModel>> = MutableLiveData(listRiwayat)

    val listReview: LiveData<MutableList<RiwayatModel>>
        get() = _listRiwayat
}
package com.example.houzzii

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    var _listProfile: MutableLiveData<MutableList<ProfileModel>> = MutableLiveData(listProfile)

    val listViewProfile: LiveData<MutableList<ProfileModel>>
        get() = _listProfile
}
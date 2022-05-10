package com.example.testproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GiverScoreViewModel : ViewModel() {

    var item_name = MutableLiveData("")
    var item_description = MutableLiveData("")
    var user_rating = MutableLiveData("")
}
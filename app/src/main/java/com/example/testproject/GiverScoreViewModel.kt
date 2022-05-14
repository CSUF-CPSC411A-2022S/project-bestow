package com.example.testproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GiverScoreViewModel : ViewModel() {
//A planned view model that was scrapped. It was going to use LiveData.
    var item_name = MutableLiveData("")
    var item_description = MutableLiveData("")
    var user_rating = MutableLiveData("")
}
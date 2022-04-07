package com.example.lifecycleofandroidcomponents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReceiverViewModel : ViewModel() {

    var message: LiveData<String> = MutableLiveData()

    fun setMessage(str: String) {
        (message as? MutableLiveData)?.value = str
    }
}
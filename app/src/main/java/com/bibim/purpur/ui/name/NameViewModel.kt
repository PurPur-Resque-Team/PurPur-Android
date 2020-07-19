package com.bibim.purpur.ui.name

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bibim.purpur.data.repository.NameRepository
import com.google.gson.JsonObject

class NameViewModel(private val nameRepository: NameRepository) : ViewModel() {
    val token = MutableLiveData<String>()
    val signUpError = MutableLiveData<String>()

    fun signUp(userName: JsonObject) {
        nameRepository.signUp(userName, success = {
            token.value = it.data.token
        }, fail = {
            signUpError.value = it.message
        })

    }
}
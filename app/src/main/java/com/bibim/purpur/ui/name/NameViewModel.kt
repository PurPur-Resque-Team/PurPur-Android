package com.bibim.purpur.ui.name

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bibim.purpur.data.model.UserIdx
import com.bibim.purpur.data.repository.NameRepository
import com.google.gson.JsonObject

class NameViewModel(private val nameRepository: NameRepository) : ViewModel() {
    val token = MutableLiveData<String>()
    val signUpError = MutableLiveData<String>()
    val userNameStatus = MutableLiveData<Int>()


    fun signUp(userName: JsonObject) {
        nameRepository.signUp(userName, success = {
            token.value = it.data.token
        }, fail = {
            signUpError.value = it.message
        })

    }

    fun putUserName(userName: String){
        nameRepository.putUserName(userName, success = {
            Log.e("통신성공", it.toString())
            userNameStatus.postValue(it.status)
        }, fail ={
            Log.e("통신실패", it.message)
        })
    }
}
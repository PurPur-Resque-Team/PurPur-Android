package com.bibim.purpur.ui.islandSelect

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bibim.purpur.data.model.IslandList
import com.bibim.purpur.data.repository.IslandListRepository

class IslandSelectViewModel(private val islandListRepository: IslandListRepository) : ViewModel(){

    private var _islandList = MutableLiveData<List<IslandList>>()
    val islandList : LiveData<List<IslandList>> get() = _islandList

    fun getIslandList() {
        islandListRepository.getIslandList(success = {
            Log.e("getIslandInfo : ", it.data.toString())
            _islandList.postValue(it.data)
        }, fail = {
            Log.e("통신 실패 error : ", it.message!!)
        })
    }
}
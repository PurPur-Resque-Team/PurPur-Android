package com.bibim.purpur.ui.island

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bibim.purpur.data.model.AnimalInfo
import com.bibim.purpur.data.model.IslandInfo
import com.bibim.purpur.data.model.IslandInfoResponse
import com.bibim.purpur.data.repository.IslandRepository

class IslandViewModel(private val islandRepository: IslandRepository) : ViewModel() {

    val islandInfo = MutableLiveData<IslandInfo>()
    private var _animalList = MutableLiveData<List<AnimalInfo>>()
    val animalList : LiveData<List<AnimalInfo>> get() = _animalList

    fun getIslandInfo(islandIdx: Int) {
        islandRepository.getIslandInfo(islandIdx, success = {
            Log.e("getIslandInfo : ", it.data.toString())
            islandInfo.postValue(it.data)
            _animalList.postValue(it.data.animals)
        }, fail = {
            Log.e("통신 실패 error : ", it.message!!)
        })
    }
}
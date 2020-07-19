package com.bibim.purpur.ui.detail.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bibim.purpur.data.model.MissionAndAnimalResponse
import com.bibim.purpur.data.model.MissionClearResponse
import com.bibim.purpur.data.repository.DetailRepository
import com.bibim.purpur.ui.Loading
import com.google.gson.JsonObject

class DetailViewModel(private val detailRepository: DetailRepository) : ViewModel() {
    val missionAndAnimalStatus = MutableLiveData<MissionAndAnimalResponse>()
    val missionAndAnimalError = MutableLiveData<String>()
    val missionClearResponse = MutableLiveData<MissionClearResponse>()
    val missionClearResponseError = MutableLiveData<String>()

    fun getMissionsAndAnimalInformation(animalIdx: Int) {
        detailRepository.getMissionsAndAnimal(
            animalIdx,
            success = {
                missionAndAnimalStatus.value = it
                Loading.exitLoading()
            }, fail = {
                missionAndAnimalError.value = it.message
                Loading.exitLoading()
            }
        )
    }

    fun clearMission(animalIdx: Int, missionIdx: JsonObject) {
        detailRepository.clearMission(animalIdx, missionIdx,
            success = {
                missionClearResponse.value = it
                Loading.exitLoading()
            }, fail = {
                missionClearResponseError.value = it.message
                Loading.exitLoading()
            })
    }

}
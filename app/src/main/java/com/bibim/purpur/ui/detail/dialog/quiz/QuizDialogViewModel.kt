package com.bibim.purpur.ui.detail.dialog.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class QuizDialogViewModel : ViewModel() {
    private val _randomNumList = MutableLiveData<Array<Int>>()
    val randomNumList: LiveData<Array<Int>> get() = _randomNumList

    fun getRandomNumbers() {
        val numbers = Array(4) { -1 }

        val random = Random()
        var i = 0
        while (i < 4) {
            numbers[i] = random.nextInt(10)
            var j = 0
            while (j < i) {
                if (numbers[i] == numbers[j]) {
                    i -= 1
                }
                j++
            }
            i++
        }
        _randomNumList.value = numbers
    }
}
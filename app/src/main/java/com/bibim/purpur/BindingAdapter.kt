package com.bibim.purpur

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bibim.purpur.`object`.PURPUR.ANIMAL_STATE_LIST
import com.bibim.purpur.`object`.PURPUR.IslandBg_STATE_LIST
import com.bibim.purpur.`object`.PURPUR.Island_STATE_LIST

@BindingAdapter("setIslandBg")
fun ImageView.setIslandBg(status : Int) {
    if(status==0||status==1) setBackgroundResource(IslandBg_STATE_LIST[status])
    else setBackgroundResource(IslandBg_STATE_LIST[status])
}

@BindingAdapter("setIsland")
fun ImageView.setIsland(status : Int) {
    if(status==0||status==1) setImageResource(Island_STATE_LIST[status])
    else setImageResource(Island_STATE_LIST[2])
}

@BindingAdapter("idx", "status")
fun ImageView.setAnimal(idx: Int, status : Int) {
    Log.e("idx", idx.toString())
    Log.e("status", status.toString())

    setImageResource(ANIMAL_STATE_LIST[idx][status])
}
package com.bibim.purpur.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bibim.purpur.R
import com.bibim.purpur.base.BaseActivity
import com.bibim.purpur.databinding.ActivityLoadingBinding
import kotlinx.android.synthetic.main.activity_loading.*

object Loading {
    lateinit var activity: Activity

    fun goLoading(nowActivityName: Context) {
        val intent = Intent(nowActivityName, LoadingActivity::class.java)
        nowActivityName.startActivity(intent)
    }

    fun exitLoading(){
        activity.finish()
    }
}

class LoadingActivity : BaseActivity<ActivityLoadingBinding>() {
    override val layoutResID: Int
        get() = R.layout.activity_loading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Loading.activity = this

        lottie_ani.run {
            setAnimation("loading.json")
            loop(true)
            playAnimation()
        }
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0, 0)
    }

}
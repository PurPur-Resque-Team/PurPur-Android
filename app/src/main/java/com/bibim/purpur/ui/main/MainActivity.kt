package com.bibim.purpur.ui.main

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import com.bibim.purpur.R
import com.bibim.purpur.base.BaseActivity
import com.bibim.purpur.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :BaseActivity<ActivityMainBinding>() {

    override val layoutResID: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressAnimator = ObjectAnimator.ofInt(act_main_pb,"progress",0,100)
        progressAnimator.duration = 3000
        val ll = LinearInterpolator()
        progressAnimator.interpolator = ll
        progressAnimator.start()
    }


}

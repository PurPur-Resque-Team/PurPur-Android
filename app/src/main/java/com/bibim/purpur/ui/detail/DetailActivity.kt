package com.bibim.purpur.ui.detail

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.LinearInterpolator
import com.bibim.purpur.R
import com.bibim.purpur.base.BaseActivity
import com.bibim.purpur.databinding.ActivityDetailBinding
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity<ActivityDetailBinding>() {
    override val layoutResID: Int = R.layout.activity_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val progressAnimator = ObjectAnimator.ofInt(progressbar,"progress",0,100)
        progressAnimator.duration = 3000
        val ll = LinearInterpolator()
        progressAnimator.interpolator = ll
        progressAnimator.start()

    }
}

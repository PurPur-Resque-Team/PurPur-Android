package com.bibim.purpur.ui.island

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.LinearInterpolator
import com.bibim.purpur.R
import com.bibim.purpur.base.BaseActivity
import com.bibim.purpur.databinding.ActivityIslandBinding
import com.bibim.purpur.ui.name.NameViewModel
import kotlinx.android.synthetic.main.activity_island.*
import org.koin.android.viewmodel.ext.android.viewModel

class IslandActivity :BaseActivity<ActivityIslandBinding>() {

    override val layoutResID: Int = R.layout.activity_island
    private val viewModel: IslandViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_island)

        viewModel.getIslandInfo(65)

        val progressAnimator = ObjectAnimator.ofInt(act_main_pb,"progress",0,100)
        progressAnimator.duration = 3000
        val ll = LinearInterpolator()
        progressAnimator.interpolator = ll
        progressAnimator.start()
    }

}

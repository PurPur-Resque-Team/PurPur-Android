package com.bibim.purpur.ui.island

import android.animation.ObjectAnimator
import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.view.animation.LinearInterpolator
import com.bibim.purpur.R
import com.bibim.purpur.base.BaseActivity
import com.bibim.purpur.databinding.ActivityIslandBinding
import kotlinx.android.synthetic.main.activity_island.*
import org.koin.android.viewmodel.ext.android.viewModel


class IslandActivity :BaseActivity<ActivityIslandBinding>() {

    override val layoutResID: Int = R.layout.activity_island
    private val viewModel: IslandViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding.vm = viewModel

        viewModel.getIslandInfo(65)

        val mediaPlayer = MediaPlayer.create(this, R.raw.purpur_bgm)
        mediaPlayer.isLooping = true
        val manager = this.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        if (!manager.isMusicActive) {
            mediaPlayer.start()
        }

        val progressAnimator = ObjectAnimator.ofInt(act_main_pb,"progress",0,100)
        progressAnimator.duration = 3000
        val ll = LinearInterpolator()
        progressAnimator.interpolator = ll
        progressAnimator.start()
    }

}

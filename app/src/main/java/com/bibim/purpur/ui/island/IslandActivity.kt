package com.bibim.purpur.ui.island

import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.lifecycle.Observer
import com.bibim.purpur.R
import com.bibim.purpur.base.BaseActivity
import com.bibim.purpur.databinding.ActivityIslandBinding
import com.bibim.purpur.ui.Loading
import com.bibim.purpur.ui.detail.main.DetailActivity
import kotlinx.android.synthetic.main.activity_island.*
import org.koin.android.viewmodel.ext.android.viewModel


class IslandActivity :BaseActivity<ActivityIslandBinding>() {

    override val layoutResID: Int = R.layout.activity_island
    private val viewModel: IslandViewModel by viewModel()
    lateinit var animalImageList: List<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Loading.goLoading(this)
        viewDataBinding.vm = viewModel

        viewModel.getIslandInfo(65)

        animalImageList = listOf(
            viewDataBinding.actIslandIvRabbit,
            viewDataBinding.actIslandIvBear,
            viewDataBinding.actIslandIvFox,
            viewDataBinding.actIslandIvMole,
            viewDataBinding.actIslandIvPlant,
            viewDataBinding.actIslandIvDuck
        )

        setClickListener()
        setMusic()
        obseve()
    }

    private fun setMusic(){
        val mediaPlayer = MediaPlayer.create(this, R.raw.purpur_bgm)
        mediaPlayer.isLooping = true
        val manager = this.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        if (!manager.isMusicActive) {
            mediaPlayer.start()
        }
    }

    private fun obseve() {
        viewModel.islandInfo.observe(this, Observer {
            val progressAnimator =
                ObjectAnimator.ofInt(act_main_pb, "progress", 0, it.islandProgress)
            progressAnimator.duration = 5000
            val ll = LinearInterpolator()
            progressAnimator.interpolator = ll
            progressAnimator.start()

            val handler = Handler()
            handler.postDelayed({ Loading.exitLoading() }, 1000)
            Loading.exitLoading()
        })
    }

    private fun setClickListener() {
        for (animalIndex in animalImageList.indices) {
            animalImageList[animalIndex].setOnClickListener {
                val goMission = Intent(this, DetailActivity::class.java)
                goMission.putExtra(
                    "animalIdx",
                    viewModel.animalList.value?.get(animalIndex)!!.animalIdx
                )
                startActivity(goMission)
            }
        }
    }

}

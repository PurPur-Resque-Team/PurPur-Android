package com.bibim.purpur.ui.detail

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bibim.purpur.PURPUR
import com.bibim.purpur.R
import com.bibim.purpur.base.BaseActivity
import com.bibim.purpur.databinding.ActivityDetailBinding
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity<ActivityDetailBinding>() {
    override val layoutResID: Int = R.layout.activity_detail

    private lateinit var vm: DetailViewModel
    lateinit var adapter: CardAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = ViewModelProvider(this).get(DetailViewModel::class.java)

        val progressAnimator = ObjectAnimator.ofInt(progressbar, "progress", 0, 100)
        progressAnimator.duration = 3000
        val ll = LinearInterpolator()
        progressAnimator.interpolator = ll
        progressAnimator.start()

        setMissionRecyclerViewAdapter()

    }

    private fun setMissionRecyclerViewAdapter() {
        adapter = CardAdapter(object : CardViewHolder.MissionItemClickListener {
            override fun missionItemClick(position: Int) {
                act_detail_iv_mission_btn.visibility = View.VISIBLE
                act_detail_iv_mission_img.visibility = View.VISIBLE
                act_detail_tv_mission_text.visibility = View.VISIBLE
                act_detail_tv_mission.visibility = View.GONE
                act_detail_iv_mission_img.setImageResource(PURPUR.MISSION_SELECT_LIST[position].image)
                act_detail_tv_mission_text.text = PURPUR.MISSION_SELECT_LIST[position].text
                act_detail_iv_mission_back.setBackgroundResource(PURPUR.MISSION_SELECT_LIST[position].backGround)
            }
        })
        adapter.setCardItemList(PURPUR.MISSION_IMAGE_LIST)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }
}

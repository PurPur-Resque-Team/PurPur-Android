package com.bibim.purpur.ui.detail.main

import android.animation.ObjectAnimator
import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bibim.purpur.R
import com.bibim.purpur.`object`.PURPUR
import com.bibim.purpur.adapter.CardAdapter
import com.bibim.purpur.adapter.CardViewHolder
import com.bibim.purpur.base.BaseActivity
import com.bibim.purpur.data.model.Mission
import com.bibim.purpur.databinding.ActivityDetailBinding
import com.bibim.purpur.onlyOneClickListener
import com.bibim.purpur.ui.Loading
import com.bibim.purpur.ui.detail.dialog.question.QuestionDialogFragment
import com.bibim.purpur.ui.detail.dialog.quiz.QuizDialogFragment
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : BaseActivity<ActivityDetailBinding>(), DialogInterface.OnDismissListener {
    companion object {
        var selectedCardIdx: Int = -1
        var animalIdx = 111
        var wrongAnswer = -1
    }

    private var beforeGauge = 0
    override val layoutResID: Int = R.layout.activity_detail

     val detailViewModel: DetailViewModel by viewModel()


    private lateinit var adapter: CardAdapter
    private val quizDialogFragment = QuizDialogFragment()
        .getInstance()
    private val questionDialogFragment = QuestionDialogFragment()
        .getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Loading.goLoading(this)
        detailViewModel.getMissionsAndAnimalInformation(animalIdx)
        viewDataBinding.vm = detailViewModel



        setMissionRecyclerViewAdapter()

        observeData()

        setClickListener()
    }

    private fun setClickListener() {
        viewDataBinding.actDetailIvMissionBtn.onlyOneClickListener {
            quizDialogFragment.isCancelable = false
            quizDialogFragment.show(supportFragmentManager, "QUIZ")
        }

        viewDataBinding.actDetailIvQuestion.onlyOneClickListener {
            questionDialogFragment.show(supportFragmentManager, "QUESTION")
        }
    }

    private fun observeData() {
        detailViewModel.missionAndAnimalStatus.observe(this, Observer {
            adapter.setIsClearedList(it.data.missions)
            viewDataBinding.actDetailIvAnimalImg.setImageResource(PURPUR.ANIMAL_DESC[it.data.animalInfo.animalVerify][it.data.animalInfo.animalStatus])
            viewDataBinding.actDetailIvAnimalHead.setImageResource(PURPUR.ANIMAL_SMALL_HEAD[it.data.animalInfo.animalVerify])
            var gauge = 0
            when (it.data.animalInfo.animalStatus) {
                0 -> {
                    gauge = 0
                }
                1 -> {
                    gauge = 31
                }
                2 -> {
                    gauge = 65
                }
                3 -> {
                    gauge = 100
                }
            }
            val progressAnimator = ObjectAnimator.ofInt(progressbar, "progress", beforeGauge, gauge)
            beforeGauge = gauge

            val handler = Handler()
            handler.postDelayed({ Loading.exitLoading() }, 1000)
            Loading.exitLoading()

            // 1단계 : 31 2단계 : 65 3단계 : 100
            progressAnimator.duration = 1000
            val ll = LinearInterpolator()
            progressAnimator.interpolator = ll
            progressAnimator.start()
        })
        detailViewModel.missionAndAnimalError.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            Loading.exitLoading()
        })

        detailViewModel.missionClearResponse.observe(this, Observer {
            if (it.status == 200) {
                Toast.makeText(this, "미션 클리어!", Toast.LENGTH_LONG).show()
//                viewDataBinding.actDetailIvMissionBtn.setImageResource(R.drawable.btn_done_act)
                getBackMissionBg()

                detailViewModel.getMissionsAndAnimalInformation(animalIdx)


            } else {
                Toast.makeText(this, "잘못된 접근입니다!", Toast.LENGTH_LONG).show()
            }
            Loading.exitLoading()

        })

        detailViewModel.missionClearResponseError.observe(this, Observer {
            Toast.makeText(this, "잘못된 접근입니다!", Toast.LENGTH_LONG).show()
            Loading.exitLoading()

        })
    }

    private fun getBackMissionBg() {
        viewDataBinding.actDetailIvMissionBtn.visibility = View.GONE
        viewDataBinding.actDetailIvMissionImg.visibility = View.GONE
        viewDataBinding.actDetailTvMissionText.visibility = View.GONE
        viewDataBinding.actDetailTvMission.visibility = View.VISIBLE
        viewDataBinding.actDetailIvMissionBack.setBackgroundResource(R.drawable.bg_mission_background)
    }

    private fun setMissionRecyclerViewAdapter() {
        adapter = CardAdapter(object :
            CardViewHolder.MissionItemClickListener {
            override fun missionItemClick(position: Int, missions: ArrayList<Mission>) {
                Log.e("iscleared ", missions[position].isCleared.toString())
                selectedCardIdx = missions[position].missionIdx
                when (missions[position].isCleared) {
                    0 -> {
                        viewDataBinding.actDetailIvMissionBtn.setImageResource(R.drawable.btn_done)
                        viewDataBinding.actDetailIvMissionBtn.isClickable = true
                    }
                    1 -> {
                        viewDataBinding.actDetailIvMissionBtn.setImageResource(R.drawable.btn_done_act)
                        viewDataBinding.actDetailIvMissionBtn.isClickable = false
                    }
                }
                viewDataBinding.actDetailIvMissionBtn.visibility = View.VISIBLE
                viewDataBinding.actDetailIvMissionImg.visibility = View.VISIBLE
                viewDataBinding.actDetailTvMissionText.visibility = View.VISIBLE
                viewDataBinding.actDetailTvMission.visibility = View.GONE
                viewDataBinding.actDetailIvMissionImg.setImageResource(PURPUR.MISSION_SELECT_LIST[position].image)
                viewDataBinding.actDetailTvMissionText.text =
                    PURPUR.MISSION_SELECT_LIST[position].text
                viewDataBinding.actDetailIvMissionBack.setBackgroundResource(PURPUR.MISSION_SELECT_LIST[position].backGround)
            }
        })
        adapter.setCardItemList(PURPUR.MISSION_IMAGE_LIST)
        viewDataBinding.rv.adapter = adapter
        viewDataBinding.rv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onDismiss(dialog: DialogInterface?) {
//        val clearMissionIdx = JSONObject()
//        clearMissionIdx.put("missionIdx", selectedCardIdx)
//        val body =
//            JsonParser.parseString(clearMissionIdx.toString()) as JsonObject
//        detailViewModel.clearMission(animalIdx, body)
        if (wrongAnswer == 1) {
            getBackMissionBg()
        }
        wrongAnswer = -1
    }

}

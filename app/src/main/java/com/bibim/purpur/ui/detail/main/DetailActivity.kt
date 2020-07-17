package com.bibim.purpur.ui.detail.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bibim.purpur.R
import com.bibim.purpur.`object`.PURPUR
import com.bibim.purpur.adapter.CardAdapter
import com.bibim.purpur.adapter.CardViewHolder
import com.bibim.purpur.base.BaseActivity
import com.bibim.purpur.databinding.ActivityDetailBinding
import com.bibim.purpur.onlyOneClickListener
import com.bibim.purpur.ui.detail.dialog.question.QuestionDialogFragment
import com.bibim.purpur.ui.detail.dialog.quiz.QuizDialogFragment

class DetailActivity : BaseActivity<ActivityDetailBinding>() {
    override val layoutResID: Int = R.layout.activity_detail

    private lateinit var vm: DetailViewModel
    lateinit var adapter: CardAdapter
    private val quizDialogFragment = QuizDialogFragment()
        .getInstance()
    private val questionDialogFragment = QuestionDialogFragment()
        .getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = ViewModelProvider(this).get(DetailViewModel::class.java)

//        val progressAnimator = ObjectAnimator.ofInt(progressbar, "progress", 0, 100)
//        progressAnimator.duration = 3000
//        val ll = LinearInterpolator()
//        progressAnimator.interpolator = ll
//        progressAnimator.start()

        setMissionRecyclerViewAdapter()

        viewDataBinding.actDetailIvMissionBtn.onlyOneClickListener {
            quizDialogFragment.isCancelable = false
            quizDialogFragment.show(supportFragmentManager, "QUIZ")
        }

        viewDataBinding.actDetailIvQuestion.onlyOneClickListener {
            questionDialogFragment.show(supportFragmentManager, "QUESTION")
        }

    }

    private fun setMissionRecyclerViewAdapter() {
        adapter = CardAdapter(object :
            CardViewHolder.MissionItemClickListener {
            override fun missionItemClick(position: Int) {
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
}

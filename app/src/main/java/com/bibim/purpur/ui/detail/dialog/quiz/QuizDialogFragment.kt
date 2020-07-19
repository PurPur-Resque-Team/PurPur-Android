package com.bibim.purpur.ui.detail.dialog.quiz

import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.bibim.purpur.R
import com.bibim.purpur.`object`.PURPUR
import com.bibim.purpur.`object`.QuizAnswer
import com.bibim.purpur.databinding.DialogQuizBinding
import com.bibim.purpur.onlyOneClickListener
import com.bibim.purpur.ui.Loading
import com.bibim.purpur.ui.detail.main.DetailActivity
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.json.JSONObject
import org.koin.android.viewmodel.ext.android.viewModel


class QuizDialogFragment : DialogFragment() {

    companion object {
        val QUIZ_ANSWER = ArrayList<Int>()
        val QUIZ_TRY = ArrayList<Int>()
    }

    private val quizDialogViewModel: QuizDialogViewModel by viewModel()
    private lateinit var binding: DialogQuizBinding
    lateinit var btnArray: MutableList<QuizAnswer>

    fun getInstance(): QuizDialogFragment {
        return QuizDialogFragment()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return object : Dialog(activity!!, theme) {
            override fun onBackPressed() {
                quitDialog()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogQuizBinding.inflate(LayoutInflater.from(this.context), container, false)

        btnArray = mutableListOf(
            QuizAnswer(binding.dialogQuizIvBtnZero, false, R.drawable.btn_check_zero_act),
            QuizAnswer(binding.dialogQuizIvBtnOne, false, R.drawable.btn_check_one_act),
            QuizAnswer(binding.dialogQuizIvBtnTwo, false, R.drawable.btn_check_two_act),
            QuizAnswer(binding.dialogQuizIvBtnThree, false, R.drawable.btn_check_three_act),
            QuizAnswer(binding.dialogQuizIvBtnFour, false, R.drawable.btn_check_four_act),
            QuizAnswer(binding.dialogQuizIvBtnFive, false, R.drawable.btn_check_five_act),
            QuizAnswer(binding.dialogQuizIvBtnSix, false, R.drawable.btn_check_six_act),
            QuizAnswer(binding.dialogQuizIvBtnSeven, false, R.drawable.btn_check_seven_act),
            QuizAnswer(binding.dialogQuizIvBtnEight, false, R.drawable.btn_check_eight_act),
            QuizAnswer(binding.dialogQuizIvBtnNine, false, R.drawable.btn_check_nine_act)
        )

        binding.dialogQuizIvClose.onlyOneClickListener {
            quitDialog()
        }

        quizDialogViewModel.getRandomNumbers()



        observeData()
        setBackground()

        solveQuiz()
        return binding.root
    }

    private fun setBackground() {
        // 배경에 희게 각지게 나오는 거 방지.
        with(dialog!!.window!!) {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            isCancelable = false
        }
    }

    private fun solveQuiz() {
        for (quizIndex in btnArray.indices) {
            btnArray[quizIndex].imageView.onlyOneClickListener {
                if (!btnArray[quizIndex].clicked && QUIZ_TRY.size < 4) {
                    btnArray[quizIndex].imageView.setImageResource(btnArray[quizIndex].drawable)
                    btnArray[quizIndex].imageView.isClickable = false
                    QUIZ_TRY.add(quizIndex)
                    if (QUIZ_TRY.size == 4) {
                        if (QUIZ_ANSWER == QUIZ_TRY) {
//                            Toast.makeText(requireContext(), "정답입니다!", Toast.LENGTH_LONG).show()

                            val clearMissionIdx = JSONObject()
                            clearMissionIdx.put("missionIdx", DetailActivity.selectedCardIdx)
                            Log.e("mission idx",DetailActivity.selectedCardIdx.toString())
                            val body =
                                JsonParser.parseString(clearMissionIdx.toString()) as JsonObject

                            Loading.goLoading(requireActivity())
                            (requireActivity() as DetailActivity).detailViewModel.clearMission(
                                DetailActivity.animalIdx,
                                body
                            )
                        } else {
//                            Toast.makeText(requireContext(), "오답입니다!", Toast.LENGTH_LONG).show()
                            DetailActivity.wrongAnswer = 1
                        }
                            quitDialog()
                    }
                }
            }
        }
    }

    private fun observeData() {
        quizDialogViewModel.randomNumList.observe(this, androidx.lifecycle.Observer {
            binding.dialogQuizTvFirst.text = PURPUR.MISSION_CLEAR_QUIZ_NUMBER[it[0]]
            binding.dialogQuizTvSecond.text = PURPUR.MISSION_CLEAR_QUIZ_NUMBER[it[1]]
            binding.dialogQuizTvThird.text = PURPUR.MISSION_CLEAR_QUIZ_NUMBER[it[2]]
            binding.dialogQuizTvFourth.text = PURPUR.MISSION_CLEAR_QUIZ_NUMBER[it[3]]

            QUIZ_ANSWER.addAll(it)
        })

    }

    private fun quitDialog() {
        QUIZ_ANSWER.clear()
        QUIZ_TRY.clear()
        dismiss()
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        val activity: Activity? = activity
        if (activity is DialogInterface.OnDismissListener) {
            (activity as DialogInterface.OnDismissListener).onDismiss(dialog)
        }

    }
}
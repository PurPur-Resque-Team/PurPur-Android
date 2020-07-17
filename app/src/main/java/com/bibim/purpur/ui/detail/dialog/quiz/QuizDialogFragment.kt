package com.bibim.purpur.ui.detail.dialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.bibim.purpur.R
import com.bibim.purpur.`object`.PURPUR
import com.bibim.purpur.`object`.QuizAnswer
import com.bibim.purpur.databinding.DialogQuizBinding
import com.bibim.purpur.onlyOneClickListener

class QuizDialogFragment : DialogFragment() {

    companion object {
        val QUIZ_ANSWER = ArrayList<Int>()
        val QUIZ_TRY = ArrayList<Int>()
    }

    private lateinit var dialogViewModel: DialogViewModel
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

    override fun onDestroy() {
        super.onDestroy()
        Log.e("des", "dsds")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogQuizBinding.inflate(LayoutInflater.from(this.context), container, false)
        dialogViewModel = ViewModelProvider(this).get(DialogViewModel::class.java)


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

        dialogViewModel.getRandomNumbers()

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
                    QUIZ_TRY.add(quizIndex)
                    if (QUIZ_TRY.size == 4) {
                        if (QUIZ_ANSWER == QUIZ_TRY) {
                            quitDialog()
                            Toast.makeText(requireContext(), "정답입니다!", Toast.LENGTH_LONG).show()
                        } else {
                            quitDialog()
                            Toast.makeText(requireContext(), "오답입니다!", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
    }

    private fun observeData() {
        dialogViewModel.randomNumList.observe(this, androidx.lifecycle.Observer {
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
}
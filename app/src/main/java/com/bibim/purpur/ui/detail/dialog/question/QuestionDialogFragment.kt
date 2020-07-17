package com.bibim.purpur.ui.detail.dialog.question

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bibim.purpur.databinding.DialogQuestionBinding
import com.bibim.purpur.ui.detail.dialog.quiz.QuizDialogFragment

class QuestionDialogFragment : DialogFragment() {
    private lateinit var binding: DialogQuestionBinding

    fun getInstance(): QuizDialogFragment {
        return QuizDialogFragment()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return object : Dialog(activity!!, theme) {
            override fun onBackPressed() {
                dismiss()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogQuestionBinding.inflate(LayoutInflater.from(this.context), container, false)
        return binding.root
    }
}
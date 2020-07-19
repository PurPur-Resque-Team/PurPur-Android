package com.bibim.purpur.ui.detail.dialog.question

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bibim.purpur.databinding.DialogQuestionBinding

class QuestionDialogFragment : DialogFragment() {
    private lateinit var binding: DialogQuestionBinding

    fun getInstance(): QuestionDialogFragment {
        return QuestionDialogFragment()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return object : Dialog(activity!!, theme) {
            override fun onBackPressed() {
                dismiss()
            }
        }
    }

    private fun setBackground() {
        // 배경에 희게 각지게 나오는 거 방지.
        with(dialog!!.window!!) {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogQuestionBinding.inflate(LayoutInflater.from(this.context), container, false)

        setBackground()

        return binding.root
    }
}
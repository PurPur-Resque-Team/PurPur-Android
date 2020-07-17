package com.bibim.purpur.ui.detail

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.bibim.purpur.databinding.DialogQuizBinding
import com.bibim.purpur.onlyOneClickListener

class QuizDialogFragment : DialogFragment() {

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
        val binding = DialogQuizBinding.inflate(LayoutInflater.from(this.context), container, false)

        // 배경에 희게 각지게 나오는 거 방지.
        with(dialog!!.window!!) {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            isCancelable = false
        }

        binding.dialogQuizIvClose.onlyOneClickListener {
            dismiss()
        }

        return binding.root
    }
}
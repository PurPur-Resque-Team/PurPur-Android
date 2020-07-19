package com.bibim.purpur.ui.islandSelect

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bibim.purpur.databinding.DialogIslandAnounceBinding
import com.bibim.purpur.onlyOneClickListener

class InitialJoinDialogFragment : DialogFragment() {
    private lateinit var binding: DialogIslandAnounceBinding

    fun getInstance(): InitialJoinDialogFragment {
        return InitialJoinDialogFragment()
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
        binding =
            DialogIslandAnounceBinding.inflate(LayoutInflater.from(this.context), container, false)
        binding.dialogIslandAnouceTvTitle.text = IslandSelectActivity.nickname + "대원, 반가워요."
        setBackground()

        binding.dialogIslandAnounceIvEnter.onlyOneClickListener {
            dismiss()
        }

        return binding.root
    }
}
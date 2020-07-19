package com.bibim.purpur.ui.detail.dialog.mission

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bibim.purpur.databinding.DialogMissionFailBinding

class MissionFailDialogFragment : DialogFragment() {
    private lateinit var binding: DialogMissionFailBinding

    fun getInstance(): MissionFailDialogFragment {
        return MissionFailDialogFragment()
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
            DialogMissionFailBinding.inflate(LayoutInflater.from(this.context), container, false)

        val handler = Handler()
        handler.postDelayed({ dismiss() }, 1000)
        setBackground()

        return binding.root
    }
}
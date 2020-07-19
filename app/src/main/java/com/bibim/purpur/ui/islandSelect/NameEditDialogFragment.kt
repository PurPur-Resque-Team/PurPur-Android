package com.bibim.purpur.ui.islandSelect

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bibim.purpur.R
import com.bibim.purpur.onlyOneClickListener
import com.bibim.purpur.ui.name.NameViewModel
import kotlinx.android.synthetic.main.dialog_name_edit.*
import org.koin.android.viewmodel.ext.android.viewModel

class NameEditDialogFragment : DialogFragment(){

//    lateinit var listener : OnDialogDismissedListener
    val viewModel : NameViewModel by viewModel()

//    fun setOnDialogDismissedListener(listener: OnDialogDismissedListener) {
//        this.listener = listener
//    }
//
//    interface OnDialogDismissedListener {
//        fun onDialogDismissed()
//    }
//
//    override fun dismiss() {
//        listener.onDialogDismissed()
//        super.dismiss()
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_name_edit, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        dialog_name_edit_iv_enter.onlyOneClickListener {
//            viewModel.putUserName(dial_name_edit_et_name.text.toString())
////            dismiss()
//        }
    }

}
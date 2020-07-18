package com.bibim.purpur.ui.name

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import com.bibim.purpur.R
import com.bibim.purpur.base.BaseActivity
import com.bibim.purpur.databinding.ActivityNameBinding
import com.bibim.purpur.onlyOneClickListener
import org.koin.android.viewmodel.ext.android.viewModel

class NameActivity : BaseActivity<ActivityNameBinding>() {
    override val layoutResID: Int
        get() = R.layout.activity_name

    private val nameViewModel: NameViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO : 클릭 시 넘어가는 것.

        setTextWatcher()

        setClickSubmit()

    }

    private fun setClickSubmit() {
        viewDataBinding.actNameBtnSubmit.onlyOneClickListener {
            if (viewDataBinding.actNameEtName.text.toString() != "") {
                viewDataBinding.actNameBtnSubmit.setImageResource(R.drawable.btn_name_enter)
                val handler = Handler()
                handler.postDelayed(
                    { viewDataBinding.actNameBtnSubmit.setImageResource(R.drawable.btn_name_act) },
                    200
                )
            }
        }
    }

    private fun setTextWatcher() {
        viewDataBinding.actNameEtName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != "") {
                    viewDataBinding.actNameBtnSubmit.setImageResource(R.drawable.btn_name_act)
                    viewDataBinding.actNameBtnSubmit.isClickable = true
                } else {
                    viewDataBinding.actNameBtnSubmit.setImageResource(R.drawable.btn_name_none)
                    viewDataBinding.actNameBtnSubmit.isClickable = false
                }
            }
        })
    }
}

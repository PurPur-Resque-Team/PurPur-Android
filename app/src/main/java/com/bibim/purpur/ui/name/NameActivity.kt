package com.bibim.purpur.ui.name

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.bibim.purpur.R
import com.bibim.purpur.`object`.PURPUR
import com.bibim.purpur.base.BaseActivity
import com.bibim.purpur.databinding.ActivityNameBinding
import com.bibim.purpur.onlyOneClickListener
import com.bibim.purpur.ui.island.IslandActivity
import com.bibim.purpur.ui.islandSelect.IslandSelectActivity
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.json.JSONObject
import org.koin.android.viewmodel.ext.android.viewModel

class NameActivity : BaseActivity<ActivityNameBinding>() {
    override val layoutResID: Int
        get() = R.layout.activity_name

    private val nameViewModel: NameViewModel by viewModel()

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO : 클릭 시 넘어가는 것.

        setTextWatcher()

        setClickSubmit()

        observeData()
    }

    private fun observeData() {
        sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE)
        nameViewModel.signUpError.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
        nameViewModel.token.observe(this, Observer {
            val editor = sharedPreferences.edit()
            editor.putString("TOKEN", it)
            editor.apply()
            PURPUR.USER_TOKEN = it
            Log.e("가입한 토큰", it)
            val intent = Intent(this, IslandSelectActivity::class.java)

            intent.putExtra("nickName",viewDataBinding.actNameEtName.text.toString())
            startActivity(intent)
        })
    }

    private fun setClickSubmit() {
        viewDataBinding.actNameBtnSubmit.onlyOneClickListener {
            if (viewDataBinding.actNameEtName.text.toString() != "") {
                val signUpJsonObject = JSONObject()
                signUpJsonObject.put("userName", viewDataBinding.actNameEtName.text)
                val body = JsonParser.parseString(signUpJsonObject.toString()) as JsonObject
                nameViewModel.signUp(body)
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
            override fun afterTextChanged(s: Editable?) {
                if (s.toString() != "") {
                    viewDataBinding.actNameBtnSubmit.setImageResource(R.drawable.btn_name_act)
                    viewDataBinding.actNameBtnSubmit.isClickable = true
                } else {
                    Log.e("empty", "asd")
                    viewDataBinding.actNameBtnSubmit.setImageResource(R.drawable.btn_name_none)
                    viewDataBinding.actNameBtnSubmit.isClickable = false
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                if (s != "") {
//                    viewDataBinding.actNameBtnSubmit.setImageResource(R.drawable.btn_name_act)
//                    viewDataBinding.actNameBtnSubmit.isClickable = true
//                } else {
//                    Log.e("empty","asd")
//                    viewDataBinding.actNameBtnSubmit.setImageResource(R.drawable.btn_name_none)
//                    viewDataBinding.actNameBtnSubmit.isClickable = false
//                }
            }
        })
    }
}

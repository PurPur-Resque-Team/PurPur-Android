package com.bibim.purpur.ui

import android.content.Intent
import android.os.Bundle
import com.bibim.purpur.R
import com.bibim.purpur.base.BaseActivity
import com.bibim.purpur.databinding.ActivityButtonBinding
import com.bibim.purpur.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_button.*

class ButtonActivity : BaseActivity<ActivityButtonBinding>() {

    override val layoutResID: Int
        get() = R.layout.activity_button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        go_main.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        go_detail.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
    }


}

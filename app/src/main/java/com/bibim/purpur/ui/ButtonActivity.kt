package com.bibim.purpur.ui

import android.content.Intent
import android.os.Bundle
import com.bibim.purpur.R
import com.bibim.purpur.base.BaseActivity
import com.bibim.purpur.databinding.ActivityButtonBinding
import com.bibim.purpur.onlyOneClickListener
import com.bibim.purpur.ui.detail.DetailActivity
import com.bibim.purpur.ui.main.MainActivity
import com.bibim.purpur.ui.name.NameActivity
import kotlinx.android.synthetic.main.activity_button.*

class ButtonActivity : BaseActivity<ActivityButtonBinding>() {

    override val layoutResID: Int
        get() = R.layout.activity_button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        go_main.onlyOneClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        go_detail.onlyOneClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }

        go_name.onlyOneClickListener {
            val intent = Intent(this, NameActivity::class.java)
            startActivity(intent)
        }
    }


}

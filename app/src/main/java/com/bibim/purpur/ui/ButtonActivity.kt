package com.bibim.purpur.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.bibim.purpur.R
import com.bibim.purpur.`object`.PURPUR
import com.bibim.purpur.base.BaseActivity
import com.bibim.purpur.databinding.ActivityButtonBinding
import com.bibim.purpur.onlyOneClickListener
import com.bibim.purpur.ui.detail.main.DetailActivity
import com.bibim.purpur.ui.island.IslandActivity
import com.bibim.purpur.ui.islandSelect.IslandSelectActivity
import com.bibim.purpur.ui.name.NameActivity
import kotlinx.android.synthetic.main.activity_button.*

class ButtonActivity : BaseActivity<ActivityButtonBinding>() {

    override val layoutResID: Int
        get() = R.layout.activity_button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences("USER", Context.MODE_PRIVATE)

        PURPUR.USER_TOKEN = sharedPreferences.getString("TOKEN", "").toString()
        Log.e("사용자 토큰", sharedPreferences.getString("TOKEN", "없음"))

        go_main.onlyOneClickListener {
            val intent = Intent(this, IslandActivity::class.java)
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

        island_select.onlyOneClickListener {
            val intent = Intent(this, IslandSelectActivity::class.java)
            startActivity(intent)
        }
    }


}

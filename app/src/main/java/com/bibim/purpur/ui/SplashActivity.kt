package com.bibim.purpur.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.bibim.purpur.R
import com.bibim.purpur.`object`.PURPUR
import com.bibim.purpur.base.BaseActivity
import com.bibim.purpur.databinding.ActivitySplashBinding
import com.bibim.purpur.ui.island.IslandActivity
import com.bibim.purpur.ui.name.NameActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    override val layoutResID: Int
        get() = R.layout.activity_splash
    private val SPLASH_TIME_OUT: Long = 2000
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE)

        PURPUR.USER_TOKEN = sharedPreferences.getString("TOKEN", "").toString()
        Log.e("사용자 토큰", sharedPreferences.getString("TOKEN", "없음"))

        val jwt = sharedPreferences.getString("TOKEN", "없음")
        if (jwt == "없음") {
            Handler().postDelayed({
                val intent = Intent(this@SplashActivity, NameActivity::class.java)
                startActivity(intent)
                finish()
            }, SPLASH_TIME_OUT)
        } else {
            Handler().postDelayed({
                val intent = Intent(this@SplashActivity, IslandActivity::class.java)
                startActivity(intent)
                finish()
            }, SPLASH_TIME_OUT)

        }
    }
}

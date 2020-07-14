package com.bibim.purpur.base

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {
    private lateinit var viewDataBinding: T

    abstract val layoutResID: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        // 초기화된 layoutResId로 databinding 객체 생성
        viewDataBinding = DataBindingUtil.setContentView(this, layoutResID)
        // live data를 사용하기 위해 해줘야함
        viewDataBinding.lifecycleOwner = this@BaseActivity
    }
}
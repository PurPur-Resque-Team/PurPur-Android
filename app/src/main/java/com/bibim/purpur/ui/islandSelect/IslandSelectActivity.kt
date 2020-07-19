package com.bibim.purpur.ui.islandSelect

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.bibim.purpur.R
import com.bibim.purpur.base.BaseActivity
import com.bibim.purpur.databinding.ActivityIslandSelectBinding
import com.bibim.purpur.onlyOneClickListener
import com.bibim.purpur.ui.island.IslandActivity
import org.koin.android.viewmodel.ext.android.viewModel

class IslandSelectActivity : BaseActivity<ActivityIslandSelectBinding>() {
companion object {
    var nickname = ""
}
    override val layoutResID: Int = R.layout.activity_island_select
    val viewModel : IslandSelectViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val str = intent.getStringExtra("nickName")
        if (str != null) {
            Log.e("Qq","Qwe")
            nickname = str
            val initialJoinDialogFragment = InitialJoinDialogFragment()
            initialJoinDialogFragment.show(supportFragmentManager, "schedule_dialog_fragment")
        }else{
            Log.e("ww","ee")

        }
        viewDataBinding.activity = this
        getIslandList()
        setClick()
    }

    fun getIslandList(){
        viewModel.getIslandList()
    }

    private fun setClick(){
        viewDataBinding.actIslandSelectIvSetting.onlyOneClickListener {
            val nameEditDialogFragment = NameEditDialogFragment()
            nameEditDialogFragment.show(supportFragmentManager,"schedule_dialog_fragment")
        }

        viewDataBinding.actIslandIvFirst.onlyOneClickListener {
            val intent = Intent(this, IslandActivity::class.java)
            startActivity(intent)
        }
    }

    fun onClick(){
        Log.e("온클릭", " 실행")
        val islandSelectNoneDialogFragment = IslandSelectNoneDialogFragment()
        islandSelectNoneDialogFragment.show(supportFragmentManager,"schedule_dialog_fragment")
    }
}
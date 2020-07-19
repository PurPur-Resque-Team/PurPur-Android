package com.bibim.purpur.ui.islandSelect

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bibim.purpur.R
import com.bibim.purpur.base.BaseActivity
import com.bibim.purpur.databinding.ActivityIslandSelectBinding
import com.bibim.purpur.onlyOneClickListener
import kotlinx.android.synthetic.main.activity_island_select.*

class IslandSelectActivity : BaseActivity<ActivityIslandSelectBinding>() {

    override val layoutResID: Int = R.layout.activity_island_select

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setClick()
    }

    private fun setClick(){
        viewDataBinding.actIslandSelectIvSetting.onlyOneClickListener {
            val nameEditDialogFragment = NameEditDialogFragment()
            nameEditDialogFragment.show(supportFragmentManager,"schedule_dialog_fragment")
        }
    }
}
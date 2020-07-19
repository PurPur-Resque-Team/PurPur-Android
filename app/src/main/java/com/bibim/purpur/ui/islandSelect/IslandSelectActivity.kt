package com.bibim.purpur.ui.islandSelect

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bibim.purpur.R
import com.bibim.purpur.base.BaseActivity
import com.bibim.purpur.databinding.ActivityIslandSelectBinding
import com.bibim.purpur.onlyOneClickListener
import com.bibim.purpur.ui.island.IslandViewModel
import kotlinx.android.synthetic.main.activity_island_select.*
import org.koin.android.viewmodel.ext.android.viewModel

class IslandSelectActivity : BaseActivity<ActivityIslandSelectBinding>() {

    override val layoutResID: Int = R.layout.activity_island_select
    val viewModel : IslandSelectViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding.activity = this
        viewModel.getIslandList()
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
    }

    fun onClick(){
        Log.e("온클릭", " 실행")
        val islandSelectNoneDialogFragment = IslandSelectNoneDialogFragment()
        islandSelectNoneDialogFragment.show(supportFragmentManager,"schedule_dialog_fragment")
    }
}
package com.github.myplayer.ui.activity

import androidx.appcompat.widget.Toolbar
import com.github.myplayer.R
import com.github.myplayer.util.ToolBarManager
import com.my.player.base.BaseActivity
import org.jetbrains.anko.find

class MainActivity : BaseActivity(), ToolBarManager {
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    override fun getLayoutID(): Int {
        return R.layout.activity_main
    }
    override fun initData() {
        initMainToolBar()
    }
}

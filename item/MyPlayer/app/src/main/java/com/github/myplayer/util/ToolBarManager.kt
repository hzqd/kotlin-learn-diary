package com.github.myplayer.util

import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.github.myplayer.R

interface ToolBarManager {
    val toolbar: Toolbar
    fun initMainToolBar() {
        toolbar.title = "我的影音"
        toolbar.inflateMenu(R.menu.main)
//        toolbar.setOnMenuItemClickListener(object : Toolbar.OnMenuItemClickListener {
//            override fun onMenuItemClick(item: MenuItem?): Boolean {
//                when (item?.itemId) {
//                    R.id.setting -> Toast.makeText(toolbar.context, "点击了设置按钮", Toast.LENGTH_SHORT).show()
//                }
//                return true
//            }
//        })
        toolbar.setOnMenuItemClickListener { item ->
            when (item?.itemId) {
                R.id.setting -> Toast.makeText(toolbar.context, "点击了设置按钮", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
}
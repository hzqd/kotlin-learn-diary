package com.my.player.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast

//所有Activity的基类
abstract class BaseActivity : AppCompatActivity(),AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutID())
        initListener()
        initData()
    }

    //初始化数据
    protected fun initData() {

    }

    //adapter listener
    protected fun initListener() {

    }

    //获取布局id
    abstract fun getLayoutID(): Int

    protected fun myToast(msg: String) {
        runOnUiThread { toast(msg) }
    }
}
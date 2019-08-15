package com.my.player.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

//所有Activity的基类
abstract class BaseActivity : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutID())
        initListener()
        initData()
    }

    //初始化数据
    protected open fun initData() {

    }

    //adapter listener
    protected open fun initListener() {

    }

    //获取布局id
    abstract fun getLayoutID(): Int

    protected fun myToast(msg: String) {
        runOnUiThread { toast(msg) }
    }

    inline fun <reified T : BaseActivity> startActivityAndFinish() {
        startActivity<T>()
        finish()
    }
}
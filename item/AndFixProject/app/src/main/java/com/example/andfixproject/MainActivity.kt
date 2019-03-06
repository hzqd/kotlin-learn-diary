package com.example.andfixproject

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mTvResult: TextView by lazy {
        //findViewById
        tv_result
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTvResult.text = "修复了BUG的版本"
        mTvResult.setTextColor(Color.RED)
        mTvResult.textSize = 50F
    }
}

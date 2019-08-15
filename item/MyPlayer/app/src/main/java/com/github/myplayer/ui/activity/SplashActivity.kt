package com.github.myplayer.ui.activity

import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import com.github.myplayer.R
import com.my.player.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity(), ViewPropertyAnimatorListener {
    override fun onAnimationEnd(view: View?) {
        startActivityAndFinish<MainActivity>()
    }

    override fun onAnimationCancel(view: View?) {

    }

    override fun onAnimationStart(view: View?) {

    }

    override fun getLayoutID(): Int {
        return R.layout.activity_splash
    }

    override fun initData() {
        ViewCompat.animate(imageView).scaleX(1.0f).scaleY(1.0f).setListener(this).duration = 2000
    }
}
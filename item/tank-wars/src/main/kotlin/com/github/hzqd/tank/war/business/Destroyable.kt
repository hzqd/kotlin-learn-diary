package com.github.hzqd.tank.war.business

import com.github.hzqd.tank.war.model.View

//自我回收/销毁的能力：
interface Destroyable : View {
    fun isDestroyed(): Boolean
    fun showDestroy(): Array<View>? = null
}
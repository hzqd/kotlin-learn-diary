package com.github.hzqd.tank.war.business

import com.github.hzqd.tank.war.model.View

/**攻击的能力：*/
interface Attackable : View {
    //判断是否碰撞：
    fun isCollision(sufferable: Sufferable): Boolean
    fun notifyAttack(sufferable:Sufferable)
}
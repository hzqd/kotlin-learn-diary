package com.github.hzqd.tank.war.business

import com.github.hzqd.tank.war.model.View

/**攻击的能力：*/
interface Attackable : View {
    val owner: View
    val attackPower: Int
    fun isCollision(sufferable: Sufferable): Boolean
    fun notifyAttack(sufferable: Sufferable)
}
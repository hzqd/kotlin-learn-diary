package com.github.hzqd.tank.war.business

import com.github.hzqd.tank.war.model.View

/**受攻的能力：*/
interface Sufferable : View {
    val blood: Int  //生命值
    fun notifySuffer(attackable: Attackable): Array<View>?
}
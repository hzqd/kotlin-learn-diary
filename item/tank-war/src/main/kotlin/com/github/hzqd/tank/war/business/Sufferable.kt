package com.github.hzqd.tank.war.business
import com.github.hzqd.tank.war.model.View
/**受攻的能力：*/
interface Sufferable : View {
    fun notifySuffer(attackable: Attackable)
    val boold: Int
}
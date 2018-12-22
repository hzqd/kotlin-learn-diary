package com.github.hzqd.tank.war.business

import com.github.hzqd.tank.war.enums.Direction
import com.github.hzqd.tank.war.model.View

/**自动移动的能力：*/
interface AutoMovable : View {
    //方向和速度：
    val currentDirection: Direction
    val speed: Int
    fun autoMove()
}
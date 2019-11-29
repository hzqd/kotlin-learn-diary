package com.github.hzqd.tank.war.model

import com.github.hzqd.tank.war.Config
import com.github.hzqd.tank.war.business.Blockable
import com.github.hzqd.tank.war.engine.Painter

/**水墙*/
class Water(override val x: Int, override val y: Int) : Blockable {
    //位置：
//    override var x = 200
//    override var y = 200
    //宽高：
    override var width = Config.block
    override var height = Config.block
    //显示行为：
    override fun draw() {
        Painter.drawImage("img/water.gif", x, y)
    }
}
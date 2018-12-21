package com.github.hzqd.tank.war.model

import com.github.hzqd.tank.war.Config
import com.github.hzqd.tank.war.business.Blockable
import org.itheima.kotlin.game.core.Painter

/**砖墙*/
class Wall(override val x: Int, override val y: Int) : Blockable {
      //位置：
//    override val x = 100
//    override val y = 100
    //宽高：
    override val width = Config.block
    override val height= Config.block
    //显示行为：
    override fun draw() {
        Painter.drawImage("img/walls.gif", x , y)
    }
}
package com.github.hzqd.tank.war.model

import com.github.hzqd.tank.war.Config
import org.itheima.kotlin.game.core.Painter

/**草坪*/
class Grass(override val x: Int, override val y: Int) : View {
    //位置：
//    override var x = 200
//    override var y = 200
    //宽高：
    override var width = Config.block
    override var height = Config.block
    //显示行为：
    override fun draw() {
        Painter.drawImage("img/grass.png", x, y)
    }
}
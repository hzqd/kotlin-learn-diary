package com.github.hzqd.tank.war.model

import com.github.hzqd.tank.war.Config
import com.github.hzqd.tank.war.business.Attackable
import com.github.hzqd.tank.war.business.Blockable
import com.github.hzqd.tank.war.business.Sufferable
import com.github.hzqd.tank.war.engine.Painter

/**铁墙*/
class Steel(override val x: Int, override val y: Int) : Blockable, Sufferable {
    override val blood = 0
    //位置：
//    override var x = 200
//    override var y = 200
    //宽高：
    override var width = Config.block
    override var height = Config.block
    //显示行为：
    override fun draw() = Painter.drawImage("img/steels.gif", x, y)
    override fun notifySuffer(attackable: Attackable): Array<View>? = null
}
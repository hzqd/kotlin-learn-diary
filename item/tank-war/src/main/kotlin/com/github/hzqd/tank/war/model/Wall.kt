package com.github.hzqd.tank.war.model

import com.github.hzqd.tank.war.Config
import com.github.hzqd.tank.war.business.Attackable
import com.github.hzqd.tank.war.business.Blockable
import com.github.hzqd.tank.war.business.Destroyable
import com.github.hzqd.tank.war.business.Sufferable
import org.itheima.kotlin.game.core.Composer
import org.itheima.kotlin.game.core.Painter

/**砖墙*/
class Wall(override val x: Int, override val y: Int) : Blockable, Sufferable, Destroyable {
    override var blood: Int = 3
    //位置：
//    override val x = 100
//    override val y = 100
    //宽高：
    override val width = Config.block
    override val height = Config.block
    //显示行为：
    override fun draw() {
        Painter.drawImage("img/walls.gif", x, y)
    }

    override fun isDestroyed(): Boolean = blood <= 0    //砖墙生命值少于或等于零时被销毁

    override fun notifySuffer(attackable: Attackable): Array<View>? {
        blood -= attackable.attackPower      //砖墙掉血
        Composer.play("img/hit.wav")//砖墙喊疼
        return arrayOf(Blast(x,y))
    }
}
package com.github.hzqd.tank.war.model

import com.github.hzqd.tank.war.Config
import com.github.hzqd.tank.war.business.Attackable
import com.github.hzqd.tank.war.business.AutoMovable
import com.github.hzqd.tank.war.business.Destroyable
import com.github.hzqd.tank.war.business.Sufferable
import com.github.hzqd.tank.war.enums.Direction
import com.github.hzqd.tank.war.ext.checkCollision
import org.itheima.kotlin.game.core.Painter

/**子弹*/
class Bullet(override val owner: View, override val currentDirection: Direction, create: (width: Int, height: Int) -> Pair<Int, Int>) : AutoMovable, Destroyable, Attackable, Sufferable {
    override val blood = 0
    //给子弹一个方向，方向由坦克来决定：
    override var width: Int = Config.block
    override var height: Int = Config.block
    override var x: Int = 0
    override var y: Int = 0
    override val speed = 8
    override val attackPower: Int = 1
    private var isDestroyed = false
    private val imagePath = when (currentDirection) {
        Direction.UP   -> "img/bullet_up.bmp"
        Direction.DOWN -> "img/bullet_down.bmp"
        Direction.LEFT -> "img/bullet_left.bmp"
        Direction.RIGHT-> "img/bullet_right.bmp"
    }

    init {
        //先计算宽度和高度：
        val size = Painter.size(imagePath)
        width = size[0]
        height = size[1]
        val pair = create.invoke(width, height)
        x = pair.first
        y = pair.second
    }

    override fun draw() {
        Painter.drawImage(imagePath, x, y)
    }

    override fun autoMove() {
        //根据自己的方向改变自己的坐标：
        when (currentDirection) {
            Direction.UP   -> y -= speed
            Direction.DOWN -> y += speed
            Direction.LEFT -> x -= speed
            Direction.RIGHT-> x += speed
        }
    }

    override fun isDestroyed(): Boolean {
        if (isDestroyed) return true
        //子弹脱离屏幕需要被销毁：
        if (x < -width) return true
        if (x > Config.gameWidth) return true
        if (y < -height) return true
        if (y > Config.gameHeight) return true
        return false
    }

    override fun isCollision(sufferable: Sufferable): Boolean { return checkCollision(sufferable) }

    override fun notifyAttack(sufferable: Sufferable) { isDestroyed = true }

    override fun notifySuffer(attackable: Attackable): Array<View>? { return arrayOf(Blast(x,y)) }
}
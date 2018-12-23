package com.github.hzqd.tank.war.model

import com.github.hzqd.tank.war.Config
import com.github.hzqd.tank.war.business.*
import com.github.hzqd.tank.war.enums.Direction
import org.itheima.kotlin.game.core.Composer
import org.itheima.kotlin.game.core.Painter
import java.util.*

/**敌方坦克*/
class Enemy(override var x: Int, override var y: Int) : Movable, AutoMovable, Blockable, AutoShot, Sufferable, Destroyable {

    override var currentDirection: Direction = Direction.DOWN
    override val speed: Int = 8
    override val width: Int = Config.block
    override val height: Int = Config.block
    //坦克不能走的方向：
    private var badDirection: Direction? = null
    private var lastShotTime = 0L
    private var shotFrequency= 800
    private var lastMoveTime = 0L
    private var moveFrequency= 50
    override var blood = 2

    override fun draw() {
        val imagePath = when (currentDirection) {
            Direction.UP   -> "img/enemy1U.gif"
            Direction.DOWN -> "img/enemy1D.gif"
            Direction.LEFT -> "img/enemy1L.gif"
            Direction.RIGHT-> "img/enemy1R.gif"
        }
        Painter.drawImage(imagePath, x, y)
    }

//    override fun willCollision(block: Blockable): Direction? {
//        return null
//    }

    override fun notifyCollision(direction: Direction?, block: Blockable?) {
        badDirection = direction
    }

    override fun autoMove() {
        //频率检测：
        val current = System.currentTimeMillis()
        if (current - lastMoveTime < moveFrequency) return
        lastMoveTime = current
        if (currentDirection == badDirection) {
            //不允许往错误方向移动，要求改变自身移动方向：
            currentDirection = rdmDirection(badDirection)
            return
        }
        //坦克坐标的变化 —— 根据不同的方向，改变对应的坐标：
        when (currentDirection) {
            Direction.UP   -> y -= speed
            Direction.DOWN -> y += speed
            Direction.LEFT -> x -= speed
            Direction.RIGHT-> x += speed
        }
        //越界判断：
        if (x < 0)                          x = 0
        if (x > Config.gameWidth - width)   x = Config.gameWidth - width
        if (y < 0)                          y = 0
        if (y > Config.gameHeight- height)  y = Config.gameHeight- height
    }

    private fun rdmDirection(bad: Direction?) : Direction {
        val i = Random().nextInt(4)
        val direction = when (i) {
            0 -> Direction.UP
            1 -> Direction.DOWN
            2 -> Direction.LEFT
            else -> Direction.RIGHT
        }
        //判断丢弃错误方向：
        if (direction == bad) {
            return rdmDirection(bad)
        }
        return direction
    }

    override fun autoShot(): View? {
        val current = System.currentTimeMillis()
        if (current - lastShotTime < shotFrequency) return null
        lastShotTime = current
        return Bullet(this, currentDirection) { bulletWidth, bulletHeight ->
            val tankX = x
            val tankY = y
            val tankWidth = width
            val tankHeight = height
            /*计算子弹真实的坐标：
                如果坦克是向上的，计算子弹的位置
                bulletX = tankX + (tankWidth - bulletWidth) / 2
                bulletY = tankY - bulletHeight / 2
             */
            var bulletX = 0
            var bulletY = 0
            when (currentDirection) {
                Direction.UP -> {
                    bulletX = tankX + (tankWidth - bulletWidth) / 2
                    bulletY = tankY - bulletHeight / 2
                }
                Direction.DOWN -> {
                    bulletX = tankX + (tankWidth - bulletWidth) / 2
                    bulletY = tankY + tankHeight - bulletHeight / 2
                }
                Direction.LEFT -> {
                    bulletX = tankX - bulletWidth / 2
                    bulletY = tankY + (tankHeight - bulletHeight) / 2
                }
                Direction.RIGHT -> {
                    bulletX = tankX + tankWidth - bulletWidth / 2
                    bulletY = tankY + (tankHeight - bulletHeight) / 2
                }
            }
            Pair(bulletX, bulletY)
        }
    }

    override fun notifySuffer(attackable: Attackable): Array<View>? {
        if (attackable.owner is Enemy) {
            //受攻->不掉血，不交互
            return null
        }
        blood -= attackable.attackPower
        Composer.play("img/hit.wav")
        return arrayOf(Blast(x,y))
    }

    override fun isDestroyed() = blood <= 0
}
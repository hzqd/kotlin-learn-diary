package com.github.hzqd.tank.war.model

import com.github.hzqd.tank.war.Config
import com.github.hzqd.tank.war.business.*
import com.github.hzqd.tank.war.engine.Composer
import com.github.hzqd.tank.war.engine.HIT
import com.github.hzqd.tank.war.engine.Painter
import com.github.hzqd.tank.war.enums.Direction
import com.github.hzqd.tank.war.util.calcBullet
import com.github.hzqd.tank.war.util.checkDirect
import java.util.*

/**敌方坦克*/
class Enemy(x: Int, y: Int): Tank(), AutoMovable, AutoShotable {
    override var x: Int = x
    override var y: Int = y

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
        checkDirect(this)
    }

    private fun rdmDirection(bad: Direction?) : Direction = run {
        val direction = when (Random().nextInt(4)) {
            0 -> Direction.UP
            1 -> Direction.DOWN
            2 -> Direction.LEFT
            else -> Direction.RIGHT
        }
        //判断丢弃错误方向：
        if (direction == bad) {
            return rdmDirection(bad)
        }
        direction
    }

    override fun autoShot(): View? = run {
        val current = System.currentTimeMillis()
        if (current - lastShotTime < shotFrequency) return null
        lastShotTime = current
        calcBullet(this)
    }

    override fun notifySuffer(attackable: Attackable): Array<View>? = run {
        if (attackable.owner is Enemy) {
            //受攻->不掉血，不交互
            return null
        }
        blood -= attackable.attackPower
        Composer.play(HIT)
        arrayOf(Blast(x, y))
    }

    override fun isDestroyed() = blood <= 0
}
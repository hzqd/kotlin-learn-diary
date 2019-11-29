package com.github.hzqd.tank.war.model

import com.github.hzqd.tank.war.Config
import com.github.hzqd.tank.war.business.*
import com.github.hzqd.tank.war.engine.Painter
import com.github.hzqd.tank.war.enums.Direction
import com.github.hzqd.tank.war.util.calcBullet
import com.github.hzqd.tank.war.util.checkDirect

/**我方坦克*/
class MyTank : Tank() {
    override var x: Int = Config.block * 10
    override var y: Int = Config.block * 10
    override fun isDestroyed() = blood <= -10
    override val width: Int = Config.block
    override val height: Int = Config.block
    //方向：
    override var currentDirection: Direction = Direction.UP
    //速度：
    override val speed = 10
    //血量：
    override var blood = 0
    //坦克不能走的方向：
    private var badDirection: Direction? = null

    //坦克绘制：
    override fun draw() {
        //根据坦克的方向进行绘制：
        val imagePath = when (currentDirection) {
            Direction.UP -> "img/p1tankU.gif"
            Direction.DOWN -> "img/p1tankD.gif"
            Direction.LEFT -> "img/p1tankL.gif"
            Direction.RIGHT -> "img/p1tankR.gif"
        }
        Painter.drawImage(imagePath, x, y)
    }

    //坦克移动：
    fun move(direction: Direction) {
        //判断是否要往碰撞的方向走：
        if (direction == badDirection) return
        //当前的方向和希望移动的方向不一致时，只做方向的改变：
        if (this.currentDirection != direction) {
            this.currentDirection = direction
            return
        }
        //坦克坐标的变化 —— 根据不同的方向，改变对应的坐标：
        checkDirect(this)
    }

    //接收碰撞
    override fun notifyCollision(direction: Direction?, block: Blockable?) {
        this.badDirection = direction
    }

    fun shot() = calcBullet(this)

    override fun notifySuffer(attackable: Attackable): Array<View>? = run {
        blood -= attackable.attackPower
        arrayOf(Blast(x, y))
    }
}
package com.github.hzqd.tank.war.model

import com.github.hzqd.tank.war.Config
import com.github.hzqd.tank.war.business.AutoMovable
import com.github.hzqd.tank.war.business.Blockable
import com.github.hzqd.tank.war.business.Movable
import com.github.hzqd.tank.war.enums.Direction
import org.itheima.kotlin.game.core.Painter

/**敌方坦克*/
class Enemy(override var x: Int, override var y: Int) : Movable, AutoMovable {

    override val currentDirection: Direction = Direction.DOWN
    override val speed: Int = 8
    override val width: Int = Config.block
    override val height: Int = Config.block
    override fun draw() {
        val imagePath = when (currentDirection) {
            Direction.UP   -> "img/enemy1U.gif"
            Direction.DOWN -> "img/enemy1D.gif"
            Direction.LEFT -> "img/enemy1L.gif"
            Direction.RIGHT-> "img/enemy1R.gif"
        }
        Painter.drawImage(imagePath, x, y)
    }

    override fun willCollision(block: Blockable): Direction? {
        return null
    }

    override fun notifyCollision(direction: Direction?, block: Blockable?) {
    }

    override fun autoMove() {
        //坦克坐标的变化 —— 根据不同的方向，改变对应的坐标：
        when (currentDirection) {
            Direction.UP   -> y -= speed
            Direction.DOWN -> y += speed
            Direction.LEFT -> x -= speed
            Direction.RIGHT-> x += speed
        }
        //越界判断：
        if (x < 0) x = 0
        if (x > Config.gameWidth - width) x = Config.gameWidth - width
        if (y < 0) y = 0
        if (y > Config.gameHeight-height) y = Config.gameHeight-height
    }
}
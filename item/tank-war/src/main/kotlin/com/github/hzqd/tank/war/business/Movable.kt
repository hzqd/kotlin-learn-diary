package com.github.hzqd.tank.war.business

import com.github.hzqd.tank.war.Config
import com.github.hzqd.tank.war.enums.Direction
import com.github.hzqd.tank.war.model.View

/**移动的能力：*/
interface Movable : View {
    //可移动物体存在方向和速度：
    val currentDirection: Direction
    val speed: Int
    //判断移动体是否和阻塞体发生碰撞：
    fun willCollision(block: Blockable): Direction? {
        //未来的坐标：
        var x = this.x
        var y = this.y
        //将要碰撞时做判断：
        when (currentDirection) {
            Direction.UP   -> y -= speed
            Direction.DOWN -> y += speed
            Direction.LEFT -> x -= speed
            Direction.RIGHT-> x += speed
        }
        //TODO:先做边界碰撞检测，再进行碰撞物检测：
        //越界判断：
        if (x < 0)                          return Direction.LEFT
        if (x > Config.gameWidth - width)   return Direction.RIGHT
        if (y < 0)                          return Direction.UP
        if (y > Config.gameHeight- height)  return Direction.DOWN
//        val collision = when {
//            block.y + block.height <= y -> false //阻挡物在运动物的上方时，不碰撞
//            y + height <= block.y       -> false //阻挡物在运动物的下方时，不碰撞
//            block.x + block.width  <= x -> false //阻挡物在运动物的左方时，不碰撞
//            else -> x + width > block.x          //阻挡物在运动物的右方时，不碰撞
//        }
        val collision = checkCollision(block.x, x, block.y, y, block.width, width, block.height, height)
        return if (collision) currentDirection else null
    }

    //通知碰撞：
    fun notifyCollision(direction: Direction?, block: Blockable?)
}
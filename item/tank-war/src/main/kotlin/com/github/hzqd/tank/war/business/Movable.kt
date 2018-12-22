package com.github.hzqd.tank.war.business
import com.github.hzqd.tank.war.enums.Direction
import com.github.hzqd.tank.war.model.View
/**移动的能力：*/
interface Movable: View {
    //可移动物体存在方向和速度：
    val currentDirection:Direction
    val speed:Int
    //判断移动体是否和阻塞体发生碰撞：
    fun willCollision(block:Blockable):Direction?
    //通知碰撞：
    fun notifyCollision(direction: Direction?, block: Blockable?)
}
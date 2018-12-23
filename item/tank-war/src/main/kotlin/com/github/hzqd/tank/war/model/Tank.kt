package com.github.hzqd.tank.war.model

import com.github.hzqd.tank.war.Config
import com.github.hzqd.tank.war.business.*
import com.github.hzqd.tank.war.enums.Direction
import org.itheima.kotlin.game.core.Painter

/**我方坦克*/
class Tank(override var x: Int, override var y: Int) : Movable, Blockable, Sufferable, Destroyable {

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

    override fun draw() {
        //根据坦克的方向进行绘制：
//      //方式一：
//        when(currentDirection){
//            Direction.UP   ->Painter.drawImage("img/p1tankU.gif",x,y)
//            Direction.DOWN ->Painter.drawImage("img/p1tankD.gif",x,y)
//            Direction.LEFT ->Painter.drawImage("img/p1tankL.gif",x,y)
//            Direction.RIGHT->Painter.drawImage("img/p1tankR.gif",x,y)
//        }
        //方式二：
        val imagePath = when (currentDirection) {
            Direction.UP   -> "img/p1tankU.gif"
            Direction.DOWN -> "img/p1tankD.gif"
            Direction.LEFT -> "img/p1tankL.gif"
            Direction.RIGHT-> "img/p1tankR.gif"
        }
        Painter.drawImage(imagePath, x, y)
    }

    //坦克移动：
    fun move(direction: Direction) {
        //判断是否要往碰撞的方向走：
        if (direction == badDirection)  return
        //当前的方向和希望移动的方向不一致时，只做方向的改变：
        if (this.currentDirection != direction) {
            this.currentDirection = direction
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
        if (y > Config.gameHeight-height)   y = Config.gameHeight-height
    }

//    override fun willCollision(block: Blockable): Direction? {
//        //未来的坐标：
//        var x = this.x
//        var y = this.y
//        //将要碰撞时做判断：
//        when (currentDirection) {
//            Direction.UP   -> y -= speed
//            Direction.DOWN -> y += speed
//            Direction.LEFT -> x -= speed
//            Direction.RIGHT-> x += speed
//        }
//        //TODO:检测碰撞：
////        val collision = when {
////            block.y + block.height <= y -> false //阻挡物在运动物的上方时，不碰撞
////            y + height <= block.y       -> false //阻挡物在运动物的下方时，不碰撞
////            block.x + block.width  <= x -> false //阻挡物在运动物的左方时，不碰撞
////            else -> x + width > block.x          //阻挡物在运动物的右方时，不碰撞
////        }
//        val collision = checkCollision(block.x, x, block.y, y, block.width, width, block.height, height)
//        return if (collision) currentDirection else null
//    }

    //TODO:接收碰撞
    override fun notifyCollision(direction: Direction?, block: Blockable?) { this.badDirection = direction }

    fun shot(): Bullet {
//        return Bullet(currentDirection,bulletX,bulletY)
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
        blood -= attackable.attackPower
        return arrayOf(Blast(x,y))
    }
}
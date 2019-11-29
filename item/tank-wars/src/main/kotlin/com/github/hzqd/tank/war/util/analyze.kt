package com.github.hzqd.tank.war.util

import com.github.hzqd.tank.war.Config
import com.github.hzqd.tank.war.enums.Direction
import com.github.hzqd.tank.war.model.Bullet
import com.github.hzqd.tank.war.model.Tank

fun checkDirect(ins: Tank) {
    with(ins) {
        when (currentDirection) {
            Direction.UP   -> y -= speed
            Direction.DOWN -> y += speed
            Direction.LEFT -> x -= speed
            Direction.RIGHT-> x += speed
        }
        //越界判断：
        with(Config) {
            if (x < 0) x = 0
            if (x > gameWidth - width) x = gameWidth - width
            if (y < 0) y = 0
            if (y > gameHeight - height) y = gameHeight - height
        }
    }
}

fun calcBullet(ins: Tank) = run {
    with(ins) {
        Bullet(this, currentDirection) { bulletWidth, bulletHeight ->
            val tankX = x
            val tankY = y
            val tankWidth = width
            val tankHeight = height
            //计算子弹真实的坐标：
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
}
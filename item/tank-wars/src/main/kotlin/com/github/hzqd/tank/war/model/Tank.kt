package com.github.hzqd.tank.war.model

import com.github.hzqd.tank.war.business.*
import com.github.hzqd.tank.war.enums.Direction

abstract class Tank : Movable, Blockable, Sufferable, Destroyable {
    override var x: Int = 0
    override var y: Int = 0
    override var currentDirection: Direction = Direction.UP
}
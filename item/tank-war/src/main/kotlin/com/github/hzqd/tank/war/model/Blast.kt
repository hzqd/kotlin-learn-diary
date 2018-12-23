package com.github.hzqd.tank.war.model

import com.github.hzqd.tank.war.Config
import com.github.hzqd.tank.war.business.Destroyable
import org.itheima.kotlin.game.core.Painter

/**爆炸物*/
class Blast(override val x: Int, override val y: Int) : Destroyable {

    override val width: Int = Config.block
    override val height: Int = Config.block
    private val imagePaths = arrayListOf<String>()
    private var index = 0

    init { (1..8).forEach { imagePaths.add("img/blast${it}.png") } }

    override fun draw() {
        val i = index % imagePaths.size
        Painter.drawImage(imagePaths[i], x, y)
        index++
    }

    override fun isDestroyed(): Boolean {
        return index >= imagePaths.size
    }
}
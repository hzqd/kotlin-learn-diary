package com.github.hzqd.tank.war.model

import com.github.hzqd.tank.war.Config
import com.github.hzqd.tank.war.business.Attackable
import com.github.hzqd.tank.war.business.Blockable
import com.github.hzqd.tank.war.business.Destroyable
import com.github.hzqd.tank.war.business.Sufferable
import com.github.hzqd.tank.war.engine.Painter

/**大本营*/
class Camp(override var x: Int, override var y: Int) : Blockable, Sufferable, Destroyable {

    override var blood: Int = 12
    override var width = Config.block * 2
    override var height= Config.block + 32
    override fun draw() {
        when {
            blood <= 3 -> {
                width = Config.block
                height= Config.block
                x = (Config.gameWidth - Config.block) / 2
                y = Config.gameHeight - Config.block
                Painter.drawImage("img/camp.png",x,y)
            }
            blood <= 6 -> {
                Painter.drawImage("img/1/wall.gif",x,y)
                Painter.drawImage("img/1/wall.gif",x+Config.block/2,y)
                Painter.drawImage("img/1/wall.gif",x+Config.block,y)
                Painter.drawImage("img/1/wall.gif",x+Config.block+Config.block/2,y)
                Painter.drawImage("img/1/wall.gif",x,y+Config.block/2)
                Painter.drawImage("img/1/wall.gif",x,y+Config.block)
                Painter.drawImage("img/1/wall.gif",x+Config.block+Config.block/2,y+Config.block/2)
                Painter.drawImage("img/1/wall.gif",x+Config.block+Config.block/2,y+Config.block)
                Painter.drawImage("img/camp.png",x+Config.block/2,y+Config.block/2)
            }
            else -> {
                Painter.drawImage("img/1/tugai.net.20101117144551.gif",x,y)
                Painter.drawImage("img/1/tugai.net.20101117144551.gif",x+Config.block,y)
                Painter.drawImage("img/1/tugai.net.20101117144625.gif",x,y+Config.block/2)
                Painter.drawImage("img/1/tugai.net.20101117144625.gif",x+Config.block+Config.block/2,y+Config.block/2)
                Painter.drawImage("img/camp.png",x+Config.block/2,y+Config.block/2)
            }
        }
    }

    override fun notifySuffer(attackable: Attackable): Array<View>? = run {
        blood -= attackable.attackPower
        if (blood == 3 || blood == 6) {
            return arrayOf (
                    Blast(x,y),
                    Blast(x+Config.block/2,y),
                    Blast(x+Config.block,y),
                    Blast(x,y+Config.block/2),
                    //Blast(x+Config.block/2,y+Config.block),
                    Blast(x+Config.block,y+Config.block/2),
                    Blast(x,y+Config.block),
                    Blast(x+Config.block,y+Config.block),
                    Blast(x+Config.block/2,y+Config.block/2)
            )
        }
        null
    }

    override fun isDestroyed() = blood <= 0

    override fun showDestroy(): Array<View>? = run {
        arrayOf(
                Blast(x-32,y-32),
                Blast(x,y-32),
                Blast(x+32,y-32),
                Blast(x-32,y),
                Blast(x,y),
                Blast(x+32,y),
                Blast(x-32,y+32),
                Blast(x,y+32),
                Blast(x+32,y+32)
        )
    }
}
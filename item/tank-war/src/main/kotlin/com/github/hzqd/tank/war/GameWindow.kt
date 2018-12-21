package com.github.hzqd.tank.war

import com.github.hzqd.tank.war.business.*
import com.github.hzqd.tank.war.enums.Direction
import com.github.hzqd.tank.war.model.*
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import org.itheima.kotlin.game.core.Window
import java.io.File
import java.util.concurrent.CopyOnWriteArrayList

class GameWindow:Window("坦克大战 v0.1","img/logo.jpg",Config.gameWidth,Config.gameHeight) {
    //管理元素的集合：
    //private val views = arrayListOf<View>()
    private val views = CopyOnWriteArrayList<View>()
    private lateinit var tank:Tank
    override fun onCreate() {
        //地图：
        //读文件创建地图：
        val file = File(javaClass.getResource("/map/1.map").path)
        //读取行：
        val lines = file.readLines()
        //循环遍历：
        var lineNum = 0
        lines.forEach { line -> var columnNum = 0
            line.toCharArray().forEach { column ->
                when (column) {
                    '砖' -> views.add( Wall (columnNum * Config.block, lineNum * Config.block) )
                    '铁' -> views.add( Steel(columnNum * Config.block, lineNum * Config.block) )
                    '草' -> views.add( Grass(columnNum * Config.block, lineNum * Config.block) )
                    '水' -> views.add( Water(columnNum * Config.block, lineNum * Config.block) )
                }
                columnNum ++
            }
            lineNum ++
        }
        //添加我方坦克：
        tank = Tank(Config.block * 10, Config.block * 10)
        views.add(tank)
    }

    override fun onDisplay() {
        //绘制图像：

        //绘制地图中的元素：
        views.forEach { it.draw() }
        //println("${views.size}")
    }

    override fun onKeyPressed(event: KeyEvent) {
        //用户操作时：
        when(event.code){
            KeyCode.W -> tank.move(Direction.UP)
            KeyCode.S -> tank.move(Direction.DOWN)
            KeyCode.A -> tank.move(Direction.LEFT)
            KeyCode.D -> tank.move(Direction.RIGHT)
            KeyCode.ENTER -> {
                val bullet = tank.shot()
                views.add(bullet)
            }
        }
    }

    override fun onRefresh() {
        /**业务逻辑：
        ***判断运动体和阻塞体是否发生碰撞：
            (1)找到运动的物体：
            (2)找到阻塞的物体：
            (3)遍历集合 -> 是否发生碰撞：
        */
        views.filter { it is Movable }.forEach { move -> move as Movable //move和block是否碰撞：
            var badDirection: Direction? = null
            var badBlock: Blockable? = null
            views.filter { it is Blockable }.forEach blockTag@ { block -> block as Blockable
                //获得碰撞的方向：
                val direction = move.willCollision(block)
                //发现碰撞，跳出当前循环：
                direction?.let {
                    badDirection = direction
                    badBlock = block
                    return@blockTag
                }
            }
            //找到和move碰撞的block与碰撞的方向
            //通知可移动的物体，会在哪个方向碰撞。
            move.notifyCollision(badDirection, badBlock)
        }
        /**自动移动：*/
        views.filter { it is AutoMovable }.forEach { (it as AutoMovable).autoMove() }
        /**自动销毁：*/  //forEach中判断是否自动销毁：
        views.filter { it is Destroyable }.forEach { if ((it as Destroyable).isDestroyed()) views.remove(it) }
        /**检测攻击体与受攻体是否碰撞：*/
        //过滤有攻击和受攻能力的物体：
        views.filter { it is Attackable }.forEach { attack -> attack as Attackable
            views.filter { it is Sufferable }.forEach sufferTag@ { suffer -> suffer as Sufferable
            //判断是否发生碰撞：
                if (attack.isCollision(suffer)) {
                    //产生碰撞，找到碰撞者；通知攻击者和被攻击者，产生碰撞：
                    attack.notifyAttack(suffer)
                    suffer.notifySuffer(attack)
                    return@sufferTag
                }
        } }
    }
}
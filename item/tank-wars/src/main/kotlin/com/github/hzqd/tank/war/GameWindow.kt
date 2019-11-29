package com.github.hzqd.tank.war

import com.github.hzqd.tank.war.business.*
import com.github.hzqd.tank.war.engine.Window
import com.github.hzqd.tank.war.enums.Direction
import com.github.hzqd.tank.war.model.*
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.concurrent.CopyOnWriteArrayList

class GameWindow : Window("坦克大战 v0.1", "img/logo.jpg", Config.gameWidth, Config.gameHeight) {
    //管理元素的集合：
    //private val views = arrayListOf<View>()
    private val views = CopyOnWriteArrayList<View>()
    private lateinit var tank: MyTank // 晚点创建
    private var gameOver = false      // 游戏结束，默认不结束
    private var enemyTotalSize = 20   // 敌人总数
    private var enemyActiveSize = 6   // 敌人最多显示数量
    private var enemyBornLocation = arrayListOf<Pair<Int, Int>>()    //敌方的出生点
    private var bornIndex = 0
    override fun onCreate() {
        //读文件创建地图，读取行，循环遍历：
        var lineNum = 0
        javaClass.getResourceAsStream("/map/1.map").run {
            BufferedReader(InputStreamReader(this, "utf-8"))
        }.readLines().forEach { line ->
            var columnNum = 0
            line.toCharArray().forEach { column ->
                with(views) {
                    with(enemyBornLocation) {
                        Config.apply {
                            when (column) {
                                '砖' -> add(Wall(columnNum * block, lineNum * block))
                                '铁' -> add(Steel(columnNum * block, lineNum * block))
                                '草' -> add(Grass(columnNum * block, lineNum * block))
                                '水' -> add(Water(columnNum * block, lineNum * block))
                                '敌' -> add(Pair(columnNum * block, lineNum * block))
                            }
                        }
                    }
                }
                columnNum++
            }
            lineNum++
        }
        //添加我方坦克：
        tank = MyTank()
        with(views) {
            add(tank)
            add(Camp(Config.gameWidth / 2 - Config.block, Config.gameHeight - 90))
        }
    }

    override fun onDisplay() = run { views.forEach { it.draw() } }  // 绘制地图中的元素

    override fun onKeyPressed(event: KeyEvent) {
        if (!gameOver) when (event.code) {
            KeyCode.W -> tank.move(Direction.UP)
            KeyCode.S -> tank.move(Direction.DOWN)
            KeyCode.A -> tank.move(Direction.LEFT)
            KeyCode.D -> tank.move(Direction.RIGHT)
            KeyCode.ENTER -> views.add(tank.shot())
        }
    }

    override fun onRefresh() {
        with(views) {
            /**自动销毁：*/  //forEach中判断是否自动销毁：
            filterIsInstance<Destroyable>().forEach {
                if (it.isDestroyed()) {
                    remove(it)
                    if (it is Enemy) enemyTotalSize--
                    it.showDestroy()?.run { addAll(this) }
                }
            }
            if (gameOver) return
            /**业务逻辑：
             ***判断运动体和阻塞体是否发生碰撞：
            (1)找到运动的物体：
            (2)找到阻塞的物体：
            (3)遍历集合 -> 是否发生碰撞：
             */
            filterIsInstance<Movable>().forEach { move ->
                //move和block是否碰撞：
                var badDirection: Direction? = null
                var badBlock: Blockable? = null
                filter { (it is Blockable) and (move != it) }.forEach blockTag@{ block ->
                    block as Blockable
                    move.willCollision(block)?.let {
                        // 获得碰撞的方向；发现碰撞，跳出当前循环
                        badDirection = it
                        badBlock = block
                        return@blockTag
                    }
                }
                //找到和move碰撞的block与碰撞的方向 ; 通知可移动的物体，会在哪个方向碰撞。
                move.notifyCollision(badDirection, badBlock)
            }
            /**自动移动：*/
            filterIsInstance<AutoMovable>().forEach { it.autoMove() }
            /**检测攻击体与受攻体是否碰撞：*/
            //过滤有攻击和受攻能力的物体 且 攻击方的目标不能是自己：
            filterIsInstance<Attackable>().forEach { attack ->
                filter { (it is Sufferable) and (attack.owner != it) and (attack != it) }.forEach sufferTag@{ suffer ->
                    suffer as Sufferable
                    //判断是否发生碰撞：
                    if (attack.isCollision(suffer)) {
                        //产生碰撞，找到碰撞者；通知攻击者和被攻击者，产生碰撞：
                        attack.notifyAttack(suffer)
                        suffer.notifySuffer(attack)?.let { addAll(it) }    //显示受攻效果
                        return@sufferTag
                    }
                }
            }
            /**检测自动射击*/
            filterIsInstance<AutoShotable>().forEach { it.autoShot()?.run { add(this) } }
            /**检测游戏结束*/
            if (none { it is Camp } or (enemyTotalSize <= 0)) gameOver = true
            /**检测敌方出生*/
            if ((enemyTotalSize > 5) and (filterIsInstance<Enemy>().size < enemyActiveSize)) {
                val index = bornIndex % enemyBornLocation.size
                enemyBornLocation[index].run {
                    add(Enemy(first, second))
                }
                bornIndex++
            }
        }
    }
}
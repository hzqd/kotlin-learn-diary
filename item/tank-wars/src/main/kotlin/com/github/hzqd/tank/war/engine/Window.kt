package com.github.hzqd.tank.war.engine

import javafx.animation.AnimationTimer
import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.image.Image
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.paint.Color
import javafx.stage.Stage
import kotlin.system.exitProcess

abstract class Window(
    private val title: String = "New Game",
    private val icon: String = "icon/logo.png",
    val width: Int = 800,
    val height: Int = 600
) : Application() {
    internal val canvas = MyCanvas(width, height)
    private val looper: Looper = Looper(this)
    internal var fps = 0L
    private var running = false
    private val keyRecorder = mutableMapOf<KeyCode, KeyEvent>()
    private var currentKey: KeyCode? = null

    override fun start(primaryStage: Stage?) {
        val group = Group()
        group.children.add(canvas)
        val scene0 = Scene(group, width.toDouble(), height.toDouble())
        //为画笔设置源
        Painter.set(canvas.graphicsContext2D)
        primaryStage?.let {
            with(primaryStage) {
                title = this@Window.title
                scene = scene0
                isResizable = false
                icons.add(Image(icon))
                setOnCloseRequest {
                    looper.stop()
                    running = false
                    exitProcess(0)
                }
                show()
            }
        }

        scene0.onKeyPressed = EventHandler { event ->
            Thread {
                Thread.currentThread().name = "hm-key"
                currentKey = event.code
                keyRecorder[event.code] = event
                this@Window.onKeyPressed(event)
            }.start()
        }
        scene0.onKeyReleased = EventHandler { event ->
            keyRecorder.remove(event.code)
            if (currentKey == event.code) currentKey = null
        }
        //初始化回调
        onCreate()
        looper.start()
        running = true

        Thread {
            Thread.sleep(200)
            while (true) {
                Thread.sleep(80)
                if (!running) break
                keyRecorder.filter { entry ->
                    entry.key != currentKey
                }.forEach { (_, u) ->
                    onKeyPressed(u)
                }
            }
        }.start()

        Thread {
            Thread.sleep(200)
            while (true) {
                Thread.sleep(20)
                if (!running) break
                this@Window.onRefresh()
            }
        }.run {
            isDaemon = true
            priority = Thread.MAX_PRIORITY
            start()
        }

    }

    abstract fun onCreate()

    abstract fun onDisplay()

    abstract fun onRefresh()

    abstract fun onKeyPressed(event: KeyEvent)
}

class Looper(private val window: Window) : AnimationTimer() {
    private var lastTime = 0L

    override fun handle(now: Long) {
        when (lastTime) {
            0L -> lastTime = now
            else -> window.fps = 1000 * 1000 * 1000 / (now - lastTime)
        }
        lastTime = now

        window.run {
            canvas.graphicsContext2D.apply {
                fill = Color.BLACK
                fillRect(0.0, 0.0, width.toDouble(), height.toDouble())
            }
            onDisplay()
        }
        System.gc()
    }
}

class MyCanvas(width: Int = 800, height: Int = 600) : Canvas() {
    init {
        setWidth(width.toDouble())
        setHeight(height.toDouble())
    }
}
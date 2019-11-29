package com.github.hzqd.tank.war.engine

import javafx.scene.canvas.GraphicsContext
import javafx.scene.image.Image

object Painter {
    private lateinit var gc: GraphicsContext
    private val imageCache = mutableMapOf<String, Image>()
    internal fun set(graphicsContext: GraphicsContext) = run { gc = graphicsContext }

    /**
     * 获取图片大小
     */
    fun size(imagePath: String) = run {
        imageCache[imagePath]?.run {
            arrayOf(width.toInt(), height.toInt())
        }
        Image(imagePath).run {
            imageCache[imagePath] = this
            arrayOf(width.toInt(), height.toInt())
        }
    }

    /**
     * 绘制图片
     */
    fun drawImage(imagePath: String, x: Int, y: Int) {
        with(gc) {
            imageCache[imagePath]?.let {
                drawImage(it, x.toDouble(), y.toDouble())
            }
            Image(imagePath).let {
                imageCache[imagePath] = it
                drawImage(it, x.toDouble(), y.toDouble())
            }
        }
    }
}
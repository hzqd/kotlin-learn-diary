import java.awt.*
import java.awt.geom.Ellipse2D

data class Chess(val col: Int, val row: Int, val color: Color) {
    fun draw(g: Graphics) {
        val xPos = col * SPAN + MARGIN
        val yPos = row * SPAN + MARGIN
        val g2d = g as Graphics2D
        lateinit var paint: RadialGradientPaint
        val x = xPos + DIAMETER / 4
        val y = yPos + DIAMETER / 4
        val f = floatArrayOf(0f, 1f)
        val c = arrayOf(Color.WHITE, Color.BLACK)
        when (color) {
            Color.BLACK -> paint = RadialGradientPaint(x, y, DIAMETER, f, c)
            Color.WHITE -> paint = RadialGradientPaint(x, y, DIAMETER * 2, f, c)
        }
        with(g2d) {
            setPaint(paint)     //以下两行使边界更均匀
            setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
            setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT)
            fill(Ellipse2D.Float(xPos - DIAMETER / 2, yPos - DIAMETER / 2, DIAMETER, DIAMETER))
        }
    }
}
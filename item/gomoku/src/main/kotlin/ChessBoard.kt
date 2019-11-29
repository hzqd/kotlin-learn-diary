import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.Toolkit
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JOptionPane
import javax.swing.JPanel

class ChessBoard : JPanel() {
    private val img = Toolkit.getDefaultToolkit().getImage("img/board.png")
    private var chessList = arrayListOf<Chess>()
    private var chessCount = 0
    private var isBlack = true

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        with(g) {
            drawImage(img, 0, 0, this@ChessBoard)
            (0..ROCO).forEach {
                drawLine(MARGIN, MARGIN + it * SPAN, MARGIN + ROCO * SPAN, MARGIN + it * SPAN)  //画横线
                drawLine(MARGIN + it * SPAN, MARGIN, MARGIN + it * SPAN, MARGIN + ROCO * SPAN)  //画竖线
            } //画星位:
            fillRect(MARGIN + 3 * SPAN - 2, MARGIN + 3 * SPAN - 2, 5, 5)
            fillRect(MARGIN + (ROCO / 2) * SPAN - 2, MARGIN + 3 * SPAN - 2, 5, 5)
            fillRect(MARGIN + (ROCO - 3) * SPAN - 2, MARGIN + 3 * SPAN - 2, 5, 5)
            fillRect(MARGIN + 3 * SPAN - 2, MARGIN + (ROCO / 2) * SPAN - 2, 5, 5)
            fillRect(MARGIN + (ROCO / 2) * SPAN - 2, MARGIN + (ROCO / 2) * SPAN - 2, 5, 5)
            fillRect(MARGIN + (ROCO - 3) * SPAN - 2, MARGIN + (ROCO / 2) * SPAN - 2, 5, 5)
            fillRect(MARGIN + 3 * SPAN - 2, MARGIN + (ROCO - 3) * SPAN - 2, 5, 5)
            fillRect(MARGIN + (ROCO / 2) * SPAN - 2, MARGIN + (ROCO - 3) * SPAN - 2, 5, 5)
            fillRect(MARGIN + (ROCO - 3) * SPAN - 2, MARGIN + (ROCO - 3) * SPAN - 2, 5, 5)
            //画棋子:
            (0 until chessCount).forEach {
                chessList[it].draw(this)
                if (it == chessCount - 1) { // 如果是最后一个棋子
                    color = Color.red
                    drawRect( //下一行: xPos, 下下行: yPos //- DIAMETER / 2
                        (chessList[it].col * SPAN + MARGIN - DIAMETER / 2).toInt(),
                        (chessList[it].row * SPAN + MARGIN - DIAMETER / 2).toInt(),
                        DIAMETER.toInt(),
                        DIAMETER.toInt()
                    )
                }
            }
        }
    }

    override fun getPreferredSize() = Dimension(MARGIN * 2 + SPAN * ROCO, MARGIN * 2 + SPAN * ROCO)

    var isGamming = true

    inner class MouseMonitor : MouseAdapter() {
        override fun mousePressed(e: MouseEvent) = with(e) {
            if (!isGamming) return
            // 将鼠标单击的像素坐标转换成网格索引 -> first => col, second => row
            (x - MARGIN + SPAN / 2) / SPAN to (y - MARGIN + SPAN / 2) / SPAN
        }.run {
            // 落在棋盘外不能下棋
            if (first < 0 || first > ROCO || second < 0 || second > ROCO) return
            // 已经有棋子存在的x,y不能下棋
            fun hasChess(col0: Int, row0: Int) = run {
                (0 until chessCount).forEach {
                    with(chessList[it]) {
                        if (col == col0 && row == row0) return true
                    }
                }
                false
            }
            if (hasChess(first, second)) return
            chessCount += 1
            chessList.add(Chess(first, second, if (isBlack) Color.BLACK else Color.WHITE))
            repaint()
            if (isWin(first, second)) {
                (if (isBlack) "黑棋" else "白棋").let {
                    String.format("恭喜，%s赢了!", it)
                }.let {
                    JOptionPane.showMessageDialog(this@ChessBoard, it)
                }
                isGamming = false
            }
            isBlack = !isBlack
        }
    }

    init {
        addMouseListener(MouseMonitor())
    }

    fun isWin(cols: Int, rows: Int) = run {
        var continueCount = 1   //连续棋子个数
        val c = if (isBlack) Color.black else Color.white
        fun hasChess(col0: Int, row0: Int, color0: Color) = run {
            (0 until chessCount).forEach {
                with(chessList[it]) {
                    if (col == col0 && row == row0 && color == color0) return true
                }
            }
            false
        }
        //横向向左寻找
        (cols - 1 downTo 0).forEach { if (hasChess(it, rows, c)) continueCount++ }
        //横向向右寻找
        (cols + 1..ROCO).forEach { if (hasChess(it, rows, c)) continueCount++ }
        if (continueCount >= 5) return true else continueCount = 1
        //纵向向上搜索
        (rows - 1 downTo 0).forEach { if (hasChess(cols, it, c)) continueCount++ }
        //纵向向下搜索
        (rows + 1..ROCO).forEach { if (hasChess(cols, it, c)) continueCount++ }
        if (continueCount >= 5) return true else continueCount = 1
        //继续另一种情况的搜索：右上到左下
        //向右上寻找
        (cols + 1..ROCO).zip(rows - 1 downTo 0).forEach { (x, y) ->
            if (hasChess(x, y, c)) continueCount++
        }
        //向左下寻找
        (cols - 1 downTo 0).zip(rows + 1..ROCO).forEach { (x, y) ->
            if (hasChess(x, y, c)) continueCount++
        }
        if (continueCount >= 5) return true else continueCount = 1
        //继续另一种情况的搜索：左上到右下
        //向左上寻找
        (cols - 1 downTo 0).zip(rows - 1 downTo 0).forEach { (x, y) ->
            if (hasChess(x, y, c)) continueCount++
        }
        //向右下寻找
        (cols + 1..ROCO).zip(rows + 1..ROCO).forEach { (x, y) ->
            if (hasChess(x, y, c)) continueCount++
        }
        continueCount >= 5
    }

    fun restartGame() {
        chessList = ArrayList()
        isBlack = true
        isGamming = true
        chessCount = 0
        repaint()
    }

    fun goBack() {
        if (chessCount==0) return
        chessList.run { removeAt(this.lastIndex) }
        chessCount--
        isBlack = !isBlack
        repaint()
    }
}
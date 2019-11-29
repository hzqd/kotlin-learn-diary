import java.awt.BorderLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JToolBar
import kotlin.system.exitProcess

class Five : JFrame("五子棋") {
    private val startButton = JButton("重新开始")
    private val backButton = JButton("悔棋")
    private val exitButton = JButton("退出")
    private val boardPanel = ChessBoard()

    init {
        JToolBar().apply {
            add(startButton)
            add(backButton)
            add(exitButton)
        }.let {
            add(it, BorderLayout.NORTH)
            setBounds(200, 200, 300, 200)
            defaultCloseOperation = EXIT_ON_CLOSE
            isVisible = true
            add(boardPanel, BorderLayout.CENTER)
            setLocation(200, 200)
            pack()
            ActionMonitor().let {
                startButton.addActionListener(it)
                backButton.addActionListener(it)
                exitButton.addActionListener(it)
            }
        }
    }

    inner class ActionMonitor : ActionListener {
        override fun actionPerformed(e: ActionEvent) {
            with(boardPanel) {
                when (e.source) {
                    startButton -> restartGame()
                    backButton -> goBack()
                    exitButton -> exitProcess(0)
                }
            }
        }
    }
}
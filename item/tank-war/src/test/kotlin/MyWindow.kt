import javafx.application.Application
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.paint.Color
import org.itheima.kotlin.game.core.Composer
import org.itheima.kotlin.game.core.Painter
import org.itheima.kotlin.game.core.Window

/*窗体：
 *继承游戏引擎的窗体：
 */
class MyWindow:Window() {
    override fun onCreate() {
        println("窗体创建..")
    }

    override fun onDisplay() {
        //窗体渲染回调：
        //println("onDisplay..")

        //绘制图片：
        Painter.drawImage("enemy3U.gif",0,0)

        //绘制颜色：
        Painter.drawColor(Color.WHITE,20,20,100,100)
   }

    override fun onKeyPressed(event: KeyEvent) {
        //按键响应：
        when(event.code){
            KeyCode.ENTER -> println("点击了Enter按钮")
            KeyCode.L -> Composer.play("blast.wav")
        }
    }

    override fun onRefresh() {
        //刷新，做业务逻辑和耗时的操作：
    }
}

fun main(args: Array<String>) {
    //启动游戏：
    Application.launch(MyWindow::class.java)
}
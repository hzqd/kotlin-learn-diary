import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
suspend fun main() {
    "主线程开始执行".sout()
    coroutineScope {
        launch {
            (1..10).forEach {
                "打印了 $it 次".sout()
                Thread.sleep(500L)
            }
        }
    }
    "主线程结束执行".sout()
    Thread.sleep(1000L)
}
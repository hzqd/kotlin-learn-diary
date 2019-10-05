import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    "主线程开始执行".sout()
    val job = launch {
        (1..10).forEach {
            "打印了 $it 次".sout()
            Thread.sleep(500L)
        }
    }
    "主线程结束执行".sout()
    job.join()
}
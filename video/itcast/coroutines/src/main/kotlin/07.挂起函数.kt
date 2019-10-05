import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
/**
 * 挂起函数：可以被挂起执行，到时间后从线程池中空闲的线程中恢复执行
 * 挂起函数需通过suspend进行修饰
 * 挂起函数应在协程中，或其他挂起函数中执行
 */
suspend fun myTask() {
    "协程执行前：${Thread.currentThread().name}".sout()
    delay(2000L)
    "协程执行后：${Thread.currentThread().name}".sout()
}

fun main() = runBlocking { // 主协程
    val job = launch {
        myTask()
    }
    job.join()
}
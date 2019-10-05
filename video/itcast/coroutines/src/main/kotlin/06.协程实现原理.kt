import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {
        "协程执行前：${Thread.currentThread().name}".sout()
        delay(2000L)
        "协程执行后：${Thread.currentThread().name}".sout()
    }
    launch { Thread.sleep(3000L) }
    launch { Thread.sleep(3000L) }
    launch { Thread.sleep(3000L) }
    job.join()
}
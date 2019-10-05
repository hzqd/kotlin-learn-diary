import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        (1..10).forEach { it.sout().apply { Thread.sleep(500L) } }
    }.apply { delay(2000L) }.also { it.cancel() }.join()
}

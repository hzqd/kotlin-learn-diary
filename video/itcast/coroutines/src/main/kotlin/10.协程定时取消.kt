import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main() = runBlocking {
    launch {
        withTimeout(2000L) {
            (1..10).forEach { it.sout().apply { delay(500L) } }
        }
    }.join()
}
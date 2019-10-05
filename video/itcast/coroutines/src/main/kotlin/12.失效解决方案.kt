import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.coroutineScope

suspend fun main() = coroutineScope {
    launch {
        (1..10).forEach { it.apply { if (!isActive) return@launch }.sout().apply { Thread.sleep(500L) } }
    }.apply { delay(2000L) }.also { it.isActive.sout() }.also { it.cancel() }.also { it.isActive.sout() }.join()
}
import kotlinx.coroutines.*

fun Any.sout() = let(::println)
suspend fun main() = coroutineScope {
    launch {
        delay(1000)
        "Kotlin Coroutines World!".sout()
    }
    "Hello".sout()
}
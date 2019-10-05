import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext

suspend fun main() = coroutineScope {
    launch(coroutineContext) { "协程执行".sout() }.join() // 运行在父协程的上下文中，当前运行在主线程中
    launch(newFixedThreadPoolContext(5, "新线程")) { "协程执行".sout() }.join() // 自定义线程池
}
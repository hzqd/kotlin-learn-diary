import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

suspend fun job1() = run {
    "job1".apply { "开始执行job1".sout() }.apply { delay(1000L) }.apply { "执行了job1".sout() }
}

suspend fun job2() = run {
    "job2".apply { "开始执行job2".sout() }.apply { delay(1000L) }.apply { "执行了job2".sout() }
}

suspend fun main() = coroutineScope {
    async { job1() }.apply { async { job2() }.await().sout() }.await().sout()
}
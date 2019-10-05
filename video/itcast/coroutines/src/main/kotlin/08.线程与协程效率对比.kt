import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

/*-------------------------------10w线程效率(约7s)------------------------------*/
//class MyThread : Thread() {
//    override fun run() = ".".sout()
//}
//
//fun main() {
//    val startTime = System.currentTimeMillis()
//    List(100000) { MyThread() }.also { it.forEach { it.start() } }.forEach { it.join() }
//    "线程执行耗时${System.currentTimeMillis() - startTime}".sout() //6500
//}

/*-------------------------------10w协程效率(约0.7s)------------------------------*/
suspend fun main() {
    val startTime = System.currentTimeMillis()
    coroutineScope { List(100000) { launch { ".".sout() } }.forEach { it.join() } }
    "协程执行耗时${System.currentTimeMillis() - startTime}".sout() //700
}
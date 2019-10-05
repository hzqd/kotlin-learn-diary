import java.util.concurrent.Executors
import java.util.concurrent.ForkJoinPool

/**
 * 普通线程池 主线程执行结束之后 可以继续执行
 * ForkJoinPool 主线程执行完成后 其中的线程也结束了
 *
 * 普通的线程池创建的是`用户线程`
 * ForkJoinPool创建的是`守护线程`
 *
 * 通过launch函数启动协程，运行在线程池中，默认为`守护线程`(存疑)
 */

fun main() {
    /*-------------------------------普通线程池------------------------------*/
//    "主线程开始执行".sout()
//    //定义线程池：
//    val service = Executors.newFixedThreadPool(3)
//    //创建Runable对象：
//    val runnable = MyRunnable()
//    //执行：
//    service.execute(runnable)
//    "主线程结束执行".sout()
    /*-------------------------------ForkJoinPool实现------------------------------*/
    "主线程开始执行".sout()
    ForkJoinPool(3).execute(MyRunnable()).apply { Thread.sleep(2000L) }
    "主线程结束执行".sout()
}

class MyRunnable : Runnable {
    override fun run() {
        (1..10).forEach {
            it.sout()
            Thread.sleep(500L)
        }
    }
}
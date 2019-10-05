import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun main() {
    coroutineScope {
        /**协程启动：launch { // }
         * launch是一个函数，协程要通过launch函数启动
         * launch前两个参数均为默认参数，参数值可以不指定
         * 最后一个参数是函数类型，调用时通过lambda表达式接收
         * launch函数的返回值是Job类型，就是协程的任务
        */
        launch {
            /**launch函数第一个参数：协程上下文
             * context: CoroutineContext = EmptyCoroutineContext
             */
            "协程执行了".sout()
        }
    }
}

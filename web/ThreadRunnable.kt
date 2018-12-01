fun main(args: Array<String>) {
    val mRunnable = Runnable {
        run {
            Thread.sleep(3000)
            println("Hello")
        }
    }
    Thread(mRunnable).start()
}
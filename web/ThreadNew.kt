class ThreadNew : Thread(){
    override fun run(){
        super.run()
        Thread.sleep(5000)
        println("Hello")
    }
}

fun main(args: Array<String>) {
    val mThread = ThreadNew()
    mThread.run()
}
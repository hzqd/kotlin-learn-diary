//加法计算：
fun main(args: Array<String>) {
    readLine()!!.split(" ").map{ it.trim().toInt() }.sum().let(::println)
}

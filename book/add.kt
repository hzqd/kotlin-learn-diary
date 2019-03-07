//加法计算：
fun main() {
    while (true) readLine()!!.split(" ").map { it.toLong() }.sum().let(::println)
}

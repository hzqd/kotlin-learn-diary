//加法计算：
fun main() {
    while (true) readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toLong() }.sum().let(::println)
}

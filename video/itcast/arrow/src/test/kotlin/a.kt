fun String.toIntOk0() = try { this.toInt() } catch (e: Exception) { 0 }
//err return 0
fun main() {
    readLine()!!.split(" ").map { it.toIntOk0() }.sum().let(::println)
}

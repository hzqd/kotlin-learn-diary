import arrow.core.Try
import arrow.core.extensions.list.functor.map
//err return 0
fun main() {
    readLine()!!.split(" ").map { Try { it.toInt() }.fold({ 0 }, { it }) }.sum().let(::println)
}
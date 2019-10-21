import arrow.core.Option
import arrow.core.extensions.list.functorFilter.filterMap

fun String.toIntOk() = try { this.toInt() } catch (e: Exception) { null }

fun main() {
    readLine()!!.split(" ").filterMap { Option.fromNullable(it.toIntOk()) }.sum().let(::println)
}
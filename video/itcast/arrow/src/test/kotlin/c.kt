import arrow.core.Option
import arrow.core.Try
import arrow.core.extensions.list.functorFilter.filterMap

fun main() {
    readLine()!!.split(" ")
            .filterMap { Option.fromNullable(Try { it.toInt() }.fold({ null }, { it })) }
            .sum().let(::println)
}
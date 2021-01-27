fun printRandomAscii(n: ULong) {
    (1UL..n).forEach { _ -> (33..126).random().toChar().let(::print) }
    println()
}

fun main() {
    while (true) {
        println("Please input the size you want to generate:")
        readLine()!!.toULong().let(::printRandomAscii)
        println()
    }
}
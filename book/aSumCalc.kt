fun main() {
    while (true)
        readLine()!!
            .split(" ")
            .filter { it.matches("[0-9]+".toRegex()) }
            .map { it.toLong() }
            .sum()
            .let(::println)
}

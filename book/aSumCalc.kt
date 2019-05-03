fun main() {
    while (true)
        readLine()!!
            .split(" ")
            .map { it.filter { it in '0'..'9' } }
            .filter { it.isNotEmpty() }
            .map { it.toLong() }
            .sum()
            .let(::println)
}

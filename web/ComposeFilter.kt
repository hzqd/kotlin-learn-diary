fun main(args: Array<String>) {
    val list = listOf(2,3,3,3,4,3,3)

    println(list.filter { it == 3 })

    println(list.filterIndexed { index, i -> index == i })

    println(list.takeWhile { it < 4 })
}
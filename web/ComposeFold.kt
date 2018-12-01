fun main(args: Array<String>) {
    val list = listOf(2,3,4,4,4)
    println(list.fold(1,{acc, i -> acc*i }))
    println(list.fold(StringBuilder(),{ acc, i -> acc.append(i) }))
}
fun main(args: Array<String>) {
    val list = listOf(5,9,10)
    println(list.reduce{acc,i->acc*i})
}
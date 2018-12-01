fun main(args: Array<String>) {
    val raw = listOf(1,2,3,3,3,3)
    val newList = ArrayList<Int>()

    raw.forEach {
        newList.add(it+1)
    }

    println(newList)

    println(raw.map{it*10})
    println(raw.map(Int::toDouble))
}
fun main(args: Array<String>) {
    val raw = listOf(
            1..5,
            99..101,
            999..1002
    )
    println(raw)
    println(raw.flatMap { it })
    println(
            raw.flatMap {
                intRange -> intRange.map{
                int -> "No.$int"
                }
            }
    )
}
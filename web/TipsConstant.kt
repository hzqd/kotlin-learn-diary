fun main(args: Array<String>) {
    var fruit = "banana"
    val Fruit by lazy { fruit }
    println(fruit)
    fruit = "Banana"
    println(Fruit)
}
const val TipsConst = "Only primitives and String are allowed"

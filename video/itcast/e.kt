package itcast

val name: String by lazy {
    println("初始化了")
    "conan"
}

fun main() {
    name.let(::println)
    name.also(::println)

    name1 = "Aoko"
    println(name1)
}

lateinit var name1: String
package itcast

val nomo: String by lazy {
    println("初始化了")
    "conan"
}

fun main() {
    nomo.let(::println)
    nomo.also(::println)

    nomo1 = "Aoko"
    println(nomo1)
}

lateinit var nomo1: String
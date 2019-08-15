package itcast

fun String?.myIsEmpty() = this == null || this.isEmpty()

fun main() {
    val str1: String? = null
    val str2 = ""
    val str3 = "."

    str1.myIsEmpty().let(::println)
    str2.myIsEmpty().let(::println)
    str3.myIsEmpty().let(::println)
}
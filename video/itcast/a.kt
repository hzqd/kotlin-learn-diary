package itcast

fun main() {
    //可变参数：
    fun add(vararg a: Int) = a.sum()
    println(add(1, 2, 3))
    //lambda表达式：
    val a: (Int, Int, String) -> Int = { a, b, c -> a + b + c.count() }
    println(a(1, 2, "abc"))
}
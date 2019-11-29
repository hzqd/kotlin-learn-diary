fun main() {
    val a = arrayListOf<String>()
    a += "a"
    a += "b"
    a += "c"
    println(a)
    a.removeAt(a.lastIndex)
    println(a)
}
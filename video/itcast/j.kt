package itcast

var a = 10
fun test1(){
    println(a)
    a++
}

fun main() {
    test1()
    test1()

    val result = test2()
    result()
    result()
}

fun test2(): () -> Unit {
    var b = 10
    return {
        println(b)
        b++
    }
}
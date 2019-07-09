package itcast

class Person {
    infix fun sayHelloTo(name: String) {
        println("你好 $name")
    }
}

fun main() {
    val a = Person()
    a sayHelloTo "b"
}
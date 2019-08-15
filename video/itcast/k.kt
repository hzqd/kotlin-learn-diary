package itcast

data class Addr(var city: String? = null, var street: String? = null, var number: Int? = null)
data class Person(var name: String? = null, var age: Int? = null, var address: Addr? = null)

fun person(block: Person.() -> Unit) = Person().apply(block)
fun Person.address(block: Addr.() -> Unit) = run { address = Addr().apply(block) }

fun main() {
    person {
        name = "徐熊丽"
        age = 30
        address {
            city = "深圳"
            street = "新华街"
            number = 114
        }
    }.let(::println)
}
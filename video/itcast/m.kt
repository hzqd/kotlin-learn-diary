package itcast

data class Address(val city: String?, val street: String?, val number: Int?)
data class Human(val name: String?, val age: Int?, val address: MyList?)
@MYCLASS
class HumanBuilder {
    var name: String? = null
    var age: Int? = null
    var address: MyList? = null
    fun build() = Human(name, age, address)
}
@MYCLASS
class AddressBuilder {
    var city: String? = null
    var street: String? = null
    var number: Int? = null
    fun build() = Address(city, street, number)
}
@MYCLASS class MyList : ArrayList<Address>()

fun human(block: HumanBuilder.() -> Unit) = HumanBuilder().apply(block).build()
fun HumanBuilder.addresses(block: MyList.() -> Unit) = run { address = MyList().apply(block) }
fun MyList.address(block: AddressBuilder.() -> Unit) = AddressBuilder().apply(block).build().let(::add)

fun main() {
    human {
        name = "王翠花"
        age = 20
        addresses {
            address {
                city = "西安"
                street = "土门街道"
                number = 701
            }
            address {
                city = "上海"
                street = "宝安新苑"
                number = 107
            }
        }
    }.let(::println)
}

@DslMarker
annotation class MYCLASS
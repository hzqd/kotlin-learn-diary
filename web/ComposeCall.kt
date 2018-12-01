class ComposeCall{
    fun sayHi(){
        println("Hi!")
    }
    fun sayHiToAny(any: Any){
        println("Hi!"+any)
    }
}

fun main(args: Array<String>) {
    val hi = ComposeCall::sayHi
    val composeCall = ComposeCall()
    val arr = arrayOf("banana","Banana")

    arr.forEach(::println)
    arr.forEach(composeCall::sayHiToAny)
    println(arr.filter(String::isNotEmpty))

    println(hi)
    println(ComposeCall::sayHiToAny)
}
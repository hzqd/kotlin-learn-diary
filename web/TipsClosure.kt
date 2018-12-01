fun TipsClosure(init: Int): (Int)->Unit{
    var i = init
    return fun(add: Int){
        i+=add
        println("here the i is: "+i)
    }
}

fun main(args: Array<String>) {
    val add = TipsClosure(42)
    add(6)
    add(6)
    add(-11)
    add(18)
}
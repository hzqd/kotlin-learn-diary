class OperatorOverloadUnary(var i:Int){
    operator fun unaryPlus():Int{
        println("UnaryPlus: $i")
        return i
    }
    operator fun unaryMinus():Int{
        println("UnaryMinus: $i")
        return i-1
    }
    operator fun not():Int{
        println("not: $i")
        return i-2
    }

}

fun main(args: Array<String>) {
    val i = OperatorOverloadUnary(9)
    println(+i)
    println(-i)
    println(!i)
}
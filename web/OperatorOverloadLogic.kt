class OperatorOverloadLogic(var i: Int){
    operator fun contains(i:Any):Boolean{
        println("contains ${this.i} and $i")
        return false
    }
    override fun equals(other: Any?): Boolean {
        println("equals $i and $other")
        return true
    }
    operator fun compareTo(i:Any):Int{
        println("compareTo ${this.i} and $i")
        return 42
    }
}

fun main(args: Array<String>) {
    var i = OperatorOverloadLogic(450)
    println("banana" in i)
    println(i == OperatorOverloadLogic(12))
    println(i>1)
    println(i<2)
    println(i>=3)
    println(i<="Banana")
}
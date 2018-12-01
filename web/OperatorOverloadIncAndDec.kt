class OperatorOverloadIncAndDec(var i:Int){
    init {
        println("Here is $i")
    }

    override fun toString(): String {
        return "toString: $i"
    }
    operator fun inc():OperatorOverloadIncAndDec{
        println("INC $i")
        return OperatorOverloadIncAndDec(i+10)
    }
    operator fun dec():OperatorOverloadIncAndDec{
        println("DEC $i")
        return OperatorOverloadIncAndDec(i-10)
    }
}

fun main(args: Array<String>) {
    var i = OperatorOverloadIncAndDec(42)
    i++
    i--
}
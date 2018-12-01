class OperatorOverloadBinary(var i: Int){
    operator fun plus(j:Int){
        println("plus $i and $j")
    }
    operator fun minus(s:String){
        println("minus $i and $s")
    }
    operator fun times(j:Int){
        println("times $i and $j")
    }
    operator fun div(j:Int){
        println("div $i and$j")
    }
    operator fun rem(j:Int){
        println("rem $i and $j")
    }
    operator fun rangeTo(s:String){
        println("rangeTo $i and $s")
    }
}

fun main(args: Array<String>) {
    var i = OperatorOverloadBinary(9527)
    i+1
    i-"Banana"
    i*3
    i/4
    i%5
    i.."Banana!"
}
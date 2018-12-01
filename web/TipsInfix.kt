class TipsInfix(var i: Int){
    infix fun banana(i:Int){
        println("infix banana ${this.i} and $i")
    }
}
infix fun TipsInfix.poi(i:Int){
    println("infix poi ${this.i} and $i")
}

fun main(args: Array<String>) {
    var i = TipsInfix(12)
    i banana 450
    i poi 12
}
class OperatorOverloadAssign(var i: Int){
    operator fun plusAssign(s:String){
        println("plusAssign $i and $s")
    }
    operator fun minusAssign(i:Int){
        println("minusAssign ${this.i} and $i")
    }
    operator fun timesAssign(s:String){
        println("timesAssign $i and $s")
    }
    operator fun divAssign(i:Int){
        println("divAssign ${this.i} and $i")
    }
    operator fun remAssign(s:String){
        println("remAssign $i and $s")
    }
}

fun main(args: Array<String>) {
    var i = OperatorOverloadAssign(666)
    i+="banana"
    i-=2
    i*="Banana"
    i/=3
    i%="Banana!"
}
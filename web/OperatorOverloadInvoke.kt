class OperatorOverloadInvoke(var i: Int){
    operator fun get(i:Int){
        println("get ${this.i} and $i")
    }
    operator fun set(i:Any,j:Any){
        println("set ${this.i} $i and $j")
    }
    operator fun invoke(i:Any){
        println("invoke ${this.i} and $i")
    }
}

fun main(args: Array<String>) {
    var i = OperatorOverloadInvoke(233)
    i[12]
    i["banana"] = "Banana"
    i("Banana!")
}
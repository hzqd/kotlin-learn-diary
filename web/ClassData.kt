data class ClassData(var aString: String,val bString: String){
    init {
        var sString = bString
    }
    fun print(){
        println("Print in ${this.javaClass}")
    }
}

fun main(args: Array<String>) {
    var banana = ClassData("aBanana","bBanana")
    var Banana = banana.copy(bString = "cBanana")
    println(banana)
    banana.print()
    println(Banana)
    Banana.print()
}
class ComposeWith(val s: String){
    fun printS(){
        println(s)
    }
    override fun toString(): String {
        return s+" toString"
    }
}

fun main(args: Array<String>) {
    val result:String = with(ComposeWith("Banana")){
        this.printS()
        this.toString()
    }

    println(result)
}
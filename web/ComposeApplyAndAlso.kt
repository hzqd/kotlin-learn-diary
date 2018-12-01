class ComposeApplyAndAlso(val s: String){
    fun printS(){
        println(s)
    }
}

fun main(args: Array<String>) {
    val apply = ComposeApplyAndAlso("apply banana").apply {
        printS()
    }
    val also = ComposeApplyAndAlso("also banana").also {
        it.printS()
    }

    println(apply)
    apply.printS()
    println(also)
    also.printS()
}
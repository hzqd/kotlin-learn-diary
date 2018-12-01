class ComposeRun(val s: String, val s2: String){
    fun printS(){
        println(s)
    }
}

fun composeRun(i:Boolean):ComposeRun?{
    if (i){
        return ComposeRun("Banana","yes!")
    }else{
        return null
    }
}

fun main(args: Array<String>) {
    val s = composeRun(true)?.run {
        printS()
        "This will be returned."
    }
    composeRun(false)?.run{
        println("Do not work.")
    }

    println(s)

}
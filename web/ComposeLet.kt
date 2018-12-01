class ComposeLet(val s1: String, val num: Int){
    fun printS1(){
        println(s1)
    }
}

fun composeLet(i: Boolean):ComposeLet?{
    if(i){
        return ComposeLet("Banana",12)
    }else{
        return null
    }
}

fun main(args: Array<String>) {
    ComposeLet("banana",42).let {
        println(it.s1)
        it.printS1()
    }

    composeLet(true)?.let {
        it.printS1()
    }
    composeLet(false)?.let {
        println(it.num)
    }
}
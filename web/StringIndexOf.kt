fun main(args: Array<String>) {
    var str = "Python CPP Java Ruby Kotlin"
    printPos(str.indexOf("python"))
    printPos(str.indexOf("python",ignoreCase = true))
    printPos(str.indexOf("Java"))
}

fun printPos(pos:Int){
    if(pos == -1){
        println("Do not find that string.")
    }
    else
    {
        println("Find that string in "+pos)
    }
}
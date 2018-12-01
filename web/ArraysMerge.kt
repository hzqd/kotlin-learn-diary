fun main(args: Array<String>) {
    var array1 : Array<String> = arrayOf("S","h","a")
    var array2 : Array<String> = arrayOf("w","n")
    var list = array1.asList()
    list+=array2.asList()
    println(list)
    array1+=array2
    printArray(array1)
}

public fun printArray(array:Array<out Any>){
    for (i in array){
        println(i)
    }
}
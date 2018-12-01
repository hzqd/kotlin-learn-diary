fun main(args: Array<String>) {
    var array : Array<Any> = Array<Any>(4,{9})
    array.set(0,1)
    array.set(1,"hop")
    for(i in array){
        println(i)
    }
    println("The length of array is "+array.size)
}
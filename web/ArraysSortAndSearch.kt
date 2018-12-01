fun main(args: Array<String>) {
    var array = intArrayOf(1,5,2,3,9,1)
    print("Original: ")
    printIntArray(array)
    array.sort()
    print("Sorted: ")
    printIntArray(array)
    println("'5' in the position: "+array.binarySearch(5))

}

fun printIntArray(intArray: IntArray){
    for(i in intArray){
        print(" "+i)
    }
    println()
}
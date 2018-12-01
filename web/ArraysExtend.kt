fun main(args: Array<String>) {
    var array = intArrayOf(1,2,3)
    var arrayExtended = IntArray(5)
    printIntArray(arrayExtended)
    arrayExtended[3] = 4
    arrayExtended[4] = 5
    System.arraycopy(array,0,arrayExtended,0,array.size)
    printIntArray(arrayExtended)
}
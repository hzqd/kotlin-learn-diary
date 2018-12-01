fun main(args: Array<String>) {
    var array1 = intArrayOf(1,2,3,4)
    var array2 = intArrayOf(1,2,3,4)
    var array3 = intArrayOf(1,2)
    println("array1 equals array2? "+array1.contentEquals(array2))
    println("array1 equals array3? "+array1.contentEquals(array3))
}
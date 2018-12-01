fun main(args: Array<String>) {
    var array1 = intArrayOf(1,2,2,3)
    var array2 = intArrayOf(3,4,4,5)
    var unionSet = emptySet<Int>()
    unionSet+=array1.toSet()
    unionSet+=array2.toSet()
    printSet(unionSet)
}
public fun printSet(s:Set<out Any>){
    for(i in s){
        print(i.toString()+" ")
    }
    println()
}
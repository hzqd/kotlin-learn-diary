fun main(args: Array<String>) {
    var array = arrayListOf(1,2,3,4,"dog")
    array.add(2.3)
    array.add(true)
    printArrayList(array)
}

public fun printArrayList(arrayList: ArrayList<out Any>):Unit{
    for(i in arrayList){
        println(i.toString())
    }
}
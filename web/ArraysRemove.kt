fun main(args: Array<String>) {
    var arrayList = ArrayList<String>()
    arrayList.add("The first element")
    arrayList.add("The second element")
    arrayList.add("The third element")
    arrayList.removeAt(1)
    printArrayList(arrayList)
}
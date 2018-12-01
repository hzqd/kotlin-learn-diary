fun main(args: Array<String>) {
    var arrayList1 = arrayListOf(1,2,2,3,4,4)
    var arrayList2 = arrayListOf(1,2,5,3,3)
    arrayList1.removeAll(arrayList2)
    printArrayList(arrayList1)
}
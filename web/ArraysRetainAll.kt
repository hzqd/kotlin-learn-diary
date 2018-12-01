fun main(args: Array<String>) {
    var arrayList1 = arrayListOf("Shawn","Doge","Doge","XueBi","NiShiLong","NiShiLong")
    var arrayList2 = arrayListOf("Shawn","Doge","Biu","WoShiLong","WoShiLong")
    arrayList1.retainAll(arrayList2)
    printArrayList(arrayList1)
}
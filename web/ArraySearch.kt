fun main(args: Array<String>) {
    var arrayList = arrayListOf(1,3,5,2,4,6,"DFWill","Boom!")
    println("DFWill in the list? "+("DFWill" in arrayList))
    println("1 in the list? "+arrayList.contains(1))
}
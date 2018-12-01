typealias StrArrayList = ArrayList<String>
typealias SAL = StrArrayList


fun main(args: Array<String>) {
    var sal = SAL()
    sal.add("banana")
    sal.add("Banana")
    var strArrayList = StrArrayList()
    strArrayList.add("str")
    strArrayList.add("Str")
    println("The class of sal: "+sal.javaClass)
    println("The class of strArrayList: "+strArrayList.javaClass)
}
fun main(args: Array<String>) {
    val a = "banana"
    val b: String? = null
    println(a)
    println(a?.length)
    println(b)
    println(b?.length)
    try{
        val c = b!!.length
    }catch (NPE: NullPointerException){
        NPE.printStackTrace()
    }
}
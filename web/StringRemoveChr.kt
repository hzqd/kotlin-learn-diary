fun main(args: Array<String>) {
    var str : String = "PHP, the best language."
    println(removeCharAt(str,1))
}

fun removeCharAt(s:String,pos:Int): String{
    return s.substring(0,pos)+s.substring(pos+1)
}
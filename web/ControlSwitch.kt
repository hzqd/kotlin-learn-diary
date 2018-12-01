fun main(args: Array<String>) {
    var a = 1
    var b = 2
    if(a>b)
    {
        println(a)
    }
    else
    {
        println(b)
    }
    var max = if(a>b) a else b
    println(max)
    fun max(a:Int,b:Int) = when(a>b){
        true -> a
        false -> b
        else -> null
    }
    fun isString(a:Any) = when(a){
        is String -> println("That is a string")
        !is String -> println("That is not a string")
        else -> println("I have no idea")
    }
    println(max(233,666))
    isString("Fish!")
}
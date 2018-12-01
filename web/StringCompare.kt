fun main(args: Array<String>) {
    var str = "Hello World"
    var str1 = "Hello World"
    var str2 : String = "hello World"
    var str3 : String = "World"
    println(str.compareTo(str1))
    println(str.compareTo(str2))
    println(str.compareTo(str2,true))
    println(str.compareTo(str3))
    println(str.equals(str1))
    println(str.equals(str2))
    println(str.equals(str2,true))
    println(str.equals(str3))
}
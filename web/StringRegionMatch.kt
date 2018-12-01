fun main(args: Array<String>) {
    var str1 = "php Is the best."
    var str2 = "who is your daddy?"
    println(str1.regionMatches(4,str2,4,2))
    println(str1.regionMatches(4,str2,4,2,true))
}
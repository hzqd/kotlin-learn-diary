fun main(args: Array<String>) {
    var str = "Hello, handsome boy."
    var str1: String = "boy? I am not a boy!"
    var lastHandsome = str.lastIndexOf("handsome")
    var lastBoy : Int = str.lastIndexOf("BoY",ignoreCase = true,startIndex = str.length)
    var lastBoyInStr1 : Int = str1.lastIndexOf("boy",str1.length-5,true)
    println("The last index of \"handsome\" is "+lastHandsome)
    println("The last index of \"boy\" is "+lastBoy)
    println("Now I ignore the last 5 chr in str1: "+lastBoyInStr1)
}
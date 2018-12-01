fun main(args: Array<String>) {
    val (a,b) = tipsComponent()
    println(a.toString()+b)
}

data class TipsComponent(val res1: Int, val res2: String)
fun tipsComponent():TipsComponent{
    return TipsComponent(23,"Banana")
}
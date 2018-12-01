class Outside{
    var inside = Inside()
    inner class Inside{
        fun function(){
            var outside = this@Outside
            var inside = this@Inside
            var func = this
            println(outside.javaClass)
            println(inside.javaClass)
            println(func.javaClass)
        }
    }
}
fun Outside.func(){
    println(this.javaClass)
}

fun main(args: Array<String>) {
    var This = Outside()
    This.Inside().function()
    This.func()
}
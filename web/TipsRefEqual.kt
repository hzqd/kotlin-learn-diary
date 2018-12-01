fun main(args: Array<String>) {
    var a = TipsRefEqual("You")
    var b = a
    var c = a
    var d = TipsRefEqual("You")
    println(a==b)
    println(b==c)
    println(a==d)
    println(a===b)
    println(b===c)
    println(a===d)
    println(b===d)
}

class TipsRefEqual(var name:String){
    override fun equals(other: Any?): Boolean {
        return this.name==other.toString()
    }
    override fun toString(): String {
        return this.name
    }
}
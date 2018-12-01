abstract class ClassAbstract(){
    var i: Int? = null
    abstract fun a()
    abstract fun b()
}
interface ClassAbstractA{
    fun a(i: Int):Int{
        return i
    }
}
interface ClassAbstractB{
    fun b(s: String):String{
        return s
    }
}
class ClassAbstractClass:ClassAbstract(),ClassAbstractA,ClassAbstractB{
    override fun a(){
        println("a")
    }
    override fun a(i:Int):Int{
        println("a"+i)
        return i+1
    }
    override fun b(){
        println("b")
    }
    override fun b(s: String): String {
        println("b"+s)
        return super<ClassAbstractB>.b(s)
    }
}

fun main(args: Array<String>) {
    var abstract = ClassAbstractClass()
    abstract.a()
    abstract.a(1)
    abstract.b()
    abstract.b("test")
}
internal interface A                          //定义接口
{
    fun print()
    fun tell()

    companion object {
        val name: String? = null
    }
}

internal abstract class B {
    abstract fun say()    //定义一个抽象类
}

internal class X : B(), A            //子类同时实现接口
{
    override fun say() {
        print("love")
    }

    override fun print() {
        print("Aaron" + "\t")
    }

    override fun tell() {
        print("\t" + "Crystal")
    }
}

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val x = X()
        x.print()
        x.say()
        x.tell()
    }
}
import javax.swing.JFrame

open class Base{
    open val foo = 1
    open fun greeting() {
        println("Base")
    }
}

class Child:Base() {
    override val foo = 2
    override fun greeting() {
        println("Child")
    }
    fun inside() {
        super.greeting()
        println(super.foo)
    }
}

fun main() {
    val ins = Child()
    ins.greeting()
    ins.inside()
}

/*
* import javax.swing.*;
* public class Five extends JFrame {
*   public Five() {
*     super("foo");
*   }
* }
*/
class Five : JFrame("foo")
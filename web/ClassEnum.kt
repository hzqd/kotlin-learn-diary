enum class ClassEnum(val rgb:Int,var stuff:String){
    RED(0xFF0000,"apple"){
        override fun print() {
            println(this.stuff)
        }
    },
    GREEN(0x00FF00,"Your hat"){
        override fun print() {
            println("That is ok "+this.stuff)
        }
    },
    BLUE(0x0000FF,"Sky"){
        override fun print() {
            println("I need some towers")
        }
    };
    abstract fun print()
}

fun main(args: Array<String>) {
    ClassEnum.RED.print()
    ClassEnum.GREEN.print()
    println(ClassEnum.BLUE.rgb)
    println(ClassEnum.BLUE.stuff)
    ClassEnum.BLUE.stuff = "Sea"
    println(ClassEnum.BLUE.stuff)
}
class ClassInit constructor(info:String){
    init{
        println(info+" in the initializer block 1")
    }
    var str1 = "var str1".also(::println)
    init{
        println(info+" in the initializer block 2")
        this.str1 = info
    }
    fun printstr1(){
        println("str1: "+str1)
    }
    val str2 = "val str2".also(::println)
}

fun main(args: Array<String>) {
    println("Begin")
    var classInit = ClassInit("New")
    var classInit2 = ClassInit("New2")
    classInit.printstr1()
    classInit2.printstr1()
}
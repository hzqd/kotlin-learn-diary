class ClassSecondaryConstructor constructor(var name:String){
    init{
        println("Init block "+name)
    }
    var age = 0
    var father = "father of ${name}".also(::println)
    constructor(name:String,age:Int):this(name){
        this.age = age
        println("First secondary constructor "+name)
    }
    constructor(name:String,age:Int = 18,father:String):this(name,age){
        this.father = father
        println("Second secondary constructor "+name)
    }
    init{
        println("Init block2 "+name)
    }
}

fun main(args: Array<String>) {
    var a = ClassSecondaryConstructor("Shawn")
    var b = ClassSecondaryConstructor("XiaoMing",24)
    var c = ClassSecondaryConstructor("Me",father = "Father")
}
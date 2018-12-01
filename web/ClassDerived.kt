open class Father{
    public var age = 18
    private var name = ""
    constructor(name: String){
        this.name = name
    }
    open public fun printName(){
        println(name)
    }
    public fun printAge(){
        println(age)
    }
}

class Boy(name:String,age:Int):Father(name){
    init{
        this.age = age
    }
    override fun printName(){
        super.printName()
        println("from Boy")
    }

}

fun main(args: Array<String>) {
    var father = Father("Father")
    var boy = Boy("Boy",5)
    father.printName()
    father.printAge()
    boy.printName()
    boy.printAge()
}
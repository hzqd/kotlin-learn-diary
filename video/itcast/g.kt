package itcast

class People {
    var name = "apple"
    companion object {
        var age = 20
    }
}

fun main() {
    val people = People()
    people.name
    People.age

    Utils.name
    Utils.instance.age
    //val utils = Utils()
}

class Utils private constructor() {
    var age = 20
    companion object {
        var name = "apple"
        val instance by lazy { Utils() }
    }
}
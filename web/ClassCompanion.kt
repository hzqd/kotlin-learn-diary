class ClassCompanion{
    companion object {
        fun printHello(){
            print("Hello!")
        }
        val Dio: String = "Dio"
    }
}

fun main(args: Array<String>) {
    ClassCompanion.printHello()
    print(" "+ClassCompanion.Dio)
}

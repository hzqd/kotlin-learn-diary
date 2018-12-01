sealed class ClassSealed
data class SealedA(var seal:String):ClassSealed()
class SealedB:ClassSealed(){
    fun print(){
        println("I am a little seal.")
    }
}
object SealedC:ClassSealed()

fun main(args: Array<String>) {
    var list = listOf<ClassSealed>(SealedB(),SealedA("I am here for basking."),SealedC)
    for (seal:ClassSealed in list){
        when(seal){
            is SealedA -> println(seal.seal)
            is SealedB -> seal.print()
            is SealedC -> println("And disappear again.")
        }
    }
}
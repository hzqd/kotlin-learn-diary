class ClassExtend{
    var str: String?= null
}
fun ClassExtend.printStr(){
    println(str)
}
fun ClassExtend.setStr(str:String){
    this.str = str
}

fun main(args: Array<String>) {
    var CE = ClassExtend()
    CE.printStr()
    CE.setStr("input something")
    CE.printStr()
}

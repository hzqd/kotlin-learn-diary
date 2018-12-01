fun tipsVarargs(vararg strings:String){
    for(s in strings){
        println(s)
    }
    for (i in 0 until strings.size){
        print(strings[i]+" ")
    }
}

fun main(args: Array<String>) {
    tipsVarargs("banana","Banana","banana","banana")
}
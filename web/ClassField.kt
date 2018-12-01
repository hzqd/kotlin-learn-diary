fun main(args: Array<String>) {
    var get = ClassField()
    for(i in 0..5){
        get.answer = i
        println(get.answer)
    }
}

class ClassField(){
    var answer : Int = 0
        set(value){
            field = value-1
        }
        get() {
            if(field==0)return 42
            else return field
        }
}
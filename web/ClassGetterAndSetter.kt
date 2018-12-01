
fun main(args: Array<String>) {
    var get = GetAndSet()
    for(i in 0..5){
        get.answer = i
        println(get.answer)
    }
}

class GetAndSet(){
    var data = 0
    var answer : Int
        get() {
            if(data!=0)return 42
            else return data
        }
        set(value) {data = value%2}
    }


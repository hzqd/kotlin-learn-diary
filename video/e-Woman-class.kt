class Woman(name:String):Human(name){
    override fun eat(){
        println("${name}小口吃饭")
    }

    override fun pee() {
        println("${name}蹲着尿尿")
    }
}
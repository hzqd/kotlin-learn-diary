class Man(name:String):Human(name){
    override fun eat(){
        println("${name}大口吃饭")
    }

    override fun pee() {
        println("${name}站着尿尿")
    }
}
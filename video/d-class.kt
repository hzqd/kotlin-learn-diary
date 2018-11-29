//程序员A创建的洗衣机：
class WashMachine (var module:String, var size:Int) {
    var isDoorOpen = true
    var currentmode = 0
    fun openDoor(){
        println("洗衣机的门打开了")
        isDoorOpen = true
    }
    fun closeDoor(){
        println("洗衣机的门关闭了")
        isDoorOpen = false
    }
    fun selectMode(mode:Int){
        currentmode = mode
        when(mode){
            0 -> println("初始模式，请您选择模式")
            1 -> println("轻揉")
            2 -> println("普通")
            3 -> println("狂揉")
            else -> println("不要乱拧，拧坏了不保修啊")
        }
    }
    fun start(){
        if(isDoorOpen)
            println("哔哔，门还没关呢，不能运行")
        else {
            when (currentmode) {
                0 -> {println("选择模式错误，不能开始洗衣服")}
                1 -> {
                    println("放水")
                    println("水放满了")
                    println("轻柔开始，发动机转速：慢")
                    setMotorSpeed(100)
                    println("洗完了")
                }
                2 -> {
                    println("放水")
                    println("水放满了")
                    println("普通模式，发动机转速：中")
                    setMotorSpeed(500)
                    println("洗完了")
                }
                3 -> {
                    println("放水")
                    println("水放满了")
                    println("狂揉开始，发动机转速：快")
                    setMotorSpeed(1000)
                    println("洗完了")
                }
                else -> println("选择模式错误，不能开始洗衣服哦")
            }
        }
    }
    private fun setMotorSpeed(speed:Int){
        println("当前发动机转速为${speed}圈/秒")
    }
}
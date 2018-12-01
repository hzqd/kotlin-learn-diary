import java.lang.Exception

fun main(args: Array<String>) {
    var list = intArrayOf(0)
    for (i in 0..1){
        try {
            list[i] = 1 / i
            println(list[i])
        }catch(e: ArithmeticException){
            e.printStackTrace()
        }catch(e: ArrayIndexOutOfBoundsException){
            e.printStackTrace()
        }catch(e: Exception){
            e.printStackTrace()
        }finally {
            println("Finally "+i)
        }
    }

}
/*人机交互：
	意念交互         语音交互	        眼动跟踪	        体感交互	        打字交互
	Brain Interface	Voice Interface	Eye Interface	Body Interface	Type Interface
*/
//加法计算器：
fun main (args: Array<String>):Unit{
    while (true) {
        println("欢迎使用加法计算器")
        println("请输入第一个数字")
        var num1str = readLine()
        println("请输入第二个数字")
        var num2str = readLine()
        try{
            var num1:Int = num1str!!.toInt()
            var num2:Int = num2str!!.toInt()
            println("${num1}+${num2}=${num1+num2}")
        }	catch(e: Exception){
            println("人类，请输入数字，该数据类型不正确！")
        }
    }
//Author:hzqd
//Email:hzqdfs@google.com
//2018年 11月 26日 星期一 21:19:52 CST
}
/*面向对象入门：
	1.长方形
	2.小女孩
	3.静态属性和动态行为
*/
class Rect(var height:Int, var width:Int)
class Girl(var character:String, var voice:String, var appearance:String)
    fun smile(){print("小女孩甜甜的笑了")}
    fun cry(){print("小女孩伤心的哭了")}
    fun angry(){print("小女孩生气的挥拳")}
fun main (args: Array<String>):Unit{
    var rect01 = Rect(height=20,width=10)
        println("长方形的高度：${rect01.height}")
        println("长方形的宽度：${rect01.width}")
    var girl01 = Girl(character="温柔",voice="甜美",appearance="かわい")
    smile()
        println("，看上去${girl01.appearance}。")
    cry()
        println("，听起来很${girl01.voice}。")
    angry()
        println("，感觉很${girl01.character}。")
}

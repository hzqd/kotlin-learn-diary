import java.util.TreeMap //导入map包
import java.math.BigInteger //导入BigInteger包
//具名参数和默认参数
val π = 3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679821480865132823f
fun 获取正方形面积(边长:Float):Float{return 边长*边长}
fun 获取长方形面积(长:Float,宽:Float):Float{return 长*宽}
fun 获取圆的周长1(派:Float=π,半径:Float):Float{return 2*派*半径}
fun 获取圆的周长2(派:Float=π,直径:Float):Float{return 派*直径}
fun 获取圆柱体的体积(派:Float=π,半径:Float,高:Float):Float{return 派*半径*半径*高}
fun 获取球的表面积(派:Float=π,半径:Float):Float{return 4*派*半径*半径}
//以上是小学数学公式
fun main(args: Array<String>):Unit{
/*fun is short of function, 接受参数名是args，数据类型字符串
编写规则：
fun 函数名（参数名：参数类型）：返回值类型{
	函数体	注：函数参数名args可以随意起，叫aa、bb都行；Unit代表无返回值，可以省略不写
}
*/
    println("hello kotlin")
//变量的取值范围：
    val a:Byte = Byte.MAX_VALUE
    val b:Byte = Byte.MIN_VALUE
    val c:Short = Short.MAX_VALUE
    val d:Short = Short.MIN_VALUE
    val e:Int = Int.MAX_VALUE
    val f:Int = Int.MIN_VALUE
    val g:Long = Long.MAX_VALUE
    val h:Long = Long.MIN_VALUE
    println("Byte的最大值:"+a)
    println("Byte的最小值:"+b)
    println("Short的最大值:"+c)
    println("Short的最小值:"+d)
    println("Int的最大值:"+e)
    println("Int的最小值:"+f)
    println("Long的最大值:"+g)
    println("Long的最小值:"+h)
    //开始定义功能：
    fun print1star(){println("   *")}
    fun print3star(){println("  ***")}
    fun print5star(){println(" *****")}
//开始打印函数：
    print1star()
    print3star()
    print5star()
    println("*******")
    print5star()
    print3star()
    print1star()
//布尔运算。Boolean 布尔  true 真  false 假
//小学数学题：比较数字4和6的大小
    var num1 = 4
    var num2 = 6
    println(num1 < num2)
//初中数学题：比较根号5减根号4 与 根号4减根号3的大小
    var num3 = Math.sqrt(5.0) - Math.sqrt(4.0)
    var num4 = Math.sqrt(4.0) - Math.sqrt(3.0)
    println(num3 > num4)
    println("num3="+num3)
    println("num4="+num4)
//高中数学题：比较2的100次方与3的75次方的大小
    var num5 = Math.pow(2.0,100.0)
    var num6 = Math.pow(3.0,75.0)
    println(num5 < num6)
    println("num5="+num5)
    println("num6="+num6)
//求1～100的和：
    var nums = 1 .. 100
    var results = 0
    for(num in nums){
        results = results+num
    }
    println("结果：${results}")
//打印16～1的双数：
    var nums2 = 1 until 17	//[1,17)=[1,16]
    var nums3 = nums2.reversed()
    for(z in nums3 step 2){
        println(z)
    }
//具名参数和默认参数——小学数学公式：
    var o = 获取正方形面积(边长=8.6f)
    println(o)
    var w = 获取长方形面积(长=7.2f,宽=9.4f)
    println(w)
    var p = 获取圆的周长1(半径=4.3f)
    println(p)
    var q = 获取圆的周长2(直径=2.7f)
    println(q)
    var u = 获取圆柱体的体积(半径=4.8f,高=7.3f)
    println(u)
    var v = 获取球的表面积(半径=6.8f)
    println(v)
//字符串和数字：
    var s = "hello"
    println(s)
    var t = 200
    var r = "300"
    s = t.toString()	//把数字t转换成字符串放入s里面
    t = r.toInt()		//把字符串s转换成数字放入t里面
    println(s)
    println(t)
//递归、阶乘：
    var number = BigInteger("100")	//计算100的阶乘
    println(fact(number))
/*尾递归优化：
	累加：
*/
    var result = 0
    println(ollAdd(10,result))
/*函数及函数表达式：*/
    var results1 = sum(3,5) 	//功能模块sum在第242行定义
    println(results1)
    var i = {x:Int,y:Int -> x+y}
    var results2 = i(3,5)
    println(results2)
    var j:(Int,Int)->Int = {x,y->x+y}
    var results3 = j(3,5)
    println(results3)
//闭包：
    var names = listOf("小明","Tom","まどか")
    names.forEach { println(it) }	
/*list&map：*/
    var list = listOf("买鸡蛋","买大米","买钢笔","买冰淇淋")
    for((k,l)in list.withIndex()){
        println("$k $l")
    }
    var map = TreeMap<String,String>()	//需要在顶部导入map包
    map["好"] = "good"
    map["学习"] = "study"
    map["天"] = "sky"
    map["向上"] = "up"
    println(map["好"])
    println(map["学习"])
    println(map["天"])
    println(map["向上"])
/*字符串比较：*/
    var str1="张三"
    var str2="李四"
//.equals()相当于==
    println(str1.equals(str2))
    var str3="Andy"
    var str4="Andy"
    var str5="andy"
    println(str3==str4)
    println(str4==str5)
//第二个参数为true代表忽略字母的大小写
    println(str1.equals(str2,true))
    println(str4.equals(str5,true))
/*空值处理：*/
    var result1 = heat("水")
    println(result1)
    var result2 = heat(null)
    println(result2)
/*-------------------------------------------------------------------------------------
 *以下内容为视频中的一个计算器小实验：
*/
    var x = 8
    var y = 2
    println("x+y="+plus(x,y))
    println("x-y="+sub(x,y))
    println("x*y="+mutl(x,y))
    println("x/y="+devide(x,y))
/*—————————————————————————————————————————————————————————————————————————————————————
 *以下内容为视频中的第一次作业讲解：
*/
    var result0 = sayHello("史莱姆")
    println(result0)
    println(checkAge(20))
//以下内容为一个简易的日记生成器：
    var diary = diaryGenerater("哈大娘的店")
    println(diary)
    diary = diaryGenerater("中山公园")
    println(diary)
    diary = diaryGenerater("天都")
    println(diary)
    diary = diaryGenerater("比翼城")
    println(diary)
//以下内容为一个简易的颜值判断器：
    var score = 95
    checkFace(score)
//返回两个数字当中较大的那个数字：
    var m = 3
    var n = 5
    println("${m}と${n}中较大的数为${returnBig(m,n)}")
//学生的成绩：
    gradeStudent(8)
}  /*～～～～～～～～～～main结束～～～～～～～～～～main结束～～～～～～～～～～*/
//空值处理：
fun heat(str:String?):String{return "热"+str}
//计算器实验，定义功能：
fun plus(x:Int, y:Int):Int{return x+y}
fun sub(x:Int, y:Int):Int{return x-y}
fun mutl(x:Int, y:Int):Int{return x*y}
fun devide(x:Int, y:Int):Int{return x/y}
/*计算器实验，定义完成。
Homework，家庭作业讲解：
 *请编写函数，函数名为sayHello，方法的返回值是String类型，参数是String类型，名称为name
 *请编写函数，函数名为checkAge，方法的返回值是Boolean类型，参数是整数类型，名称为age
*/
fun sayHello(name:String):String{
    return "hello, world"+name
}
fun checkAge(age:Int):Boolean{
    if(age>18)
        return true
    else
        return false
}
//日记生成器：
fun diaryGenerater(placeName:String):String{
    var temple = """
今天天气晴朗，万里无云，我们去${placeName}游玩，
首先映入眼帘的是，${placeName}${placeName.length}个金闪闪的大字。
"""
    return temple
}
//颜值判断器：
fun checkFace(score:Int){
    if(score>80)
        println("这是一个帅哥")
    else
        println("这是一个衰哥")
}
//返回大数字：
fun returnBig(m:Int, n:Int):Int{
    if(m>n)
        return m
    else
        return n
}
//学生的成绩：
fun gradeStudent(score:Int){
    when(score){
        10 -> println("考了满分，棒棒哒")
        9 -> println("干得不错")
        8 -> println("还可以")
        7 -> println("还需努力")
        6 -> println("刚好及格")
        else -> println("需要加油哦")
    }
}
//函数及函数表达式：
fun sum(x:Int,y:Int):Int=x+y
//递归、阶乘：
fun fact(number:BigInteger):BigInteger{
    if(number==BigInteger.ONE) return BigInteger.ONE else return number*fact(number-BigInteger.ONE)
}
tailrec fun ollAdd(nu:Int,result:Int):Int{
    println("计算机进行第${nu}次运算，结果=${result}")
    if(nu==0)
        return 1
    else
        return ollAdd(nu-1,result+nu)
}

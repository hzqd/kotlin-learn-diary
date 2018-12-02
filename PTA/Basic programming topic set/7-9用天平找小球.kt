/*三个球A、B、C，大小形状相同且其中有一个球与其他球重量不同。要求找出这个不一样的球。
输入格式：
  输入在一行中给出3个正整数，顺序对应球A、B、C的重量。
输出格式：
  在一行中输出唯一的那个不一样的球。
输入样例：
  1 1 2
输出样例：
  C
*/
//fun main(args: Array<String>) {
//    val a = readLine()
//    val b = readLine()
//    val c = readLine()
//    when{
//        a==b -> print("C")
//        a==c -> print("B")
//        b==c -> print("A")
//    }
//}
import java.util.Scanner
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val a:Int = sc.nextInt()
    val b:Int = sc.nextInt()
    val c:Int = sc.nextInt()
    if(a == b)print("C")else if(a == c)print("B")else if(b == c)print("A")
}

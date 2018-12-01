/*程序每次读入一个正3位数，然后输出按位逆序的数字。注意：当输入的数字含有结尾的0时，输出不应带有前导的0。比如输入700，输出应该是7。
输入格式：
  每个测试是一个3位的正整数。
输出格式：
  输出按位逆序的数。
输入样例：
  123
输出样例：
  321
*/
//fun main(args: Array<String>) {
//    val a = readLine()
//    val b = a?.reversed()
//    println(b)
//}
import java.util.Scanner
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val b = n / 100         //取出百位
    val s = n % 100 / 10    //取出十位
    val g = n % 10          //取出个位
    println(g * 100 + s * 10 + b)
}

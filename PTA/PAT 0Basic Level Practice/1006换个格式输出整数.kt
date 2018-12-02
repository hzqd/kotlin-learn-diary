/*让我们用字母 B 来表示“百”、字母 S 表示“十”，用 12...n 来表示不为零的个位数字 n（<10），换个格式来输出任一个不超过 3 位的正整数。例如 234 应该被输出为 BBSSS1234，因为它有 2 个“百”、3 个“十”、以及个位的 4。
输入格式：
  每个测试输入包含 1 个测试用例，给出正整数 n（<1000）。
输出格式：
  每个测试用例的输出占一行，用规定的格式输出 n。
输入样例 1：
234
输出样例 1：
BBSSS1234
输入样例 2：
23
输出样例 2：
SS123
*/
//import java.util.Scanner
//fun main(args: Array<String>) {
//    var n = 0
//    val s = Scanner(System.`in`)
//    n = s.nextInt()
//    val hundreds_place = n / 100
//    val decade = (n - hundreds_place * 100) / 10
//    val unit = n % 10
//    for (i in 1..hundreds_place)    print("B")
//    for (i in 1..decade)    print("S")
//    for (i in 1..unit)  print(i)
//}
import java.util.Scanner
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`) ; val num = scanner.nextInt()
    val a: Int ; val b: Int ; val c: Int ; var A = "" ; var B = "" ; var C = ""
    a = num / 100 ; b = num % 100 / 10 ; c = num % 10
    for (i in 0 until a) A = A + "B" ; for (i in 0 until b) B = B + "S" ; for (i in 1..c) C = C + i
    println(A + B + C)
}

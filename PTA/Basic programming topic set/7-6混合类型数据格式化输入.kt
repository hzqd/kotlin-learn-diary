/*本题要求编写程序，顺序读入浮点数1、整数、字符、浮点数2，再按照字符、整数、浮点数1、浮点数2的顺序输出。
输入格式：
  输入在一行中顺序给出浮点数1、整数、字符、浮点数2，其间以1个空格分隔。
输出格式：
  在一行中按照字符、整数、浮点数1、浮点数2的顺序输出，其中浮点数保留小数点后2位。
输入样例：
  2.12 88 c 4.7
输出样例：
  c 88 2.12 4.70
*/
import java.text.DecimalFormat
import java.util.Scanner
fun main(args: Array<String>) {
  val df = DecimalFormat("######0.00")
  val sc = Scanner(System.`in`)
  val a: Double
  val d: Double
  val b: Int
  val e: String
  val c: Char
  a = sc.nextDouble()
  b = sc.nextInt()
  e = sc.next()
  c = e[0]
  d = sc.nextDouble()
  println(c + " " + b + " " + a + " " + df.format(d))
}

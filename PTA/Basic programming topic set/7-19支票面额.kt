/*一个采购员去银行兑换一张y元f分的支票，结果出纳员错给了f元y分。采购员用去了n分之后才发觉有错，于是清点了余额尚有2y元2f分，问该支票面额是多少？
输入格式：
  输入在一行中给出小于100的正整数n。
输出格式：
  在一行中按格式y.f输出该支票的原始面额。如果无解，则输出No Solution。
输入样例1：
23
输出样例1：
25.51
输入样例2：
22
输出样例2：
No Solution
*/
import java.util.Scanner
fun main(args: Array<String>) {
  val sc = Scanner(System.`in`)
  val n = sc.nextInt()
  var f: Int
  var y: Int
  var number1 = 0
  var number2 = 0
  var num = 0
  y = 0
  while (y < 50) {
    f = 0
    while (f < 100) {
      if (98 * f - 199 * y == n) {
        number1 = y
        number2 = f
        num = 1
        break
      }
      f++
    }
    y++
  }
  if(num == 0)println("No Solution")else System.out.printf("%d.%d", number1, number2)
}

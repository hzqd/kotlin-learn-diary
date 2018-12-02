/*给定两个整数A和B，输出从A到B的所有整数以及这些数的和。
输入格式：
  输入在一行中给出2个整数A和B，其中−100≤A≤B≤100，其间以空格分隔。
输出格式：
  首先顺序输出从A到B的所有整数，每5个数字占一行，每个数字占5个字符宽度，向右对齐。最后在一行中按Sum = X的格式输出全部数字的和X。
输入样例：
  -3 8
输出样例：
   -3   -2   -1    0    1
    2    3    4    5    6
    7    8
Sum = 30
*/
import java.util.Scanner
fun main(args: Array<String>) {
  val sc = Scanner(System.`in`)
  val a: Int
  val b: Int
  var sum = 0
  var count = 0
  a = sc.nextInt()
  b = sc.nextInt()
  for (i in a..b) {
    System.out.printf("%5d", i)
    count = count + 1
      if (count % 5 == 0 && i != b) {
        println()
      }
  }
  println()
  for (j in a..b) {
    sum += j
  }
  print("Sum = $sum")
}

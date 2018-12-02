/*本题要求对任意给定的正整数N，求方程X^2+Y^2=N的全部正整数解。
输入格式：
  输入在一行中给出正整数N（≤10000）。
输出格式：
  输出方程X^2+Y^2=N的全部正整数解，其中X≤Y。每组解占1行，两数字间以1空格分隔，按X的递增顺序输出。如果没有解，则输出No Solution。
输入样例1：
884
输出样例1：
10 28
20 22
输入样例2：
11
输出样例2：
No Solution
*/
//import java.util.Scanner
//fun main(args: Array<String>) {
//  val sc = Scanner(System.`in`)
//  val N = sc.nextInt()
//  var a = 1
//  if (N <= 10000) {
//    var X = 1
//    while (X <= Math.sqrt((N / 2).toDouble())) {
//      var Y = 1
//      while (Y <= Math.sqrt(N.toDouble())) {
//        if (X * X + Y * Y == N) {
//          a = 0
//          println(X.toString() + " " + Y)
//        }
//      Y++
//      }
//    X++
//    }
//    if (a == 1) {
//      println("No Solution")
//    }
//  }
//}
import java.util.Scanner
fun main(args: Array<String>) {
  val scan = Scanner(System.`in`)
  val n = scan.nextInt()
  var x = 1
  var y = 1
  var flag = 0
  while (x < 100) {
    y = x
    while (y < 100) {
      if (x * x + y * y == n) {
        println(x.toString() + " " + y)
        flag = 1
        break
      }
      y++
    }
    x++
  }
  if (flag == 0) {
    print("No Solution")
  }
}

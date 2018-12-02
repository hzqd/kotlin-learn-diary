/*给定不超过6的正整数A，考虑从A开始的连续4个数字。请输出所有由它们组成的无重复数字的3位数。
输入格式：
  输入在一行中给出A。
输出格式：
  输出满足条件的的3位数，要求从小到大，每行6个整数。整数间以空格分隔，但行末不能有多余空格。
输入样例：
2
输出样例：
234 235 243 245 253 254
324 325 342 345 352 354
423 425 432 435 452 453
523 524 532 534 542 543
*/
import java.util.Scanner
fun main(args: Array<String>) {
  val sc = Scanner(System.`in`)
  val a = sc.nextInt()
  var count = 0
  val array = intArrayOf(a, a + 1, a + 2, a + 3)
  for (i in 0..3) {
    for (j in 0..3) {
      for (k in 0..3) {
        if (i != j && j != k && i != k) {
          count++
          if (count % 6 == 0) {
            print(array[i])
            print(array[j])
            print(array[k])
            println()
          } else {
            print(array[i])
            print(array[j])
            print(array[k].toString() + " ")
          }
        }
      }
    }
  }
}

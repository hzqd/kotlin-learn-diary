/*一个数组A中存有N（>0）个整数，在不允许使用另外数组的前提下，将每个整数循环向右移M（≥0）个位置，即将A中的数据由（A0 A1...AN-1变换为AN-M...AN-1 A0-A1...AN-M-1）（最后M个数循环移至最前面的M个位置）。如果需要考虑程序移动数据的次数尽量少，要如何设计移动的方法？
输入格式:
  每个输入包含一个测试用例，第1行输入N（1≤N≤100）和M（≥0）；第2行输入N个整数，之间用空格分隔。
输出格式:
  在一行中输出循环右移M位以后的整数序列，之间用空格分隔，序列结尾不能有多余空格。
输入样例:
6 2
1 2 3 4 5 6
输出样例:
5 6 1 2 3 4
*/
/**思路:
 * 1.n为数组元素个数 x为右移的位置个数;
 * 2.因为如果x>n那么右移x次效果和右移x%n次效果是一样的;
 * 3.所以循环y次,y=x%n;
 * 4.题目要数组元素循环右移,只要从n-y开始输出到数组位置末;
 * 5.然后从位置0开始输出到位置n-y;
 */
import java.util.Scanner
fun main(args: Array<String>) {val sc = Scanner(System.`in`)
    val n = sc.nextInt() ; val x = sc.nextInt() ; val a = IntArray(n)
    for (i in 0 until n) a[i] = sc.nextInt()    ; val y = x % n
    for (i in n - y until n) print(a[i].toString() + " ")
    for (i in 0 until n - y - 1) print(a[i].toString() + " ")
    println(a[n - y - 1])
}

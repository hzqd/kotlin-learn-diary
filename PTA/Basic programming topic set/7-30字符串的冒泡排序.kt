/*我们已经知道了将N个整数按从小到大排序的冒泡排序法。本题要求将此方法用于字符串序列，并对任意给定的K（<N），输出扫描完第K遍后的中间结果序列。
输入格式：
  输入在第1行中给出N和K（1≤K<N≤100），此后N行，每行包含一个长度不超过10的、仅由小写英文字母组成的非空字符串。
输出格式：
  输出冒泡排序法扫描完第K遍后的中间结果序列，每行包含一个字符串。
输入样例：
6 2
best
cat
east
a
free
day
输出样例：
best
a
cat
day
east
free
*/
// 代码有误，待修复。
import java.util.Scanner
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val k = sc.nextInt()
    val a = arrayOfNulls<String>(n + 1)
    for (i in 1..n) {
        a[i] = sc.next()       //输入字符串
    }
    for (i in 1..k) {
        var temp = a[1]
        for (j in 1 until n) {
            if (a[j]!!.compareTo(a[j + 1]) > 0) {   //比较字符串    conpareTo()
                temp = a[j]
                a[j] = a[j + 1]          //同数字的冒泡排序
                a[j + 1] = temp
            }
        }
    }
    for (i in 1..n) {
        println(a[i])           //输出
    }
}

/*一群猴子要选新猴王。新猴王的选择方法是：让N只候选猴子围成一圈，从某位置起顺序编号为1~N号。从第1号开始报数，每轮从1报到3，凡报到3的猴子即退出圈子，接着又从紧邻的下一只猴子开始同样的报数。如此不断循环，最后剩下的一只猴子就选为猴王。请问是原来第几号猴子当选猴王？
输入格式：
  输入在一行中给一个正整数N（≤1000）。
输出格式：
  在一行中输出当选猴王的编号。
输入样例：
11
输出样例：
7
*/
import java.util.Scanner
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val a: Int
    var t: Int
    var j: Int
    a = sc.nextInt()
    val array = IntArray(a)
    for (i in 0 until a) {
        array[i] = 1
    }
    t = -1
    for (i in 1..a) {
        j = 1
        while (j <= 3) {
            t = (t + 1) % a
            if (array[t] == 1) {
                j++
            }
        }
        if (i == a) {
            print(t + 1)
        }
        array[t] = 0
    }
}

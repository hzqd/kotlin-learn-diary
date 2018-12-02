/*给定一系列正整数，请按要求对数字进行分类，并输出以下 5 个数字：
  A1 = 能被 5 整除的数字中所有偶数的和；
  A2 = 将被 5 除后余 1 的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4⋯；
  A3 = 被 5 除后余 2 的数字的个数；
  A4 = 被 5 除后余 3 的数字的平均数，精确到小数点后 1 位；
  A5 = 被 5 除后余 4 的数字中最大数字。
输入格式：
  每个输入包含 1 个测试用例。每个测试用例先给出一个不超过 1000 的正整数 N，随后给出 N 个不超过 1000 的待分类的正整数。数字间以空格分隔。
输出格式：
  对给定的 N 个正整数，按题目要求计算 A1 ~ A5
  并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。
  若其中某一类数字不存在，则在相应位置输出 N。
输入样例 1：
13 1 2 3 4 5 6 7 8 9 10 20 16 18
输出样例 1：
30 11 2 9.7 9
输入样例 2：
8 1 2 4 5 6 7 9 16
输出样例 2：
N 11 2 N 9
*/
//import java.util.Scanner
//fun main(args: Array<String>) { val scanner = Scanner(System.`in`)
//    val N = scanner.nextInt() ; val num = IntArray(N)
//    for(i in 0 until N) num[i] = scanner.nextInt()
//    var A1=0;var A2=0;var A3=0;var A5=0;var S4=0;val A4:Double;var countA4=0;var count=0
//    for (i in 0 until N) { val remainder = num[i] % 5
//        if (remainder == 0 && num[i] % 2 == 0) A1 = A1 + num[i]
//        if (remainder == 1) {
//            if (count % 2 == 0) A2 = A2 + num[i] else A2 = A2 - num[i]
//            count++         }
//        if (remainder == 2) A3++
//        if (remainder == 3) { S4 = S4 + num[i]
//            countA4++       }
//        if (remainder == 4) { if (A5 < num[i]) A5 = num[i] }
//    }
//    if (A1 == 0) print("N ") else print(A1.toString() + " ")
//    if (A2 == 0) print("N ") else print(A2.toString() + " ")
//    if (A3 == 0) print("N ") else print(A3.toString() + " ")
//    if (S4 == 0) print("N ") else {A4 = 1.0 * S4 / countA4
//                                   Math.round(A4)
//                                   print(String.format("%.1f", A4) + " ") }
//    if (A5 == 0) print("N") else print(A5)
//}
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.text.*
@Throws(IOException::class)
fun main(args: Array<String>) {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val s = bf.readLine()
    bf.close()
    val str = s.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val len = str.size
    val num = IntArray(len)

    for (i in 0 until len) {
        num[i] = Integer.parseInt(str[i])
    }
    val a = doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    var extra: Int
    var flag: Int
    var sum: Int
    var cnt: Int
    cnt = 0
    sum = cnt
    extra = sum
    flag = 1
    for (i in 1 until len) {
        extra = num[i] % 5
        if (num[i] % 2 == 0 && extra == 0) {
            a[1] += num[i].toDouble()
        }
        when (extra) {
            1 -> {
                a[2] += (flag * num[i]).toDouble()
                flag = -flag
            }
            2 -> a[3]++
            3 -> {
                sum += num[i]
                cnt++
            }
            4 -> if (num[i] > a[5]) a[5] = num[i].toDouble()
        }
    }
    a[4] = sum * 1.0 / cnt
    val df = DecimalFormat("#.#")
    for (i in 1..5) {
        if (a[i].toInt() == 0)
            print("N")
        else if (i != 4)
            print(a[i].toInt())
        else if (i == 4) print(df.format(a[i]))
        if (i != 5) print(" ")
    }
}

/*本题要求编写程序，计算两个有理数的和。
输入格式：
  输入在一行中按照a1/b1 a2/b2的格式给出两个分数形式的有理数，其中分子和分母全是整形范围内的正整数。
输出格式：
  在一行中按照a/b的格式输出两个有理数的和。注意必须是该有理数的最简分数形式，若分母为1，则只输出分子。
输入样例1：
1/3 1/6
输出样例1：
1/2
输入样例2：
4/3 2/3
输出样例2：
2
*/
import java.util.Scanner
fun gcd(a: Int, b: Int): Int { var m = 1
    for (i in 1 until Math.min(a, b)) {if (a % i == 0 && b % i == 0) {m = i} }
    return m }
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val str1 = sc.next()
    val str2 = sc.next()
    val num1 = str1.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val num2 = str2.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val m = Integer.parseInt(num1[0]) * Integer.parseInt(num2[1]) + Integer.parseInt(num1[1]) * Integer.parseInt(num2[0])
    val n = Integer.parseInt(num1[1]) * Integer.parseInt(num2[1])
    val f = gcd(m, n)
    if(m % n != 0)print((m / f).toString() + "/" + n / f)else print(m / n)
}

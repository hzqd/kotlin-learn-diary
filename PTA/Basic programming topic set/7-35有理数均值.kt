/*本题要求编写程序，计算N个有理数的平均值。
输入格式：
  输入第一行给出正整数N（≤100）；第二行中按照a1/b1 a2/b2 …的格式给出N个分数形式的有理数，其中分子和分母全是整形范围内的整数；如果是负数，则负号一定出现在最前面。
输出格式：
  在一行中按照a/b的格式输出N个有理数的平均值。注意必须是该有理数的最简分数形式，若分母为1，则只输出分子。
输入样例1：
4
1/2 1/6 3/6 -5/10
输出样例1：
1/6
输入样例2：
2
4/3 2/3
输出样例2：
1
*/
// 代码有误，待修复。
import java.util.Scanner
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    var sumMen: Int
    var sumDeo: Int
    println("请输入一个不超过100的正整数N:")
    val N = sc.nextInt()
    println("输入一行N个带分式的有理数求均值：")
    val a = arrayOfNulls<String>(N)
    for (i in 0 until N) {
        a[i] = sc.next()
    }
    val b = Array<Array<String>>(N) { !!arrayOfNulls(2) }
    for (i in 0 until N) {//分割N个字符串，存入b[i][0]b[i][1]中
        val c = a[i]!!.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()//标点 -也被算进去了导致分割出错，只用/就分割就行，不用正则
        b[i][0] = c[0]
        b[i][1] = c[1]
    }
    val d = Array(N) { IntArray(2) }
    for (i in 0..1) {
        for (j in 0..1) {
            d[i][j] = Integer.parseInt(b[i][j])
        }
    }
    sumMen = d[0][0] * d[1][1] + d[0][1] * d[1][0]
    sumDeo = d[0][1] * d[1][1]
    if (N == 2) {
        sumMen /= N
        val c = f(sumMen, sumDeo)
        sumMen /= c
        sumDeo /= c
        if (sumMen == 1)
        //分母为1
            println(sumMen)
        else
            println(sumMen.toString() + "/" + sumDeo)
    } else if (N > 2) {
        for (i in 2 until N) {
            for (j in 0..1) {
                d[i][j] = Integer.parseInt(b[i][j])
            }
            sumMen = sumMen * d[i][1] + d[i][0] * sumDeo
            sumDeo = sumDeo * d[i][1]
        }
        sumMen /= N//求均值
        val c = f(sumMen, sumDeo)
        sumMen /= c
        sumDeo /= c
        if (sumDeo == 1)
            println(sumMen)
        else
            println(sumMen.toString() + "/" + sumDeo)
    }
}
fun f(a: Int, b: Int): Int {//该方法返回最大公约数
    var a = a
    var b = b
    if (a < b) {
        val c = a
        a = b
        b = c
    }
    var r = a % b
    while (r != 0) {
        a = b
        b = r
        r = a % b
    }
    return b
}

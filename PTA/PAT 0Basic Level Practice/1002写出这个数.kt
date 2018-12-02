/*读入一个正整数 n，计算其各位数字之和，用汉语拼音写出和的每一位数字。
输入格式：
  每个测试输入包含 1 个测试用例，即给出自然数 n 的值。这里保证 n 小于 10^100
输出格式：
  在一行内输出 n 的各位数字之和的每一位，拼音数字间有 1 空格，但一行中最后一个拼音数字后没有空格。
输入样例：
1234567890987654321123456789
输出样例：
yi san wu
*/
import java.util.Scanner
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.next()
    val Num = IntArray(n.length)
    var sum = 0
    for (i in 0 until n.length) {
        Num[i] = n[i].toInt() - 48
        sum = sum + Num[i]
    }
    val NumPy = arrayOf("ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu")
    val sumStr = Integer.toString(sum)
    for (i in 0 until sumStr.length) {
        if (i < sumStr.length - 1)
            print(NumPy[sumStr[i].toInt() - 48] + " ")
        else
            print(NumPy[sumStr[i].toInt() - 48])
    }
}

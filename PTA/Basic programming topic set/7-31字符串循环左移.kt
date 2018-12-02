/*输入一个字符串和一个非负整数N，要求将字符串循环左移N次。
输入格式：
  输入在第1行中给出一个不超过100个字符长度的、以回车结束的非空字符串；第2行给出非负整数N。
输出格式：
  在一行中输出循环左移N次后的字符串。
输入样例：
Hello World!
2
输出样例：
llo World!He
*/
import java.util.Scanner
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val str = sc.nextLine()
    val a = str.length
    var b = sc.nextInt()
    b %= a
    for (i in b until str.length) {
        print(str[i])
    }
    for (i in 0 until b) {
        print(str[i])
    }
}

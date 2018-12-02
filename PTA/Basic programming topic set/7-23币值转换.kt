/*输入一个整数（位数不超过9位）代表一个人民币值（单位为元），请转换成财务要求的大写中文格式。如23108元，转换后变成“贰万叁仟壹百零捌”元。为了简化输出，用小写英文字母a-j顺序代表大写数字0-9，用S、B、Q、W、Y分别代表拾、百、仟、万、亿。于是23108元应被转换输出为“cWdQbBai”元。
输入格式：
  输入在一行中给出一个不超过9位的非负整数。
输出格式：
  在一行中输出转换后的结果。注意“零”的用法必须符合中文习惯。
输入样例1：
813227345
输出样例1：
iYbQdBcScWhQdBeSf
输入样例2：
6900
输出样例2：
gQjB
*/
import java.util.Scanner
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val dw = arrayOfNulls<String>(10)
    dw[1] = ""
    dw[2] = "S"
    dw[3] = "B"
    dw[4] = "Q"
    dw[5] = "W"
    dw[6] = "S"
    dw[7] = "B"
    dw[8] = "Q"
    dw[9] = "Y"
    val num = arrayOfNulls<String>(10)
    num[0] = "a"
    num[1] = "b"
    num[2] = "c"
    num[3] = "d"
    num[4] = "e"
    num[5] = "f"
    num[6] = "g"
    num[7] = "h"
    num[8] = "i"
    num[9] = "j"
    val s = sc.next()
    val len = s.length
    if (len == 1) {        //输入一位数  单独考虑
        println(num[s[0].toInt() - 48])
    } else {
        for (i in 0 until len) {
            if (s[i].toInt() - 48 != 0) {        //数位上不为0的情况
                print(num[s[i].toInt() - 48] + dw[len - i])
            } else if (i < len - 1 && i != len - 5 && s[i].toInt() - 48 == 0 && s[i + 1].toInt() - 48 != 0) {//数位上是0的情况   有多个连续的0 值输出一个
                print(num[s[i].toInt() - 48])
            } else if (len > 5 && i == len - 5 && s[i].toInt() - 48 == 0) {//万为是0的情况
                if (len == 9 && s[1].toInt() - 48 == 0 && s[2].toInt() - 48 == 0 && s[3].toInt() - 48 == 0) {        //一亿的情况
                } else {
                    print("W")
                }
            }
        }
    }
}

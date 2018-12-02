/*输入一个整数，输出每个数字对应的拼音。当整数为负数时，先输出fu字。十个数字对应的拼音如下：
0: ling
1: yi
2: er
3: san
4: si
5: wu
6: liu
7: qi
8: ba
9: jiu
输入格式：
  输入在一行中给出一个整数，如：1234。
    提示：整数包括负数、零和正数。
输出格式：
  在一行中输出这个整数对应的拼音，每个数字的拼音之间用空格分开，行末没有最后的空格。如 yi er san si。
输入样例：
-600
输出样例：
fu liu ling ling
*/
import java.util.Scanner
fun main(args: Array<String>) {
  val sc = Scanner(System.`in`)
  val a = sc.nextInt()
  var i = 0
  val str = a.toString()
  val array = arrayOf("ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu", "fu")
    while (i < str.length - 1) {
      val c = str[i]
        if (c == '-') {
            print(array[10] + " ")
        } else if (c == '0') {
            print(array[0] + " ")
        } else if (c == '1') {
            print(array[1] + " ")
        } else if (c == '2') {
            print(array[2] + " ")
        } else if (c == '3') {
            print(array[3] + " ")
        } else if (c == '4') {
            print(array[4] + " ")
        } else if (c == '5') {
            print(array[5] + " ")
        } else if (c == '6') {
            print(array[6] + " ")
        } else if (c == '7') {
            print(array[7] + " ")
        } else if (c == '8') {
            print(array[8] + " ")
        } else if (c == '9') {
            print(array[9] + " ")
        }
      i++
    }
        if (i == str.length - 1) {
          val c = str[i]
          if (c == '-') {
              print(array[10])
          } else if (c == '0') {
              print(array[0])
          } else if (c == '1') {
              print(array[1])
          } else if (c == '2') {
              print(array[2])
          } else if (c == '3') {
              print(array[3])
          } else if (c == '4') {
              print(array[4])
          } else if (c == '5') {
              print(array[5])
          } else if (c == '6') {
              print(array[6])
          } else if (c == '7') {
              print(array[7])
          } else if (c == '8') {
              print(array[8])
          } else if (c == '9') {
              print(array[9])
          }
      }
}

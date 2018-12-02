/*你的程序要读入一行文本，其中以空格分隔为若干个单词，以.结束。你要输出每个单词的长度。这里的单词与语言无关，可以包括各种符号，比如it's算一个单词，长度为4。注意，行中可能出现连续的空格；最后的.不计算在内。
输入格式：
  输入在一行中给出一行文本，以.结束
    提示：用scanf("%c",...);来读入一个字符，直到读到.为止。
输出格式：
  在一行中输出这行文本对应的单词的长度，每个长度之间以空格隔开，行末没有最后的空格。
输入样例：
It's great to see you here.
输出样例：
4 5 2 3 3 4
*/
//部分正确：
import java.util.Scanner
fun main(args: Array<String>) {
    val `in` = Scanner(System.`in`)
    val input = `in`.nextLine()
    if (input.endsWith(".")) {// 判断input最后是否以.结束
        val output = input.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()// 以空格为间隔 把input分割为若干个字符串
        // 放入数组output
        var i: Int
        i = 0
        while (i < output.size - 1) {
            if (output[i].length != 0)
            // 长度为0的字符串不输出
                print(output[i].length.toString() + " ")
            i++
        }
        if (output[i].length != 1)
        // 最后一位如果只有.不输出 且最后一位无空格
            print(output[i].length - 1)
    }
}

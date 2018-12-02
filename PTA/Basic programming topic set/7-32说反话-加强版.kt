/*给定一句英语，要求你编写程序，将句中所有单词的顺序颠倒输出。
输入格式：
  测试输入包含一个测试用例，在一行内给出总长度不超过500 000的字符串。字符串由若干单词和若干空格组成，其中单词是由英文字母（大小写有区分）组成的字符串，单词之间用若干个空格分开。
输出格式：
  每个测试用例的输出占一行，输出倒序后的句子，并且保证单词间只有1个空格。
输入样例：
Hello World   Here I Come
输出样例：
Come I Here World Hello
*/
//部分正确：
import java.util.Scanner
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    //输入一组单词,去除掉前后空格
    val str = scanner.nextLine().trim { it <= ' ' }
    //去除掉单词间的空格,可能不只有一个空格，因此用" +"表示至少一个空格
    val strs = str.split(" +".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    for (i in strs.indices.reversed()) {
        print(strs[i])
        if (i != 0)
            print(" ")
        //不是最后一个单词，就输出一个空格
    }
}

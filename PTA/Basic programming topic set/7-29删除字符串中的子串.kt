/*输入2个字符串S1和S2，要求删除字符串S1中出现的所有子串S2，即结果字符串中不能包含S2。
输入格式：
  输入在2行中分别给出不超过80个字符长度的、以回车结束的2个非空字符串，对应S1和S2。
输出格式：
  在一行中输出删除字符串S1中出现的所有子串S2后的结果字符串。
输入样例：
Tomcat is a male ccatat
cat
输出样例：
Tom is a male 
*/
import java.util.Scanner
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    var s1 = sc.nextLine()
    val s2 = sc.nextLine()
    while (s1.contains(s2)) {
        s1 = s1.replace(s2, "") //只需要调用replace函数  用空字符串代替s2的字符串 直至s1字符串中没有s2
    }
    println(s1)
}

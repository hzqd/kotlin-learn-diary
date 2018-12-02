/*将N个整数按从小到大排序的冒泡排序法是这样工作的：从头到尾比较相邻两个元素，如果前面的元素大于其紧随的后面元素，则交换它们。通过一遍扫描，则最后一个元素必定是最大的元素。然后用同样的方法对前N−1个元素进行第二遍扫描。依此类推，最后只需处理两个元素，就完成了对N个数的排序。
  本题要求对任意给定的K（<N），输出扫描完第K遍后的中间结果数列。
输入格式：
  输入在第1行中给出N和K（1≤K<N≤100），在第2行中给出N个待排序的整数，数字间以空格分隔。
输出格式：
  在一行中输出冒泡排序法扫描完第K遍后的中间结果数列，数字间以空格分隔，但末尾不得有多余空格。
输入样例：
6 2
2 3 5 1 6 4
输出样例：
2 1 3 4 5 6
*/
import java.util.Scanner
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val a: Int
    val b: Int
    var temp: Int
    val max: Int
    a = sc.nextInt()
    val array = IntArray(a)
    b = sc.nextInt()
    for (i in 0 until a) {
        array[i] = sc.nextInt()
    }
    max = array[0]
    for (i in 0 until b) {
        for (j in 0 until array.size - 1 - i) {
            if (array[j] > array[j + 1]) {
                temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
    }
    for (i in array.indices) {
        if (i == array.size - 1) {
            print(array[i])
        } else {
            print(array[i].toString() + " ")
        }
    }
}

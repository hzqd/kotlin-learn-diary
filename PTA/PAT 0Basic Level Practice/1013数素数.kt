/*令 Pi表示第 i 个素数。现任给两个正整数 M≤N≤10^4，请输出PM到PN的所有素数。
输入格式：
  输入在一行中给出 M 和 N，其间以空格分隔。
输出格式：
  输出从PM到PN的所有素数，每 10 个数字占 1 行，其间以空格分隔，但行末不得有多余空格。
输入样例：
5 27
输出样例：
11 13 17 19 23 29 31 37 41 43
47 53 59 61 67 71 73 79 83 89
97 101 103
*/
import java.util.ArrayList
import java.util.Scanner

object PAT_B_1013 {
    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        val M = scanner.nextInt()
        val N = scanner.nextInt()
        val list: List<Int>
        list = GetnPrimeList(N)
        for (i in M - 1 until N) {
            print(list[i])
            if ((i - M + 2) % 10 != 0) {
                if (i == N - 1) break
                print(" ")
            } else {
                println()
            }
        }
    }

    fun GetnPrimeList(num: Int): List<Int> {
        val list = ArrayList<Int>()
        var startNumber = 1
        while (list.size < num) {
            if (IsPrime(startNumber, list)) {
                list.add(startNumber)
            }
            startNumber++
        }
        return list
    }

    fun IsPrime(num: Int, list: List<Int>): Boolean {
        if (num == 1) {
            return false
        }
        val max = Math.sqrt(num.toDouble()).toInt()
        for (n in list) {
            if (num % n == 0) {
                return false
            }
            if (n > max) {
                break
            }
        }
        return true
    }
}

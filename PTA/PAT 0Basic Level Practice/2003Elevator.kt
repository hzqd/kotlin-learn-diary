/*The highest building in our city has only one elevator. A request list is made up with N positive numbers. The numbers denote at which floors the elevator will stop, in specified order. It costs 6 seconds to move the elevator up one floor, and 4 seconds to move down one floor. The elevator will stay for 5 seconds at each stop.
  For a given request list, you are to compute the total time spent to fulfill the requests on the list. The elevator is on the 0th floor at the beginning and does not have to return to the ground floor when the requests are fulfilled.
Input Specification:
  Each input file contains one test case. Each case contains a positive integer N, followed by N positive numbers. All the numbers in the input are less than 100.
Output Specification:
  For each test case, print the total time on a single line.
Sample Input:
3 2 3 1
Sample Output:
41
*/
//import java.util.Scanner
//fun main(args: Array<String>) {
//    val sc = Scanner(System.`in`)
//    val n = sc.nextInt()
//    var a = 0
//    var b = 0
//    var c = 0
//    var ans = n * 5
//    for (i in 0 until n) {
//        a = b
//        b = sc.nextInt()
//        c = b - a
//        if (c < 0)
//            ans += 4 * Math.abs(c)
//        else
//            ans += 6 * c
//    }
//    print(ans)
//}
import java.io.BufferedReader
import java.io.InputStreamReader
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val line = br.readLine().split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val num = Integer.valueOf(line[0])!!
    val floor = IntArray(num)
    for (i in 1..num) {
        floor[i - 1] = Integer.valueOf(line[i])!!
    }
    br.close()
    var total = 0
    var now = 0
    for (i in floor) {
        if (i > now) {
            total = total + 5 + 6 * (i - now)
            now = i
        } else if (i < now) {
            total = total + 5 + 4 * (now - i)
            now = i
        } else if (i == now) {
            total = total + 5
        }
    }
    print(total)
}

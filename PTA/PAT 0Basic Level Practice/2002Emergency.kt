/*As an emergency rescue team leader of a city, you are given a special map of your country. The map shows several scattered cities connected by some roads. Amount of rescue teams in each city and the length of each road between any pair of cities are marked on the map. When there is an emergency call to you from some other city, your job is to lead your men to the place as quickly as possible, and at the mean time, call up as many hands on the way as possible.
Input Specification:
  Each input file contains one test case. For each test case, the first line contains 4 positive integers: N (≤500) - the number of cities (and the cities are numbered from 0 to N−1), M - the number of roads, C1 and C2- the cities that you are currently in and that you must save, respectively. The next line contains N integers, where the i-th integer is the number of rescue teams in the i-th city. Then M lines follow, each describes a road with three integers c1 , c2and L, which are the pair of cities connected by a road and the length of that road, respectively. It is guaranteed that there exists at least one path from C1 to C2.
Output Specification:
  For each test case, print in one line two numbers: the number of different shortest paths between C1 and C2, and the maximum amount of rescue teams you can possibly gather. All the numbers in a line must be separated by exactly one space, and there is no extra space allowed at the end of a line.
Sample Input:
5 6 0 2
1 2 1 5 3
0 1 1
0 2 2
0 3 1
1 2 1
2 4 1
3 4 1
Sample Output:
2 4
*/
//import java.util.*
//internal var n = 0
//internal var m = 0
//internal var c1 = 0
//internal var c2 = 0
//internal var map = Array(505) { IntArray(505) }
//internal var weight = IntArray(505)
//internal var dist = IntArray(505)
//internal var visit = BooleanArray(505)
//internal var num = IntArray(505)
//internal var w = IntArray(505)
//internal val inf = 9999999
//fun main(args: Array<String>) {
//    Arrays.fill(dist, inf)
//    var i = 0
//    var j = 0
//    var k = 0
//    i = 0
//    while (i < 505) {
//        Arrays.fill(map[i], inf)
//        i++
//    }
//    val cin = Scanner(System.`in`)
//    n = cin.nextInt()
//    m = cin.nextInt()
//    c1 = cin.nextInt()
//    c2 = cin.nextInt()
//    i = 0
//    while (i < n) {
//        weight[i] = cin.nextInt()
//        i++
//    }
//    i = 0
//    while (i < m) {
//        val x = cin.nextInt()
//        val y = cin.nextInt()
//        val z = cin.nextInt()
//        map[y][x] = z
//        map[x][y] = map[y][x]
//        i++
//    }
//    dist[c1] = 0
//    w[c1] = weight[c1]
//    num[c1] = 1
//    i = 0
//    while (i < n) {
//        var index = -1
//        var min = inf
//        j = 0
//        while (j < n) {
//            if (visit[j] == false && dist[j] < min) {
//                min = dist[j]
//                index = j
//            }
//            j++
//        }
//        if (index == -1) break
//        visit[index] = true
//        k = 0
//        while (k < n) {
//            if (visit[k] == false && map[index][k] != inf) {
//                if (dist[index] + map[index][k] < dist[k]) {
//                    dist[k] = dist[index] + map[index][k]
//                    num[k] = num[index]
//                    w[k] = w[index] + weight[k]
//                } else if (dist[index] + map[index][k] == dist[k]) {
//                    num[k] = num[k] + num[index]
//                    if (w[index] + weight[k] > w[k]) {
//                        w[k] = w[index] + weight[k]
//                    }
//                }
//            }
//            k++
//        }
//        i++
//    }
//    System.out.printf("%d %d", num[c2], w[c2])
//}
import java.util.*
internal var n = 0
internal var m = 0
internal var c1 = 0
internal var c2 = 0
internal var map = Array(505) { IntArray(505) }
internal var weight = IntArray(505)
internal var visit = Array(505) { BooleanArray(505) }
internal var anspath = 0
internal var minpath = 99999
internal var answeight = 0
fun main(args: Array<String>) {
    var i = 0
    val j = 0
    val cin = Scanner(System.`in`)
    n = cin.nextInt()
    m = cin.nextInt()
    c1 = cin.nextInt()
    c2 = cin.nextInt()
    i = 0
    while (i < n) {
        weight[i] = cin.nextInt()
        i++
    }
    i = 0
    while (i < m) {
        val x = cin.nextInt()
        val y = cin.nextInt()
        val z = cin.nextInt()
        map[y][x] = z
        map[x][y] = map[y][x]
        i++
    }
    dfs(c1, 0, weight[c1])
    System.out.printf("%d %d", anspath, answeight)
}
internal fun dfs(start: Int, path: Int, weights: Int) {
    //System.out.printf("%d %d %d\n",start,path,weights);
    if (start == c2) {
        if (path < minpath) {
            minpath = path
            anspath = 1
            answeight = weights
        } else if (path == minpath) {
            anspath++
            if (weights > answeight) {
                answeight = weights
            }
        }
        return
    }
    if (path > minpath) return
    for (i in 0 until n) {
        if (visit[start][i] == false && map[start][i] != 0) {
            visit[i][start] = true
            visit[start][i] = visit[i][start]
            dfs(i, path + map[start][i], weights + weight[i])
            visit[i][start] = false
            visit[start][i] = visit[i][start]
        }
    }
    return
}

/*A family hierarchy is usually presented by a pedigree tree. Your job is to count those family members who have no child.
Input Specification:
  Each input file contains one test case. Each case starts with a line containing 0<N<100, the number of nodes in a tree, and M (<N), the number of non-leaf nodes. Then M lines follow, each in the format:
  ID K ID[1] ID[2] ... ID[K]
  where ID is a two-digit number representing a given non-leaf node, K is the number of its children, followed by a sequence of two-digit ID's of its children. For the sake of simplicity, let us fix the root ID to be 01.
  The input ends with N being 0. That case must NOT be processed.
Output Specification:
  For each test case, you are supposed to count those family members who have no child for every seniority level starting from the root. The numbers must be printed in a line, separated by a space, and there must be no extra space at the end of each line.
  The sample case represents a tree with only 2 nodes, where 01 is the root and 02 is its only child. Hence on the root 01 level, there is 0 leaf node; and on the next level, there is 1 leaf node. Then we should output 0 1 in a line.
Sample Input:
2 1
01 1 02
Sample Output:
0 1
*/
//import java.util.ArrayList
//import java.util.HashMap
//import java.util.Scanner
//fun main(args: Array<String>) {
//    val input = Scanner(System.`in`)
//    //输入操作
//    val n = input.nextInt()
//    val m = input.nextInt()
//    var i = 0
//    var j = 0
//    var child: Int
//    var id: Int
//    var k: Int//id指本结点编号，child指孩子结点编号，k为孩子结点数目
//    var list: ArrayList<Int>
//    val map = HashMap<Int, ArrayList<Int>>()//用map来存储这个结构
//    val record = IntArray(n)//记录每层叶子结点数目的结果数组，由于结点只有n个，所以最多n层
//    while (i < m) {
//        id = input.nextInt()
//        k = input.nextInt()
//        list = ArrayList()
//        j = 0
//        while (j < k) {
//            child = input.nextInt()
//            list.add(child)
//            j++
//        }
//        map[id] = list
//        i++
//    }
//    val p = DFS(map, record, 1, 0, 0)
//    i = 0
//    while (i < p) {
//        print(record[i].toString() + " ")
//        i++
//    }
//    print(record[i])
//}
////map为该树结构，record数组用于记录结果，node为当前遍历到的结点，level为当前层是第几层，height用来记录树高度，为最后输出作准备
//fun DFS(map: Map<Int, ArrayList<Int>>, record: IntArray, node: Int, level: Int, height: Int): Int {
//    var height = height
//    val list = map[node]
//    if (list == null) {
//        record[level]++//每次遇到叶子结点，相应层数记录+1
//        return height
//    }
//    for (i in list.indices) {
//        height = Math.max(height, DFS(map, record, list[i], level + 1, level + 1))
//    }
//    return height
//}
import java.util.Scanner
import java.util.ArrayList
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n: Int
    val m: Int//n是节点个数,M是非叶子节点个数
    n = sc.nextInt()
    m = sc.nextInt()
    val tree = ArrayList<ArrayList<Int>>()//用数组结构表示树结构
    val visited = IntArray(n)
    for (i in 0 until n) {//初始化树结构
        tree.add(ArrayList())//加入代表缺省父节点的-1
        tree[i].add(-1)
        visited[i] = 0
    }
    var tempNo: Int//代表非叶子节点的代号
    var tempNum: Int//代表非叶子节点的子节点个数
    for (i in 0 until m) {
        tempNo = sc.nextInt() - 1
        tree[tempNo].add(-1)
        //加入代表缺省层数的-1
        tempNum = sc.nextInt()
        for (j in 0 until tempNum) {
            tree[tempNo].add(sc.nextInt() - 1)//加入子节点代号
        }
    }
    for (i in 0 until n) {
        if (tree[i].size < 2) {
            tree[i].add(-1)
        }
    }
    var nextPoint: Int
    for (j in tree.indices) {
        if (tree[j].size > 2) {
            for (i in 0 until tree[j].size - 2) {
                nextPoint = tree[j][i + 2]
                tree[nextPoint][0] = j//初始化各个节点的父节点
            }
        }
    }
    val path = ArrayList<Int>()//深度搜索的栈
    path.add(0)
    visited[0] = 1
    tree[0][1] = 0
    val total = IntArray(n)
    for (i in 0 until n) {
        total[i] = -1
    }
    var have: Int
    var topNode: Int//栈顶的元素编号
    var level = 1
    while (path.size > 0) {
        var put = false
        topNode = path[path.size - 1]
        have = 0
        for (i in tree.indices) {
            if (tree[i][0] == topNode && visited[i] == 0 && !put) {
                path.add(i)//将节点入栈
                tree[i][1] = path.size - 1//更新节点的层数
                put = true
                visited[i] = 1
                if (path.size > level) {
                    level = path.size
                }
            } else if (tree[i][0] == topNode && visited[i] == 1) {
                have = 1
            }
        }
        if (!put) {
            if (have == 1) {
                path.removeAt(path.size - 1)
            } else if (have == 0) {
                path.removeAt(path.size - 1)
                if (total[path.size] == -1) {
                    total[path.size] = 1
                } else
                    total[path.size]++
            }
        }
    }
    var output = ""
    for (i in 0 until level) {
        if (total[i] == -1) total[i] = 0
        if (i != 0) {
            output += " "
            output += total[i].toString()
        } else {
            output += total[i].toString()
        }
    }
    print(output)
    sc.close()
}

/*卡拉兹(Callatz)猜想已经在1001中给出了描述。在这个题目里，情况稍微有些复杂。
  当我们验证卡拉兹猜想的时候，为了避免重复计算，可以记录下递推过程中遇到的每一个数。例如对 n=3 进行验证的时候，我们需要计算 3、5、8、4、2、1，则当我们对 n=5、8、4、2 进行验证的时候，就可以直接判定卡拉兹猜想的真伪，而不需要重复计算，因为这 4 个数已经在验证3的时候遇到过了，我们称 5、8、4、2 是被 3“覆盖”的数。我们称一个数列中的某个数 n 为“关键数”，如果 n 不能被数列中的其他数字所覆盖。
  现在给定一系列待验证的数字，我们只需要验证其中的几个关键数，就可以不必再重复验证余下的数字。你的任务就是找出这些关键数字，并按从大到小的顺序输出它们。
输入格式：
  每个测试输入包含 1 个测试用例，第 1 行给出一个正整数 K (<100)，第 2 行给出 K 个互不相同的待验证的正整数 n (1<n≤100)的值，数字间用空格隔开。
输出格式：
  每个测试用例的输出占一行，按从大到小的顺序输出关键数字。数字间用 1 个空格隔开，但一行中最后一个数字后没有空格。
输入样例：
6
3 5 6 7 8 11
输出样例：
7 6
*/
import java.util.ArrayList
import java.util.Collections
import java.util.Scanner
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val a1 = IntArray(n)                //进行操作的数组
    val a2 = IntArray(n)
    val alist1 = ArrayList<Int>()       //被覆盖数
    val alist2 = ArrayList<Int>()       //关键数
    for (i in 0 until n) { a2[i] = sc.nextInt() ; a1[i] = a2[i]
        while(a1[i]!=1){                //将覆盖数添加到alist1中
            if(a1[i]%2==0){a1[i]/=2;if(!alist1.contains(a1[i])) alist1.add(a1[i]) else break}
            else{a1[i]=(3*a1[i]+1)/2;if(!alist1.contains(a1[i])) alist1.add(a1[i])else break}}}
    for (i in a2.indices) {             //遍历输入的数组
        if (!alist1.contains(a2[i])) {  //在覆盖数中没有的话
            alist2.add(a2[i])}}         //添加到alist2 即关键数
    Collections.sort(alist2)
    if (alist2.size == 1) println(alist2[0])
    else{for(i in alist2.indices.reversed()){print(alist2[i]);if(i!=0)print(" ")};println()}}

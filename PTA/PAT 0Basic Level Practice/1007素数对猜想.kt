/*让我们定义dn为：dn=pn+1-pn，其中pi是第i个素数。显然有d1=1，且对n>1有dn是偶数。“素数对猜想”认为“存在无穷多对相邻且差为2的素数”。
  现给定任意正整数N(<10^5)，请计算不超过N的满足猜想的素数对的个数。
输入格式:
  输入在一行给出正整数N。
输出格式:
  在一行中输出不超过N的满足猜想的素数对的个数。
输入样例:
20
输出样例:
4
*/
/**素数表的创建思路：
 * 建一个数组，用数组索引表示数字，值为0表示该数不是素数，值为1表示该数是素数
 * 初始化数组，将数组里的元素都赋值为1
 * 从索引2开始往后遍历（0和1不是素数），只要索引对应的值为1，则将它的倍数索引都赋值为1
 */
import java.util.Scanner import java.util.Arrays
fun main(args: Array<String>) {val `in` = Scanner(System.`in`)
    val num = `in`.nextInt()//接收输入的数字
    val prime = IntArray(100005)//代表素数的数组，索引对应的值为1的是素数
    Arrays.fill(prime,1)//将数组初始化填充1
    for (i in 2 until prime.size){//从索引2开始往后遍历（0和1不是素数），只要索引对应的值为1，则将它的倍数索引都赋值为1
        if(prime[i]==1){var j=i+i;while(j<prime.size){prime[j]=0;j=j+i}}};var sum = 0//计算素数对
    for (i in 2..num - 2) {//从2开始往后遍历，如果某索引对应的值为1，切索引+2对应的值也是1，则构成一对素数对
        if(prime[i] == 1 && prime[i + 2] == 1) sum++ } ; println(sum)//输出素数对的个数
}

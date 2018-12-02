/*某公司员工的工资计算方法如下：一周内工作时间不超过40小时，按正常工作时间计酬；超出40小时的工作时间部分，按正常工作时间报酬的1.5倍计酬。员工按进公司时间分为新职工和老职工，进公司不少于5年的员工为老职工，5年以下的为新职工。新职工的正常工资为30元/小时，老职工的正常工资为50元/小时。请按该计酬方式计算员工的工资。
输入格式：
  输入在一行中给出2个正整数，分别为某员工入职年数和周工作时间，其间以空格分隔。
输出格式：
  在一行输出该员工的周薪，精确到小数点后2位。
输入样例1：
  5 40
输出样例1：
  2000.00
输入样例2：
  3 50
输出样例2：
  1650.00
*/
import java.util.Scanner
fun f(year: Int,hour: Int):Double{
  val money: Double
  var rate = 50
  if (year < 5)
    rate = 30
  if (hour <= 40)
    money = (rate * hour).toDouble()
  else
    money = rate * 40 + rate.toDouble() * (hour - 40).toDouble() * 1.5
  return money
}
fun main(agrc: Array<String>){
  val scan = Scanner(System.`in`)
  val year: Int
  val hour: Int
  val money: Double
  year = scan.nextInt()
  hour = scan.nextInt()
  money = f(year, hour)
  System.out.printf("%.2f", money)
}

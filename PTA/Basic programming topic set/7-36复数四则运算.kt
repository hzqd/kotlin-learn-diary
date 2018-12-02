/*本题要求编写程序，计算2个复数的和、差、积、商。
输入格式：
  输入在一行中按照a1 b1 a2 b2的格式给出2个复数C1=a1+b1i和C2=a2+b2i的实部和虚部。题目保证C2不为0。
输出格式：
  分别在4行中按照(a1+b1i) 运算符 (a2+b2i) = 结果的格式顺序输出2个复数的和、差、积、商，数字精确到小数点后1位。如果结果的实部或者虚部为0，则不输出。如果结果为0，则输出0.0。
输入样例1：
2 3.08 -2.04 5.06
输出样例1：
(2.0+3.1i) + (-2.0+5.1i) = 8.1i
(2.0+3.1i) - (-2.0+5.1i) = 4.0-2.0i
(2.0+3.1i) * (-2.0+5.1i) = -19.7+3.8i
(2.0+3.1i) / (-2.0+5.1i) = 0.4-0.6i
输入样例2：
1 1 -1 -1.01
输出样例2：
(1.0+1.0i) + (-1.0-1.0i) = 0.0
(1.0+1.0i) - (-1.0-1.0i) = 2.0+2.0i
(1.0+1.0i) * (-1.0-1.0i) = -2.0i
(1.0+1.0i) / (-1.0-1.0i) = -1.0
*/
//程序通过编译,答案错误.
import java.util.Scanner
fun main(args: Array<String>) {//处理了表达式，其实很简单
    val sc = Scanner(System.`in`)
    val ope = Operation()
    println("请输入两个复数的实部与虚部：")
    val a1 = sc.nextDouble()//实部
    val b1 = sc.nextDouble()//虚部
    val a2 = sc.nextDouble()
    val b2 = sc.nextDouble()
    ope.add(a1, b1, a2, b2)
    ope.sub(a1, b1, a2, b2)
    ope.muti(a1, b1, a2, b2)
    ope.div(a1, b1, a2, b2)
}
internal class Operation {
    fun add(a1: Double, b1: Double, a2: Double, b2: Double) {//1.虚部实部为0判断 2.虚部符号判断
        if (a1 + a2 < 0.05 && a1 + a2 > -0.05 && b1 + b2 < 0.05 && b1 + b2 > -0.05)
        //优先考虑最极端情况//由于保留一位，还是四舍五入，所以考虑范围是0.05,判断条件还可以优化，调用Math.abs（绝对值判断范围，代码可读性较好点）
            System.out.printf("(%.1f+%.1fi)+(%.1f+%.1fi)=0.0\n", a1, b1, a2, b2)
        else if (a1 + a2 < 0.05 && a1 + a2 > -0.05)
            System.out.printf("(%.1f+%.1fi)+(%.1f+%.1fi)=%.1fi\n", a1, b1, a2, b2, b1 + b2)
        else if (b1 + b2 < 0.05 && b1 + b2 > -0.05)
            System.out.printf("(%.1f+%.1fi)+(%.1f+%.1fi)=%.1f\n", a1, b1, a2, b2, a1 + a2)
        else if (b1 + b2 > -0.05)
            System.out.printf("(%.1f+%.1fi)+(%.1f+%.1fi)=%.1f+%.1fi\n", a1, b1, a2, b2, a1 + a2, b1 + b2)
        else
        //虚部小于零不用输出加号
            System.out.printf("(%.1f+%.1fi)+(%.1f+%.1fi)=%.1f%.1fi\n", a1, b1, a2, b2, a1 + a2, b1 + b2)
    }
    fun sub(a1: Double, b1: Double, a2: Double, b2: Double) {
        if (a1 - a2 < 0.05 && a1 - a2 > -0.05 && b1 - b2 < 0.05 && b1 - b2 > -0.05)
            System.out.printf("(%.1f+%.1fi)-(%.1f+%.1fi)=0.0\n", a1, b1, a2, b2)
        else if (a1 - a2 < 0.05 && a1 - a2 > -0.05)
            System.out.printf("(%.1f+%.1fi)-(%.1f+%.1fi)=%.1fi\n", a1, b1, a2, b2, b1 - b2)
        else if (b1 - b2 < 0.05 && b1 - b2 > -0.05)
            System.out.printf("(%.1f+%.1fi)-(%.1f+%.1fi)=%.1f\n", a1, b1, a2, b2, a1 - a2)
        else if (b1 - b2 > -0.05)
            System.out.printf("(%.1f+%.1fi)-(%.1f+%.1fi)=%.1f+%.1fi\n", a1, b1, a2, b2, a1 - a2, b1 - b2)
        else
        //虚部小于零不用输出加号
            System.out.printf("(%.1f+%.1fi)-(%.1f+%.1fi)=%.1f%.1fi\n", a1, b1, a2, b2, a1 - a2, b1 - b2)
    }
    fun muti(a1: Double, b1: Double, a2: Double, b2: Double) {
        if (a1 * a2 - b1 * b2 < 0.05 && a1 * a2 - b1 * b2 > -0.05 && a2 * b1 + a1 * b2 < 0.05 && a2 * b1 + a1 * b2 > -0.05)
            System.out.printf("(%.1f+%.1fi)*(%.1f+%.1fi)=0.0\n", a1, b1, a2, b2)
        else if (a1 * a2 - b1 * b2 < 0.05 && a1 * a2 - b1 * b2 > -0.05)
        //i的平方为-1
            System.out.printf("(%.1f+%.1fi)*(%.1f+%.1fi)=%.1fi\n", a1, b1, a2, b2, a2 * b1 + a1 * b2)
        else if (a2 * b1 + a1 * b2 < 0.05 && a2 * b1 + a1 * b2 > -0.05)
            System.out.printf("(%.1f+%.1fi)*(%.1f+%.1fi)=%.1f\n", a1, b1, a2, b2, a1 * a2 - b1 * b2)
        else if (a2 * b1 + a1 * b2 > -0.05)
            System.out.printf("(%.1f+%.1fi)*(%.1f+%.1fi)=%.1f+%.1fi\n", a1, b1, a2, b2, a1 * a2 - b1 * b2, a2 * b1 + a1 * b2)
        else
        //虚部小于零不用输出加号
            System.out.printf("(%.1f+%.1fi)*(%.1f+%.1fi)=%.1f%.1fi\n", a1, b1, a2, b2, a1 * a2 - b1 * b2, a2 * b1 + a1 * b2)
    }
    fun div(a1: Double, b1: Double, a2: Double, b2: Double) {//除法麻烦点，要构造平方差使分母为a2和b2的平方和，再简化分子
        if ((a1 * a2 + b1 * b2) / (a2 * a2 + b2 * b2) < 0.05 && (a1 * a2 + b1 * b2) / (a2 * a2 + b2 * b2) > -0.05 && (b1 * a2 - a1 * b2) / (a2 * a2 + b2 * b2) < 0.05 && (b1 * a2 - a1 * b2) / (a2 * a2 + b2 * b2) > -0.05)
            System.out.printf("(%.1f+%.1fi)/(%.1f+%.1fi)=0.0\n", a1, b1, a2, b2)
        else if ((a1 * a2 + b1 * b2) / (a2 * a2 + b2 * b2) < 0.05 && (a1 * a2 + b1 * b2) / (a2 * a2 + b2 * b2) > -0.05)
            System.out.printf("(%.1f+%.1fi)/(%.1f+%.1fi)=%.1fi\n", a1, b1, a2, b2, (b1 * a2 - a1 * b2) / (a2 * a2 + b2 * b2))
        else if ((b1 * a2 - a1 * b2) / (a2 * a2 + b2 * b2) < 0.05 && (b1 * a2 - a1 * b2) / (a2 * a2 + b2 * b2) > -0.05)
            System.out.printf("(%.1f+%.1fi)/(%.1f+%.1fi)=%.1f\n", a1, b1, a2, b2, (a1 * a2 + b1 * b2) / (a2 * a2 + b2 * b2))
        else if ((b1 * a2 - a1 * b2) / (a2 * a2 + b2 * b2) > -0.05)
            System.out.printf("(%.1f+%.1fi)/(%.1f+%.1fi)=%.1f+%.1fi\n", a1, b1, a2, b2, (a1 * a2 + b1 * b2) / (a2 * a2 + b2 * b2), (b1 * a2 - a1 * b2) / (a2 * a2 + b2 * b2))
        else
        //虚部小于零不用输出加号
            System.out.printf("(%.1f+%.1fi)/(%.1f+%.1fi)=%.1f%.1fi\n", a1, b1, a2, b2, (a1 * a2 + b1 * b2) / (a2 * a2 + b2 * b2), (b1 * a2 - a1 * b2) / (a2 * a2 + b2 * b2))
    }
}

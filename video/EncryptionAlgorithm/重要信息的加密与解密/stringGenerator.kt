import org.apache.commons.lang3.RandomStringUtils.randomAscii

fun main() {
    while (true) {
        println("请输入随机生成字符串的位数:")
        readLine()!!.run { randomAscii(toInt()) }.let(::println)
    }
}
